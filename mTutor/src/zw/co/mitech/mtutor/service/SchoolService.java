package zw.co.mitech.mtutor.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.School;
import zw.co.mitech.mtutor.entities.User;
import zw.co.mitech.mtutor.session.SchoolFacade;
import zw.co.mitech.mtutor.session.UserFacade;

@Service("schoolService")
public class SchoolService implements Serializable {
	@Autowired
	private SchoolFacade schoolFacade;
	
	@Autowired
	private UserFacade userFacade;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addSchool(School school) {
		schoolFacade.create(school);
	}

	public List<School> getSchools() {
		return schoolFacade.findAll();
	}

	public List<School> getSchools(String username) {
		User user = userFacade.findUserByUsername(username);
		List<School> schools = new ArrayList<School>();
		if(user.getSchoolId() > 0){
			schools.add(schoolFacade.find(user.getSchoolId()));
		}
		return schools;
	}
	

}
