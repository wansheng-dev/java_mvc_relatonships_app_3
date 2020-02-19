package com.ch3.pt3.stackoverflowclone.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt3.stackoverflowclone.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    // this method retrieves all the objects from the database
    List<Tag> findAll();
    // this method retrieves an object by its id
    Optional<Tag> findById(Long id);
    
    Optional<Tag> findTagBySubject(String subject);
}
