package zw.co.mitech.mtutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.AcademicLevel;
import zw.co.mitech.mtutor.session.AcademicLevelFacade;

@Service("academicLevelService")
public class AcademicLevelService {
	
	@Autowired
	private AcademicLevelFacade facade;
	
	
	
	public List<AcademicLevel> getAllGrades(){
		return facade.findAll();
	}

}
