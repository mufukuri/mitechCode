package zw.co.mitech.mtutor.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.School;
import zw.co.mitech.mtutor.session.SchoolFacade;

@Service("schoolService")
public class SchoolService implements Serializable {
	@Autowired
	private SchoolFacade schoolFacade;

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

}
