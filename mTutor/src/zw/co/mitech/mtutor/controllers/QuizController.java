package zw.co.mitech.mtutor.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.AcademicLevel;
import zw.co.mitech.mtutor.entities.Concept;
import zw.co.mitech.mtutor.entities.Quiz;
import zw.co.mitech.mtutor.entities.QuizCounter;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.service.AcademicLevelService;
import zw.co.mitech.mtutor.service.ConceptService;
import zw.co.mitech.mtutor.service.QuizCounterService;
import zw.co.mitech.mtutor.service.QuizService;
import zw.co.mitech.mtutor.service.SubjectService;
import zw.co.mitech.mtutor.service.TopicService;
import zw.co.mitech.mtutor.util.QuizType;

@Controller

public class QuizController {
	@Autowired
	private QuizService quizService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ConceptService conceptService;
	@Autowired
	private AcademicLevelService gradeService;
	
	@Autowired
	private QuizCounterService quizCounterService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(QuizController.class);
	
	
	

	  @RequestMapping(method = RequestMethod.POST)
	    public String addQuiz(@Valid Quiz quiz, BindingResult result,Model model, HttpServletRequest request) {
	 System.out.println("We are creating the quiz and will move to adding the questions");
		  if(result.hasErrors()) {
			  return "quizzes/addQuiz";
			  }
		  System.out.println("Quiz>>>>>>>>>>>>"+quiz.getId());
		  System.out.println("Quiz>>>>>>>>>>>>"+quiz.getAcademicLevelId());
		  System.out.println("Quiz>>>>>>>>>>>>"+quiz.getConceptId());
		  System.out.println("Quiz>>>>>>>>>>>>"+quiz.getQuizType());
		  System.out.println("Quiz>>>>>>>>>>>>"+quiz.getQuizNumber());
		
		  //QuizCounter counter = quizCounterService.getQuizConterByConceptIdAndTopic(quiz.getTopicId(), quiz.getConceptId());
		  //long count = counter.getCount();
		  //++count;
		  String code = quizService.generateQuizCode();
		  
		 // quizCounterService.incrementCounter(counter);
		  System.out.println("Code>>>>>>>>"+code);
		  //System.out.println("Counter>>>>>>"+counter);
		  //quiz.setQuizNumber(count);
		  quiz.setCode(code);
		  
		  quizService.addQuiz(quiz);
	 request.getSession().setAttribute("quizId", quiz.getId());
	       // return gotoListPage(model);
	 return "redirect:/questions";
	       // return new ModelAndView("questions/addQuestion", "quiz", quiz);
	        
	    }
	 
	  
	  
	  @RequestMapping( value="/viewQuiz" ,method=RequestMethod.GET)
		public String viewQuiz(Model model, HttpServletRequest request){
		  
		  long quizId = (Long) request.getSession().getAttribute("quizId");
			Quiz quiz = quizService.getQuizById(quizId);
		  model.addAttribute(quiz);
			 logger.debug("view quiz");
			return "quizzes/viewQuiz";
		}
		


	@RequestMapping( value="/addQuiz" ,method=RequestMethod.GET)
	public String createNewQuiz(Model model){
		 model.addAttribute(new Quiz());
		 logger.debug("new quiz");
		return "quizzes/addQuiz";
	}

	
	
	@RequestMapping(method = RequestMethod.GET, params="list")
	public String listQuizzes(Model model) {
		
		List<Quiz> quizzes = quizService.getQuizzes();
		
		
		model.addAttribute(quizzes);
		
		return "users/list";
	}



	@RequestMapping(value = "/listSubjects", method = RequestMethod.GET)
	public @ResponseBody Set<Subject> findAllSubjects() {
	 
	logger.debug("finding all subjects");
	 
	return  this.subjectService.getSubjects();
	
	}
	
	@RequestMapping(value = "/listGrades", method = RequestMethod.GET)
	public @ResponseBody Set<AcademicLevel> findAllGrades(@RequestParam(value = "subjectId", required = true) Long subjectId, HttpServletRequest request) {
		System.out.println(">>>>>>>>>>>>>>>subject ID>>>>>>>>>>>>>"+subjectId);
	logger.debug("finding all grades");
	 request.getSession().setAttribute("subjectId", subjectId);
	return  this.gradeService.getAllGrades();
	
	}
	
	
	
	/*@RequestMapping(value = "/listGrades", method = RequestMethod.GET)
	public @ResponseBody Set<AcademicLevel> findAllTopicsByGrade() {
	 
	logger.debug("finding all ");
	 
	return  this.gradeService.getAllGrades();
	
	}*/
	@RequestMapping(value = "/listTopics", method = RequestMethod.GET)
	public @ResponseBody
	Set<Topic> topicsForGradeAndSubject( @RequestParam(value="academicLevelId", required = true)Long academiclevelId, HttpServletRequest request) {
	//System.out.println(">>>>>>>>>>>>>>>subject ID>>>>>>>>>>>>>"+subjectId);
	System.out.println(">>>>>>>>>>>>>>>academic level>>>>>>>>>>"+academiclevelId);
	Long subjectId =(Long) request.getSession().getAttribute("subjectId");
	System.out.println(">>>>>>>>>>>>>>>subject ID>>>>>>>>>>>>>"+subjectId);
		return this.topicService.findTopicsBySubjectAndGrade(subjectId,academiclevelId);
	}
	
	
	@RequestMapping(value = "/listConcepts", method = RequestMethod.GET)
	public @ResponseBody
	Set<Concept> conceptsForTopic(
			@RequestParam(value = "topicId", required = true) Long topicId) {
	System.out.println(" get conceotopic id is>>>>>>>>>>>>>>>>"+topicId);
		return this.conceptService.getConceptsByTopicIdOrderedBySequence(topicId);
	}
	
	
	@ModelAttribute("quizTypes")
	public Map<String, String> populateQuizTypeList() {
		
		Map<String, String> quizTypes = new LinkedHashMap<String, String>();
		quizTypes.put(QuizType.ASSIGNMENT, QuizType.ASSIGNMENT);
		quizTypes.put(QuizType.CONCEPT, QuizType.CONCEPT);
		quizTypes.put(QuizType.QUIZ, QuizType.QUIZ);
		
		return quizTypes;
	}
	
	
	
	/*@RequestMapping(method=RequestMethod.POST)
	  public String addSpitterFromForm(@Valid User user, BindingResult bindingResult) {
	    
	    if(bindingResult.hasErrors()) {
	      return "users/edit";
	    } 
	    
	    userService.saveUser(user);
	    
	   

	    return "redirect:/users/view";
	  }  */
	
	
	@RequestMapping(method=RequestMethod.POST, params = "cancel")
	public ModelAndView cancel(Model model, HttpServletRequest request) {
		
Set<Subject> subjects= subjectService.getSubjects();
		
		
		model.addAttribute(subjects);
	
		return new ModelAndView("subjects/list","subjects",subjects);
		
	
		
		} 
	
}
