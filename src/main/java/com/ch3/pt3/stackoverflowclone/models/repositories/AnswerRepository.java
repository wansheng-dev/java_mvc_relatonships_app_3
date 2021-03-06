package com.ch3.pt3.stackoverflowclone.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt3.stackoverflowclone.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    // this method retrieves all the objects from the database
    List<Answer> findAll();
    // this method retrieves an object by its id
    Optional<Answer> findById(Long id);
}
