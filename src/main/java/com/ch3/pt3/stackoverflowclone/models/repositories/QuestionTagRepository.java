package com.ch3.pt3.stackoverflowclone.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt3.stackoverflowclone.models.QuestionTag;

@Repository
public interface QuestionTagRepository extends CrudRepository<QuestionTag, Long>{

}
