package zw.co.mitech.mtutor.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import zw.co.mitech.mtutor.entities.AcademicLevel;
import zw.co.mitech.mtutor.service.AcademicLevelService;

public class GradeTag extends TagSupport{

private static final long serialVersionUID = 1L;
private AcademicLevel grade;
private Long gradeId;

private static AcademicLevelService gradeService;

private WebApplicationContext _applicationContext;








public static AcademicLevelService getGradeService() {
	return gradeService;
}








public static void setGradeService(AcademicLevelService gradeService) {
	GradeTag.gradeService = gradeService;
}








public AcademicLevel getGrade() {
	return grade;
}








public void setGrade(AcademicLevel grade) {
	this.grade = grade;
}








public Long getGradeId() {
	return gradeId;
}








public void setGradeId(Long gradeId) {
	this.gradeId = gradeId;
}








@Override
public int doStartTag() throws JspException {
	// TODO Auto-generated method stub
	 try {
         //Get the writer object for output.
         JspWriter out = pageContext.getOut();
         _applicationContext = RequestContextUtils.getWebApplicationContext(
     			pageContext.getRequest(),
     			pageContext.getServletContext()
     		);
         //Perform substr operation on string.
         System.out.println("Let me cee the id please Id>>>>>>>>>>>>>"+gradeId);
         System.out.println("topic service >>>>"+gradeService);
         gradeService=_applicationContext.getBean(AcademicLevelService.class);
         System.out.println("topic service >>>>"+gradeService);
         grade = gradeService.getGradeById(gradeId);
         System.out.println("Topic >>>>>"+grade);
         out.println(grade.getLevelName());

     } catch (IOException e) {
         e.printStackTrace();
     }
     return SKIP_BODY;
}





}
