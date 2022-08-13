package com.friedman.booksapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Book() {
    }
    public Book(String title, String description, String lang, int pages) {
        this.title = title;
        this.description = description;
        this.language = lang;
        this.numberOfPages = pages;
    }

	public void setId(Long id) {
    	this.id = id;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    public void setLanguage(String lang) {
    	this.language = lang;
    }
    public void setNumberOfPages(Integer pages) {
    	this.numberOfPages = pages;
    }
    public void setCreatedAt(Date date) {
    	this.createdAt = date;
    }
    public void setUpdatedAt(Date date) {
    	this.updatedAt = date;
    }
    
    public Long getId() {
    	return this.id;
    }
    public String getTitle() {
    	return this.title;
    }
    public String getDescription() {
    	return this.description;
    }
    public String getLanguage() {
    	return this.language;
    }
    public int getNumberOfPages() {
    	return this.numberOfPages;
    }
    public Date getCreatedAt() {
    	return this.createdAt;
    }
    public Date getUpdatedAt() {
    	return this.updatedAt;
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


