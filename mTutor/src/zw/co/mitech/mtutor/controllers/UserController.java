package zw.co.mitech.mtutor.controllers;

import java.util.List;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.User;
import zw.co.mitech.mtutor.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	

	  @RequestMapping(method = RequestMethod.POST)
	    public ModelAndView addUser(@Valid User user, BindingResult result,Model model) {
	 
		  if(result.hasErrors()) {
			  return new ModelAndView("users/edit", "user", user);
			  }
		  System.out.println("User>>>>>>>>>>>>"+user);
	        userService.addUser(user);
	 
	       // return gotoListPage(model);
	        return new ModelAndView("users/view", "user", user);
	        
	    }
	 


	@RequestMapping(method=RequestMethod.GET, params="new")
	//@RequestMapping("/users/edit")
	public String createNewUser(Model model){
		 model.addAttribute(new User());
		return "users/edit";
	}

	
	@RequestMapping(method = RequestMethod.GET, params="list")
	public String listUsers(Model model) {
		
		List<User> users = userService.getUsers();
		System.out.println(">>>>>>>>>>>>users>>>>>>>"+users);
		if(users!=null){
			System.out.println("Size>>>>>>>>>>>>"+users.size());
		}
		model.addAttribute(users);
		
		return "users/list";
	}



	public String gotoListPage(Model model) {
		List<User> users = userService.getUsers();
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
