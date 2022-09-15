package com.friedman.projectmanager.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	    
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	    
	@NotEmpty
	@Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters.")
	private String title;
	    
	@NotEmpty
	@Size(min = 2, max = 2000, message = "Description must be between 2 and 2000 characters.")
	private String description;
	
	@NotNull(message="Due date must not be blank.")
	private Date dueDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotNull(message = "Cannot be blank.")
	private User leadUser;
	
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
		private List<Task> tasks;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "projects_users", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> teamUsers;
	
	public Project() {
		
	}
	
	
	
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDueDate() {
		return dueDate;
	}



	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public List<User> getTeamUsers() {
		return teamUsers;
	}



	public void setTeamUsers(List<User> teamUsers) {
		this.teamUsers = teamUsers;
	}
	
	

	public User getLeadUser() {
		return leadUser;
	}



	public void setLeadUser(User leadUser) {
		this.leadUser = leadUser;
	}



	public List<Task> getTasks() {
		return tasks;
	}



	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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

