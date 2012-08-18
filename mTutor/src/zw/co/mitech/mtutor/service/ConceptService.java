package zw.co.mitech.mtutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.mitech.mtutor.entities.Concept;
import zw.co.mitech.mtutor.session.ConceptFacade;

@Service("conceptService")
public class ConceptService {
@Autowired
private ConceptFacade conceptFacade;

public void addConcept(Concept concept){
	conceptFacade.create(concept);
	
}

public List<Concept> getConceptsByTopicIdOrderedBySequence(Long topicId) {
	return conceptFacade.getConceptsByTopicIdOrderedBySequence(topicId);
}



public long getTopicSequence(Long topicId){
	return conceptFacade.getTopicSequence(topicId);
}

public void deleteConcept(Concept concept) {
	conceptFacade.remove(concept);
	
}

}
