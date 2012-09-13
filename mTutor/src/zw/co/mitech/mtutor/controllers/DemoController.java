package zw.co.mitech.mtutor.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping(method=RequestMethod.GET, params="studentReport")

	public String viewStudentRecords(){
		return "demo/studentReport";
	}

}
