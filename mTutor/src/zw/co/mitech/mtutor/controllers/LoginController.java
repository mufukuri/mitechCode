package zw.co.mitech.mtutor.controllers;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/login")
public class LoginController {
  @RequestMapping(value="/login",method=GET)
  public String showLoginForm() {
	return "login";
	  
  }
  
  
  
  @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		
		return "login";

	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}
}