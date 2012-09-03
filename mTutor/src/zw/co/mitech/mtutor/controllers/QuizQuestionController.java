package zw.co.mitech.mtutor.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.Quiz;
import zw.co.mitech.mtutor.entities.QuizCounter;
import zw.co.mitech.mtutor.entities.QuizQuestion;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.service.QuizQuestionService;
import zw.co.mitech.mtutor.service.QuizService;
import zw.co.mitech.mtutor.util.DifficultyLevel;
import zw.co.mitech.mtutor.util.MapUtil;
import zw.co.mitech.mtutor.util.QuizType;
@Controller
public class QuizQuestionController {
	@Autowired
	private QuizService quizService;
	@Autowired
	private QuizQuestionService quizQuestionService;

	
	
	
	@RequestMapping( value="/questions" ,method=RequestMethod.GET)
	public String createNewQuizQuestion(Model model, HttpServletRequest request){
		System.out.println("processing now");
		long quizId = (Long) request.getSession().getAttribute("quizId");
		Quiz quiz = quizService.getQuizById(quizId);
		QuizQuestion question = new QuizQuestion();
		question.setConceptId(quiz.getConceptId());
		question.setAcademicLevelId(quiz.getAcademicLevelId());
		question.setTopicId(quiz.getTopicId());
		question.setSubjectId(quiz.getSubjectId());
		
		 model.addAttribute(new QuizQuestion());
		 model.addAttribute("quiz", quiz);
	
		return "questions/addQuestions";
	}
	
	@RequestMapping( value="/viewQuestion" ,method=RequestMethod.GET)
	public String viewQuizQuestion(Model model, HttpServletRequest request){
		System.out.println("processing now");
		long quizId = (Long) request.getSession().getAttribute("quizId");
		Quiz quiz = quizService.getQuizById(quizId);
		QuizQuestion question = new QuizQuestion();
		question.setConceptId(quiz.getConceptId());
		question.setAcademicLevelId(quiz.getAcademicLevelId());
		question.setTopicId(quiz.getTopicId());
		question.setSubjectId(quiz.getSubjectId());
		
		 model.addAttribute(new QuizQuestion());
		 model.addAttribute("quiz", quiz);
	
		return "questions/addQuestions";
	}
	
	
	@RequestMapping( value="/quizDone" ,method=RequestMethod.GET)
	public ModelAndView doneQuiz(Model model, HttpServletRequest request){
		long quizId = (Long) request.getSession().getAttribute("quizId");
		System.out.println("quizID >>>>>>>>"+quizId);
		Quiz quiz = quizService.getQuizById(quizId);
		System.out.println("Quiz>>>>>>>>>>>>>>"+quiz);
		String questionIds =(String) request.getSession().getAttribute("questionIds");
		System.out.println("Do we have any questions "+questionIds);
		Map<Long,Long> map= MapUtil.convertAttributesStringToLongMap(questionIds);
		
		Set<Long> ids = map.keySet();
		System.out.println(">>>>>>>>>anything>>>>>>>>>"+ids.size());
		quiz.setQuestionIds(ids);
		
		quizService.updateQuiz(quiz);
		request.getSession().setAttribute("quizId", quiz.getId());
		return new ModelAndView("quizzes/viewQuiz", "quiz", quiz);
	}
	
	
	  @RequestMapping(method = RequestMethod.POST)
	    public ModelAndView addQuestion(@Valid QuizQuestion question, BindingResult result,Model model, HttpServletRequest request) {
	 System.out.println("We are creating the quiz and will move to adding the questions");
		  if(result.hasErrors()) {
			  return new ModelAndView("questions/addQuestion", "question", question);
			  }
		 
		  long quizId = (Long) request.getSession().getAttribute("quizId");
			Quiz quiz = quizService.getQuizById(quizId);
			
			
			question.setConceptId(quiz.getConceptId());
			question.setAcademicLevelId(quiz.getAcademicLevelId());
			question.setTopicId(quiz.getTopicId());
			question.setSubjectId(quiz.getSubjectId());
			
			 System.out.println("Questn>>>>id>>>>>>>>"+question.getId());
			  System.out.println("Questn>>>>>conceptId>>>>>>>"+question.getConceptId());
			  System.out.println("Questn>>>>>conceptNumber>>>>>>>"+question.getConceptNumber());
			  System.out.println("Questn>>>>>detailedAnsw>>>>>>>"+question.getDetailedAnswer());
			  System.out.println("Questn>>>>>>difficulty level>>>>>>"+question.getDifficultyLevel());
		Map<Long,Long> questionMap= new TreeMap<Long, Long>();
			String questionIds = (String) request.getSession().getAttribute("questionIds");
			if(questionIds == null){
				questionIds="";
			
			}else{
				questionMap=MapUtil.convertAttributesStringToLongMap(questionIds);
			}
			
			
		  quizQuestionService.addQuestion(question);
			 System.out.println("after Questn>>>>id>>>>>>>>"+question.getId());
		 // questionIds.add(question.getId());
		//  quiz.getQuestionIds().add(question.getId());
		  questionMap.put(question.getId(),question.getId());
		  questionIds=MapUtil.convertAttributesLongMapToString(questionMap);
		  System.out.println("");
		  request.getSession().setAttribute("questionIds", questionIds);
		  ModelAndView viewResult = new ModelAndView("questions/viewQuestion", "question", question);
	      viewResult.addObject("quiz", quiz);  
		  return viewResult;
	        
	    }


	
	

	

	@ModelAttribute("quiz")
	public Quiz getQuiz(HttpServletRequest request) {
		
		 long quizId = (Long) request.getSession().getAttribute("quizId");
			Quiz quiz = quizService.getQuizById(quizId);
		
		return quiz;
	}
	@ModelAttribute("types")
	public Map<String, String> populateQuizTypeList() {
		
		Map<String, String> difficultTypes = new LinkedHashMap<String, String>();
		difficultTypes.put(DifficultyLevel.EASY, DifficultyLevel.EASY);
		difficultTypes.put(DifficultyLevel.HARD, DifficultyLevel.HARD);
		difficultTypes.put(DifficultyLevel.MEDIUM, DifficultyLevel.MEDIUM);
		
		return difficultTypes;
	}
	
	
	@RequestMapping(value = "/listDifficultyTypes", method = RequestMethod.GET)
	public @ResponseBody Set<String> findAllTypes() {
	 Set<String> list = new TreeSet<String>();
	 list.add(DifficultyLevel.EASY);
	 list.add(DifficultyLevel.HARD);
	 list.add(DifficultyLevel.MEDIUM);

	 
	return  list;
	
	}

}
