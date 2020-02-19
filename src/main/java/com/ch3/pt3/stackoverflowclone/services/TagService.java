package com.ch3.pt3.stackoverflowclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ch3.pt3.stackoverflowclone.models.Tag;
import com.ch3.pt3.stackoverflowclone.models.repositories.TagRepository;

@Service
public class TagService {
 
    private final TagRepository tagRepo;
 
    public TagService(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }
 
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
  
}

