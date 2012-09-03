package zw.co.mitech.mtutor.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.session.TopicFacade;

@Service("topicService")
public class TopicService {
	@Autowired
	private TopicFacade topicFacade;

	public void addTopic(Topic topic) {
		topicFacade.create(topic);
		
	}

	public List<Topic> getTopics() {
		// TODO Auto-generated method stub
		return topicFacade.findTopicsOrderedByGrade();
	}

	public List<Topic> getTopicsOrderedByGrade(){
		return topicFacade.findTopicsOrderedByGrade();
	}

	public List<Topic> getTopicsBySubjectOrderedByGrade(Long subjectId) {
		// TODO Auto-generated method stub
		return topicFacade.getTopicsBySubjectOrderedByGrade(subjectId);
	}

	public Set<Topic> findTopicsBySubjectAndGrade(Long subjectId,
			Long academiclevelId) {
		// TODO Auto-generated method stub
		return topicFacade.getTopicsBySubjectAndGrade(subjectId,academiclevelId);
	}

	public Topic getTopicById(long id) {
		// TODO Auto-generated method stub
		return topicFacade.find(id);
	}
	
	
}
