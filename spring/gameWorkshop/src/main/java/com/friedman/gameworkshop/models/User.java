package com.friedman.gameworkshop.models;

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
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    private String name;
    
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
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Game> createdGames;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "game_mechanics", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> mechanicGames;
   
    
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public List<Game> getCreatedGames() {
		return createdGames;
	}



	public void setCreatedGames(List<Game> createdGames) {
		this.createdGames = createdGames;
	}



	public List<Game> getMechanicGames() {
		return mechanicGames;
	}



	public void setMechanicGames(List<Game> mechanicGames) {
		this.mechanicGames = mechanicGames;
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
    