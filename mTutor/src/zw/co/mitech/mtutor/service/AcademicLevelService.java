package zw.co.mitech.mtutor.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.AcademicLevel;
import zw.co.mitech.mtutor.session.AcademicLevelFacade;

@Service("academicLevelService")
public class AcademicLevelService {
	
	@Autowired
	private AcademicLevelFacade facade;
	
	
	
	public Set<AcademicLevel> getAllGrades(){
		Set<AcademicLevel> grades = new HashSet<AcademicLevel>(facade.findAll());
		return grades;
	}



	public AcademicLevel getGradeById(Long gradeId) {
		// TODO Auto-generated method stub
		return facade.find(gradeId);
	}

}
