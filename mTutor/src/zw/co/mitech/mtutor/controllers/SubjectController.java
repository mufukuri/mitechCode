package zw.co.mitech.mtutor.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import zw.co.mitech.mtutor.entities.AcademicLevel;
import zw.co.mitech.mtutor.entities.Concept;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.service.AcademicLevelService;
import zw.co.mitech.mtutor.service.SubjectService;
import zw.co.mitech.mtutor.service.TopicService;

@Controller
@RequestMapping("/subjects")
public class SubjectController{

	
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private AcademicLevelService academicService;
	
	@Autowired
	private TopicService topicService;
	
	 @RequestMapping(method = RequestMethod.POST)
	    public ModelAndView addUser(@Valid Subject subject, BindingResult result,Model model) {
	 
		  if(result.hasErrors()) {
			
			  return new ModelAndView("subjects/edit", "subject", subject);
			  }

		subjectService.addSubject(subject);
	 
	        return new ModelAndView("subjects/view", "subject", subject);
	    }
	 


	@RequestMapping(method=RequestMethod.GET, params="new")

	public String createNewSchool(Model model){
		 model.addAttribute(new Subject());
		return "subjects/edit";
	}

	
	@RequestMapping( method = RequestMethod.GET,params="list")
	public String listSubjects(Model model) {
		System.out.println("Subjects");
		Set<Subject> subjects= subjectService.getSubjects();
	
		
		model.addAttribute(subjects);
		
		return "subjects/list";
	}
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
public String showTopics(@PathVariable Long id, Model model, HttpServletRequest request){
		
System.out.println("Subject Id >>>>>>"+id);
		
		List<Topic> topics= topicService.getTopicsBySubjectOrderedByGrade(id);
		request.getSession().setAttribute("subjectId", id);
	request.setAttribute("subjectId", id);
		
		model.addAttribute(topics);
		System.out.println(model.containsAttribute("topics"));
		//return "topics/viewTopics";
	
		return "redirect:/topics";
}
	
	
	/*
	@Override
	protected Map<String, Map<String, String>> referenceData(HttpServletRequest request) throws Exception {
 
		Map referenceData = new HashMap();
 
 
		//Data referencing for country dropdown box
		Map<String,String> subjects = new LinkedHashMap<String,String>();
		subjects.put("Maths", "Maths");
		
		referenceData.put("subjectsList", subjects);
 
		//Data referencing for java skills list box
		Map<String,String> grades = new LinkedHashMap<String,String>();
		grades.put("1", "1");
		grades.put("2", "2");
		
		referenceData.put("gradesList", grades);
 
		return referenceData;
	}*/

	/*@ModelAttribute("subjectList")
	public Map<String,String> populateWebFrameworkList() {
 
		//Data referencing for web framework checkboxes
		Map<String,String> subjects = new LinkedHashMap<String,String>();
		subjects.put("Maths", "Maths");
 
		return subjects;
	}*/

	@RequestMapping(method=RequestMethod.POST, params = "cancel")
	public ModelAndView cancel(Model model, HttpServletRequest request) {
		
		Set<Subject> subjects= subjectService.getSubjects();
		
		
		model.addAttribute(subjects);
	
		return new ModelAndView("subjects/list","subjects",subjects);
		
		} 
		


	

	
	@ModelAttribute("subjects")
	public Map<Long,String> populateSubjectsList() {
 Set<Subject> subjectsList = subjectService.getSubjects();
 Map<Long,String> subjects = new LinkedHashMap<Long,String>();
 for(Subject subject: subjectsList){
	 subjects.put(new Long(subject.getId()), subject.getName());
 }
		//Data referencing for web framework checkboxes
		
		
		return subjects;
	}
	
	
	@ModelAttribute("grades")
	public Map<Long,String> populateGradesList() {
 Set<AcademicLevel> gradesList = academicService.getAllGrades();
 Map<Long,String> grades = new LinkedHashMap<Long,String>();
 for(AcademicLevel grade: gradesList){
	 grades.put(new Long(grade.getId()), grade.getLevelName());
 }
		//Data referencing for web framework checkboxes
		
		
		return grades;
	}
}
