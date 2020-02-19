package com.ch3.pt3.stackoverflowclone.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags")
public class Tag {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String subject;
  
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "questions_tags", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;  
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Tag() {}
   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
  
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
  
}

