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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
    
    @NotEmpty
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
    private String firstName;
    
    @NotEmpty
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters.")
    private String lastName;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,128}$"
    	, message = "Password must contain 1 lowercase letter, 1 uppercase letter, 1 number, and be 8 - 128 characters long.")
    private String password;
    
    @Transient
    @NotEmpty
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,128}$"
    	, message = "Password must contain 1 lowercase letter, 1 uppercase letter, 1 number, and be 8 - 128 characters long.")
    private String confirm;
    
    @OneToMany(mappedBy="leadUser", fetch = FetchType.LAZY)
    private List<Project> leadProjects;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Task> tasks;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "projects_users", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> teamProjects;
   
    
    public User() {}

    
    

	

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






	public String getFirstName() {
		return firstName;
	}






	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}






	public String getLastName() {
		return lastName;
	}






	public void setLastName(String lastName) {
		this.lastName = lastName;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getConfirm() {
		return confirm;
	}






	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}



	public List<Project> getLeadProjects() {
		return leadProjects;
	}



	public void setLeadProjects(List<Project> leadProjects) {
		this.leadProjects = leadProjects;
	}






	public List<Project> getTeamProjects() {
		return teamProjects;
	}






	public void setTeamProjects(List<Project> teamProjects) {
		this.teamProjects = teamProjects;
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


