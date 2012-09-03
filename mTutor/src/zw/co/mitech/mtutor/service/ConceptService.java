package zw.co.mitech.mtutor.service;

import java.util.HashSet;
import java.util.Set;

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

public Set<Concept> getConceptsByTopicIdOrderedBySequence(Long topicId) {
	Set<Concept> results = new HashSet<Concept>(conceptFacade.getConceptsByTopicIdOrderedBySequence(topicId));
	return results;
}



public long getTopicSequence(Long topicId){
	return conceptFacade.getTopicSequence(topicId);
}

public void deleteConcept(Concept concept) {
	conceptFacade.remove(concept);
	
}

}
