package zw.co.mitech.mtutor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.util.Txt;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	
	@RequestMapping("/subject")
	public String showPage(){
		System.out.println("Request sent got subjects");
		ModelAndView modelAndView = new ModelAndView();
		
		return "subject";
	}

	@RequestMapping("/page")
	public ModelAndView showSubjectPage() {
		ModelAndView modelAndView = new ModelAndView("subject");
		modelAndView.addObject("txt", new Txt());
		return modelAndView;
	}
	
}
