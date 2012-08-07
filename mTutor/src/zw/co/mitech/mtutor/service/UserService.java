package zw.co.mitech.mtutor.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.User;
import zw.co.mitech.mtutor.session.UserFacade;
import zw.co.mitech.mtutor.util.Txt;


@Service("userService")
public class UserService implements Processor, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserFacade userFacade;

	
	
	
	public User addUser(User user){
		
		userFacade.create(user);
		return user;
		
	}




	@Override
	public Txt processTxtRequest(Txt txt) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userFacade.getUsers();
	}
	
	
	
	
	
	
	
}
