package zw.co.mitech.mtutor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zw.co.mitech.mtutor.entities.User;
import zw.co.mitech.mtutor.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	

	  @RequestMapping(value = "/users/add", method = RequestMethod.POST)
	    public String addUser(@ModelAttribute("user")
	    User user, BindingResult result) {
	 
	        userService.addUser(user);
	 
	        return "redirect:/index";
	    }
	 


	@RequestMapping(method=RequestMethod.GET, params="new")
	//@RequestMapping("/users/edit")
	public String createNewUser(Model model){
		 model.addAttribute(new User());
		return "users/edit";
	}

	
	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public String listSpittlesForSpitter(Model model) {
		
		List<User> users = userService.getUsers();
		System.out.println(">>>>>>>>>>>>users>>>>>>>"+users);
		if(users!=null){
			System.out.println("Size>>>>>>>>>>>>"+users.size());
		}
		model.addAttribute(users);
		
		return "users/list";
	}

	
	
	
	
	/*@RequestMapping(method=RequestMethod.POST)
	  public String addSpitterFromForm(@Valid User user, BindingResult bindingResult) {
	    
	    if(bindingResult.hasErrors()) {
	      return "users/edit";
	    } 
	    
	    userService.saveUser(user);
	    
	   

	    return "redirect:/users/view";
	  }  */
	
}
