package zw.co.mitech.mtutor.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.service.TopicService;

public class TopicTag extends TagSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Topic topic;
private Long topicId;

private static TopicService topicService;

private WebApplicationContext _applicationContext;



public static TopicService getTopicService() {
	return topicService;
}
@Autowired
public static void setTopicService(TopicService topicService) {
	TopicTag.topicService = topicService;
}

public Topic getTopic() {
	return topic;
}

public void setTopic(Topic topic) {
	this.topic = topic;
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
         System.out.println("Let me cee the id please Id>>>>>>>>>>>>>"+topicId);
         System.out.println("topic service >>>>"+topicService);
         topicService=_applicationContext.getBean(TopicService.class);
         System.out.println("topic service >>>>"+topicService);
         topic = topicService.getTopicById(topicId);
         System.out.println("Topic >>>>>"+topic);
         out.println(topic.getTopicName());

     } catch (IOException e) {
         e.printStackTrace();
     }
     return SKIP_BODY;
}



public Long getTopicId() {
	return topicId;
}

public void setTopicId(Long topicId) {
	this.topicId = topicId;
}



}
