package zw.co.mitech.mtutor.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.session.SubjectFacade;
@Service("subjectService")
public class SubjectService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SubjectFacade facade;

	public void addSubject(Subject subject) {
		facade.create(subject);
		
	}

	public List<Subject> getSubjects() {
		// TODO Auto-generated method stub
		return facade.findAll();
	}

}
