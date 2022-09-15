package com.friedman.projectmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tasks")
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
    
    @NotEmpty
    @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters.")
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotNull(message = "Cannot be blank.")
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@NotNull(message = "Cannot be blank.")
	private Project project;
    
    public Task() {}
    
    

    
    public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Project getProject() {
		return project;
	}




	public void setProject(Project project) {
		this.project = project;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
