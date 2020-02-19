package com.ch3.pt3.stackoverflowclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ch3.pt3.stackoverflowclone.models.Answer;
import com.ch3.pt3.stackoverflowclone.models.repositories.AnswerRepository;

@Service
public class AnswerService {
 
    private final AnswerRepository answerRepo;
 
    public AnswerService(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }
 
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
  
}

