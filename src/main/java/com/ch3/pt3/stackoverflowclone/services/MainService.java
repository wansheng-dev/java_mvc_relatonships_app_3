package com.ch3.pt3.stackoverflowclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch3.pt3.stackoverflowclone.models.Answer;
import com.ch3.pt3.stackoverflowclone.models.Question;
import com.ch3.pt3.stackoverflowclone.models.QuestionTag;
import com.ch3.pt3.stackoverflowclone.models.Tag;
import com.ch3.pt3.stackoverflowclone.models.repositories.AnswerRepository;
import com.ch3.pt3.stackoverflowclone.models.repositories.QuestionRepository;
import com.ch3.pt3.stackoverflowclone.models.repositories.QuestionTagRepository;
import com.ch3.pt3.stackoverflowclone.models.repositories.TagRepository;

@Service
public class MainService {
	
	@Autowired
	AnswerRepository answerRepo;
	QuestionRepository questionRepo;
	TagRepository tagRepo;
	QuestionTagRepository qtRepo;
	
    public MainService(
    		AnswerRepository answerRepo,
    		QuestionRepository questionRepo,
    		TagRepository tagRepo,
    		QuestionTagRepository qtRepo
    		) {
        this.answerRepo = answerRepo;
        this.questionRepo = questionRepo;
        this.tagRepo = tagRepo;
        this.qtRepo = qtRepo;
    } 
    
    // ANSWER METHODS
    public List<Answer> allAnswers(){
        return answerRepo.findAll();
    }
 
    public Answer createAnswer(Answer answer) {
        return answerRepo.save(answer);
    }
 
    public Answer getAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepo.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        }
        return null;
    }
 
    public Answer updateAnswer(Answer answer) {
        return answerRepo.save(answer);
    }
 
    public void deleteAnswer(Long id) {
        answerRepo.deleteById(id);
    }
    
    // QUESTION METHODS
    public List<Question> allQuestions(){
        return questionRepo.findAll();
    }
 
    public Question createQuestion(Question question) {
        return questionRepo.save(question);
    }
 
    public Question getQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepo.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        }
        return null;
    }
 
    public Question updateQuestion(Question question) {
        return questionRepo.save(question);
    }
 
    public void deleteQuestion(Long id) {
        questionRepo.deleteById(id);
    }
  
    // TAG METHODS
    public List<Tag> allTags(){
        return tagRepo.findAll();
    }
 
    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }
 
    public Tag getTag(Long id) {
        Optional<Tag> optionalTag = tagRepo.findById(id);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        }
        return null;
    }
 
    public Tag updateTag(Tag tag) {
        return tagRepo.save(tag);
    }
 
    public void deleteTag(Long id) {
        tagRepo.deleteById(id);
    }
  
    public Tag findTagBySubject(String subject) {
    	Optional<Tag> optionalTag = this.tagRepo.findTagBySubject(subject);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        }
        return null;
    }
    
    // QUESTIONTAG METHODS
    public QuestionTag createQuestionTag(QuestionTag qt) {
    	return qtRepo.save(qt);
    }
    
    
}
