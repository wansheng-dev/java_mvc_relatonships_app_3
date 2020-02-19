package com.ch3.pt3.stackoverflowclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ch3.pt3.stackoverflowclone.models.Question;
import com.ch3.pt3.stackoverflowclone.models.repositories.QuestionRepository;

@Service
public class QuestionService {
 
    private final QuestionRepository questionRepo;
 
    public QuestionService(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }
 
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
  
}
