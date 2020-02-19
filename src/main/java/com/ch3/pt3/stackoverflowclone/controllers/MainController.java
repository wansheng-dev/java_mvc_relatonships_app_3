package com.ch3.pt3.stackoverflowclone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ch3.pt3.stackoverflowclone.models.Answer;
import com.ch3.pt3.stackoverflowclone.models.Question;
import com.ch3.pt3.stackoverflowclone.models.QuestionTag;
import com.ch3.pt3.stackoverflowclone.models.Tag;
import com.ch3.pt3.stackoverflowclone.services.MainService;

@Controller
public class MainController {
 
	@Autowired
	MainService service;
    
	public MainController(MainService service) {
        this.service = service;
    }
 
    @GetMapping("/questions")
    public String dashboard(Model model){
        List<Question> questions = service.allQuestions();
        model.addAttribute("questions", questions);
        return "dashboard.jsp";
    }
 
    @GetMapping("/questions/new")
    public String newQuestion(@ModelAttribute("newQuestion") Question question){
        return "newQuestion.jsp";
    }
 
    @PostMapping("/questions/create")
    public String createQuestion(
        @Valid @ModelAttribute("newQuestion") Question q,
        BindingResult result,
        @RequestParam("strTags") String tags,
        Model model
    		){
        if (result.hasErrors()){
            return "newQuestion.jsp";
        }
        service.createQuestion(q);
        // convert the tag input string into list of strings
        String[] listTags = tags.split(",");
        if(listTags.length > 3) {
        	model.addAttribute("tagErr", "You can only add up to three tags.");
        	return "newQuestion.jsp";
        }
        System.out.println(listTags[0]);
        // create tag
        for(String t: listTags){
            Tag tag = this.service.findTagBySubject(t.trim().toLowerCase());
            if(tag == null){
                tag = new Tag();
                tag.setSubject(t.trim().toLowerCase());  //setting the tag text to current value in Array as we iterate through it
                tag = service.createTag(tag); //saving tag to DB
            }
            
            QuestionTag qt = new QuestionTag();   //creating new QuestionTag (relationship)
            qt.setQuestion(q);  //setting the question for the relationship
            qt.setTag(tag);     //setting the tag for the relationship
            qt = this.service.createQuestionTag(qt);  //saving the relationship
        }
        return "redirect:/questions";
    }
    
    
    @GetMapping("/questions/{id}")
    public String detailQuestion(
    		@PathVariable("id") Long id,
    		@ModelAttribute("newAnswer") Answer newAnswer,
    		Model model
    		) {
    	Question q = this.service.getQuestion(id);
    	model.addAttribute("question", q);
    	return "detailQuestion.jsp";
    }
    
    
    @PostMapping("/questions/{id}/answer")
    public String createAnswer(
    		@PathVariable("id") Long id,
    		@Valid @ModelAttribute("newAnswer") Answer newAnswer,
    		BindingResult result,
    		Model model
    		) {
    	Question q = this.service.getQuestion(id);
    	if (result.hasErrors()) {
    		model.addAttribute("question", q);
    		return "detailQuestion.jsp";
    	}
    	Answer a = new Answer();
    	a.setAnswer(newAnswer.getAnswer());
    	a.setQuestion(q);
    	this.service.createAnswer(a);
    	return "redirect:/questions/" + q.getId();
    }
 
}
