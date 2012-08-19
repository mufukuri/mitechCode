package zw.co.mitech.mtutor.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.AcademicLevel;
import zw.co.mitech.mtutor.entities.Subject;
import zw.co.mitech.mtutor.entities.Topic;
import zw.co.mitech.mtutor.service.AcademicLevelService;
import zw.co.mitech.mtutor.service.SubjectService;
import zw.co.mitech.mtutor.service.TopicService;

@Controller
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;
	@Autowired
	private AcademicLevelService academicService;
	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showTopics(@PathVariable Long id, Model model,
			HttpServletRequest request) {

		System.out.println("Topic Id >>>>>>" + id);

		request.getSession().setAttribute("topicId", id);

		return "topics/view";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addTopic(@Valid Topic topic, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {

			return new ModelAndView("topics/addTopic", "topic", topic);
		}

		topicService.addTopic(topic);
		System.out
				.println("1Topic info>>>>>>>>>>" + topic.getAcademicLevelId());
		System.out.println("T2opic info>>>>>>>>>>" + topic.getDescription());
		System.out.println("3Topic info>>>>>>>>>>" + topic.getSubjectId());
		System.out.println("4Topic info>>>>>>>>>>" + topic.getTopicName());
		System.out.println("5Topic info>>>>>>>>>>" + topic.getTopicType());
		System.out.println("6Topic info>>>>>>>>>>" + topic.getToUpgrade());

		request.getSession().setAttribute("topic", topic);

		return new ModelAndView("topics/view", "topic", topic);
	}

	@RequestMapping(method = RequestMethod.GET, params = "new")
	public String createNewTopic(Model model) {
		model.addAttribute(new Topic());
		return "topics/addTopic";
	}

	@RequestMapping(method = RequestMethod.GET, params = "list")
	public String listUsers(Model model) {

		List<Topic> topics = topicService.getTopics();

		model.addAttribute(topics);

		return "topics/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listTopics(Model model, HttpServletRequest request) {
		// System.out.println("Subject Id >>>>>>"+subjectId);
		System.out.println("Model does it have a thing >>>>>>>>>" + model);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>id for subject >>>>"
				+ request.getAttribute("subjectId"));
		System.out
				.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>subject is Session>>>>"
						+ request.getSession().getAttribute("subjectId"));
		Long subjectId = (Long) request.getSession().getAttribute("subjectId");
		List<Topic> topics = topicService
				.getTopicsBySubjectOrderedByGrade(subjectId);
		System.out.println(model.containsAttribute("topics"));

		model.addAttribute(topics);

		return "topics/viewTopics";
	}

	@ModelAttribute("subjects")
	public Map<Long, String> populateSubjectsList() {
		List<Subject> subjectsList = subjectService.getSubjects();
		Map<Long, String> subjects = new LinkedHashMap<Long, String>();
		for (Subject subject : subjectsList) {
			subjects.put(new Long(subject.getId()), subject.getName());
		}
		// Data referencing for web framework checkboxes

		return subjects;
	}

	@ModelAttribute("grades")
	public Map<Long, String> populateGradesList() {
		List<AcademicLevel> gradesList = academicService.getAllGrades();
		Map<Long, String> grades = new LinkedHashMap<Long, String>();
		for (AcademicLevel grade : gradesList) {
			grades.put(new Long(grade.getId()), grade.getLevelName());
		}
		// Data referencing for web framework checkboxes

		return grades;
	}

}
