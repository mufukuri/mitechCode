package zw.co.mitech.mtutor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zw.co.mitech.mtutor.entities.School;
import zw.co.mitech.mtutor.service.SchoolService;

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
		System.out.println(">>>>>>>>>>>>Schools>>>>>>>"+schools);
		if(schools!=null){
			System.out.println("Size>>>>>>>>>>>>"+schools.size());
		}
		model.addAttribute(schools);
		
		return "schools/list";
	}



	public String gotoListPage(Model model) {
		List<School> school = schoolService.getSchools();
		model.addAttribute(school);
		return "schools/list";
	}


}
