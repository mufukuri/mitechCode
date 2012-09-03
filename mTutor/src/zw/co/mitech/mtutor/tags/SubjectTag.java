package zw.co.mitech.mtutor.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.service.SubjectService;
import zw.co.mitech.mtutor.service.TopicService;

public class SubjectTag extends TagSupport{
private Subject subject;
private Long subjectId;

private static SubjectService subjectService;

private WebApplicationContext _applicationContext;






public static SubjectService getSubjectService() {
	return subjectService;
}
public static void setSubjectService(SubjectService subjectService) {
	SubjectTag.subjectService = subjectService;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
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
         System.out.println("Let me cee the id please Id>>>>>>>>>>>>>"+subjectId);
         System.out.println("topic service >>>>"+subjectService);
         subjectService=_applicationContext.getBean(SubjectService.class);
         System.out.println("topic service >>>>"+subjectService);
         subject = subjectService.getSubjectById(subjectId);
         System.out.println("Topic >>>>>"+subject);
         out.println(subject.getName());

     } catch (IOException e) {
         e.printStackTrace();
     }
     return SKIP_BODY;
}
public Long getSubjectId() {
	return subjectId;
}
public void setSubjectId(Long subjectId) {
	this.subjectId = subjectId;
}





}
