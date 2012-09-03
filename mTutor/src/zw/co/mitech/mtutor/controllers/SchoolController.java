package zw.co.mitech.mtutor.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.School;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.service.SchoolService;
import zw.co.mitech.mtutor.util.ProvinceUtil;

@Controller
@RequestMapping("/schools")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	 @RequestMapping(method = RequestMethod.POST)
	    public String addUser(@Valid School school, BindingResult result,Model model) {
	 
		  if(result.hasErrors()) {
			  return "schools/edit";
			  }
System.out.println("School>>>>>>>>>>>>"+school);
			schoolService.addSchool(school);
	 
	        return gotoListPage(model);
	    }
	 


	@RequestMapping(method=RequestMethod.GET, params="new")

	public String createNewSchool(Model model){
		 model.addAttribute(new School());
		return "schools/edit";
	}

	
	@RequestMapping( method = RequestMethod.GET,params="list")
	public String listUsers(Model model) {
		
		List<School> schools= schoolService.getSchools();
		
		
		model.addAttribute(schools);
		
		return "schools/list";
	}

	@RequestMapping(method=RequestMethod.POST, params = "cancel")
	public ModelAndView cancel(Model model, HttpServletRequest request) {
		
		List<School> schools= schoolService.getSchools();
		model.addAttribute(schools);

		
		return new ModelAndView("schools/list","schools",schools);
		
		} 

	public String gotoListPage(Model model) {
		List<School> school = schoolService.getSchools();
		model.addAttribute(school);
		return "schools/list";
	}

	@ModelAttribute("provinces")
	public Map<String, String> populateSubjectsList() {
		
		Map<String, String> subjects = new TreeMap<String, String>();
		subjects.put(ProvinceUtil.BULAWAYO, ProvinceUtil.BULAWAYO);
		subjects.put(ProvinceUtil.HARARE, ProvinceUtil.HARARE);
		subjects.put(ProvinceUtil.MANICALAND, ProvinceUtil.MANICALAND);
		subjects.put(ProvinceUtil.MASHONALAND_CENTRAL, ProvinceUtil.MASHONALAND_CENTRAL);
		subjects.put(ProvinceUtil.MASHONALAND_EAST, ProvinceUtil.MASHONALAND_EAST);
		subjects.put(ProvinceUtil.MASHONALAND_WEST, ProvinceUtil.MASHONALAND_WEST);
		subjects.put(ProvinceUtil.MASVINGO, ProvinceUtil.MASVINGO);
		subjects.put(ProvinceUtil.MATEBELELAND_NORTH, ProvinceUtil.MATEBELELAND_NORTH);
		subjects.put(ProvinceUtil.MATEBELELAND_SOUTH, ProvinceUtil.MATEBELELAND_SOUTH);
		// Data referencing for web framework checkboxes

		return subjects;
	}

}
