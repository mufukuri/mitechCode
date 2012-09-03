package zw.co.mitech.mtutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.QuizCounter;
import zw.co.mitech.mtutor.session.QuizCounterFacade;
import zw.co.mitech.mtutor.session.QuizFacade;


@Service("quizCounterService")
public class QuizCounterService {
	
	@Autowired
	private QuizCounterFacade quizCounterFacade;
	
	
	
	public QuizCounter getQuizConterByConceptIdAndTopic(Long topicId,Long conceptId){
		
		return quizCounterFacade.getQuizCounter(topicId, conceptId);
	}
	

	
	public void incrementCounter(QuizCounter counter){
		quizCounterFacade.increment(counter);
	}
}
