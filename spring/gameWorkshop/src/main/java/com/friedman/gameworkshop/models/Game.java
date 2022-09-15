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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="games")
public class Game implements Comparable<Game> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
    
    @NotEmpty(message = "Cannot be empty.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    private String name;
    
    @NotEmpty(message = "Cannot be empty.")
    @Size(min = 2, max = 50, message = "Genre must be between 2 and 50 characters.")
    private String genre;
    
    @NotEmpty(message = "Cannot be empty.")
    @Size(min = 2, max = 2000, message = "Description must be between 2 and 2000 characters.")
    private String description;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "game_mechanics", 
        joinColumns = @JoinColumn(name = "game_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> mechanicUsers;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotNull(message = "Cannot be blank.")
	private User user;
    
    public Game() {
    	
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




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getGenre() {
		return genre;
	}




	public void setGenre(String genre) {
		this.genre = genre;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public List<User> getMechanicUsers() {
		return mechanicUsers;
	}




	public void setMechanicUsers(List<User> mechanicUsers) {
		this.mechanicUsers = mechanicUsers;
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
	
	@Override
	public int compareTo(Game g) {
		return this.getName().compareTo(g.getName());
	}
	
}


