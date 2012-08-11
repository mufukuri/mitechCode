package zw.co.mitech.mtutor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.School;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.service.SchoolService;
import zw.co.mitech.mtutor.service.SubjectService;
import zw.co.mitech.mtutor.util.Txt;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

	
	@Autowired
	private SubjectService subjectService;
	
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
	public String listUsers(Model model) {
		
		List<Subject> subjects= subjectService.getSubjects();
	
		
		model.addAttribute(subjects);
		
		return "subjects/list";
	}




}
