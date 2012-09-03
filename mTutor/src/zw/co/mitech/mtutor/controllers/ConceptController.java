package zw.co.mitech.mtutor.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.Concept;
import zw.co.mitech.mtutor.service.AcademicLevelService;
import zw.co.mitech.mtutor.service.ConceptService;
import zw.co.mitech.mtutor.service.SubjectService;
import zw.co.mitech.mtutor.service.TopicService;

@Controller
@RequestMapping("/concepts")
public class ConceptController {
	@Autowired
	private TopicService topicService;
	@Autowired
	private AcademicLevelService academicService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ConceptService conceptService;
	
	
	
	 @RequestMapping(method = RequestMethod.POST)
	    public ModelAndView addConcept(@Valid Concept concept, BindingResult result,Model model) {
	 
		  if(result.hasErrors()) {
			
			  return new ModelAndView("concepts/addConcept", "concept", concept);
			  }

		  conceptService.addConcept(concept);
		 
		  
	 
	        return new ModelAndView("concepts/view", "concept", concept);
	    }
	 
	 
	 
	 /**
	     * <p>Deletes a person.</p>
	     * 
	     * <p>Expected HTTP POST and request '/person/delete'.</p>
	     */
	    @RequestMapping(method=RequestMethod.POST)
	    public String delete(Concept concept, HttpServletRequest request,Model model) {
	        conceptService.deleteConcept(concept);
	        Long topicId = (Long) request.getSession().getAttribute("topicId");
			Set<Concept> concepts= conceptService.getConceptsByTopicIdOrderedBySequence(topicId);
			
			
			model.addAttribute(concepts);
	        
	        return "concepts/viewConcepts";
	    }
	 
	 @RequestMapping(method=RequestMethod.GET)
		public String listConcepts(Model model, HttpServletRequest request) {
			//System.out.println("Subject Id >>>>>>"+subjectId);
			System.out.println("Model does it have a thing >>>>>>>>>"+model);
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>subject is Session>>>>"+request.getSession().getAttribute("topicId"));
			Long topicId = (Long) request.getSession().getAttribute("topicId");
			Set<Concept> concepts= conceptService.getConceptsByTopicIdOrderedBySequence(topicId);
			
			
			model.addAttribute(concepts);
		
			return "concepts/viewConcepts";
		}

	@RequestMapping(method=RequestMethod.GET, params="new")

	public String createNewConcept(Model model, HttpServletRequest request){
		Long topicId = (Long) request.getSession().getAttribute("topicId");
		System.out.println("topic id>>>>>"+topicId);
		Long sequence = conceptService.getTopicSequence(topicId);
		sequence = ++sequence;
		System.out.println(">>>>>>>>>>>>>>seq+"+sequence);
		Concept concept = new Concept();
		concept.setTopicId(topicId);
		concept.setTopicSequence(sequence);
		 model.addAttribute(concept);
		return "concepts/addConcept";
	}
	
	@RequestMapping(method=RequestMethod.POST, params = "cancel")
	public ModelAndView cancel(Model model, HttpServletRequest request) {
		
		System.out.println("Model does it have a thing >>>>>>>>>"+model);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>subject is Session>>>>"+request.getSession().getAttribute("topicId"));
		Long topicId = (Long) request.getSession().getAttribute("topicId");
		Set<Concept> concepts= conceptService.getConceptsByTopicIdOrderedBySequence(topicId);
		
		
		model.addAttribute(concepts);
	
		return new ModelAndView("concepts/viewConcepts","concepts",concepts);
		
		} 
		
		
		
	
	
	
	
}
