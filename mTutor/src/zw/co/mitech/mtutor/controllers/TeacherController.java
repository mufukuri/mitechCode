package zw.co.mitech.mtutor.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.School;
import zw.co.mitech.mtutor.entities.SchoolClass;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.entities.Teacher;
import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.entities.User;
import zw.co.mitech.mtutor.service.SchoolService;
import zw.co.mitech.mtutor.session.SchoolClassFacade;
import zw.co.mitech.mtutor.session.SchoolFacade;
import zw.co.mitech.mtutor.session.TeacherFacade;
import zw.co.mitech.mtutor.session.UserFacade;
import zw.co.mitech.mtutor.util.ApplicationConstants;
import zw.co.mitech.mtutor.util.OwnerType;
import zw.co.mitech.mtutor.util.Roles;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SchoolFacade schoolFacade;
	
	@Autowired
	private TeacherFacade teachersFacade;
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private SchoolClassFacade schoolClassFacade;
	
	
	@RequestMapping(method = RequestMethod.GET, params = "new")
	public ModelAndView createNewTeacher(Model model,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView( "teachers/addTeacher");
		prepareTeacherInputPage(new Teacher(), request, modelAndView);
		return modelAndView;
	}
	
	public ModelAndView prepareTeacherInputPage(Teacher teacher,HttpServletRequest request,ModelAndView modelAndView){
		modelAndView.addObject(teacher);
		modelAndView.addObject("schools", getSchoolsList(request.getUserPrincipal().getName(), request.isUserInRole("admin")));
		return modelAndView;
	}
	
	public Map<Long, String> getSchoolsList(String username, boolean viewAll){
		List<School> schoolList = new ArrayList<School>();
		if(viewAll){
			
			schoolList = schoolService.getSchools();
			
		}else{
			schoolList = schoolService.getSchools(username);
		}
		
		Map<Long, String> schools = new LinkedHashMap<Long, String>();
		for (School school : schoolList) {
			schools.put(new Long(school.getId()), school.getSchoolName());
		}
		// Data referencing for web framework checkboxes

		return schools;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addTeacher(@Valid Teacher teacher, BindingResult result,
			Model model, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("teachers/addTeacher");
			return prepareTeacherInputPage(teacher, request, modelAndView);
		}
		
		
		
		String loginId = request.getParameter("loginId");
		
		
		
		User user = userFacade.findUserByUsername(loginId);
		
		if(user != null){
			modelAndView.addObject("loginIdError", " username " + loginId + " is not available");
			modelAndView.setViewName("teachers/addTeacher");
			return prepareTeacherInputPage(teacher, request, modelAndView);
		}
		
		teachersFacade.create(teacher);
		
		user = new User();
		user.setFullName(teacher.getFirstName() + " " + teacher.getSurname());
		user.setOwnerId(""+ teacher.getId());
		user.setUsername(loginId);
		user.setOwnerType(OwnerType.TEACHER);
		user.setRole(Roles.TEACHER);
		user.setPassword(ApplicationConstants.DEFAULT_PASSWORD);
		user.setSchoolId(teacher.getSchoolId());
		
		userFacade.create(user);
		
		modelAndView.setViewName("teachers/view");

		return prepareTeacherViewPage(teacher, request, modelAndView);
	}
	
	
	public ModelAndView prepareTeacherViewPage(Teacher teacher,HttpServletRequest request,ModelAndView modelAndView){
		modelAndView.addObject("teacher",teacher);
		
		School school = schoolFacade.find(teacher.getSchoolId());
		
		User user = userFacade.findUserByOwnerId(""+teacher.getId());
		
		modelAndView.addObject("school", school);
		modelAndView.addObject("user", user);
		
		List<SchoolClass> classList = schoolClassFacade.findClassByTeacherID(teacher.getId());
		
		modelAndView.addObject("classList", classList);
		
		return modelAndView;
	}


}
