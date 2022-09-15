package com.friedman.tvshows.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="shows")
public class Show {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	@NotEmpty
    @Size(min = 2, max = 50, message = "Must be between 2 and 50 characters.")
    private String title;
	
	@NotEmpty
    @Size(min = 2, max = 50, message = "Must be between 2 and 50 characters.")
    private String network;
	
	@NotEmpty
    @Size(min = 2, max = 2000, message = "Must be between 2 and 2000 characters.")
    private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotNull(message = "Cannot be blank.")
	private User creator;
	
	@OneToMany(mappedBy="show", fetch = FetchType.LAZY)
    private List<Rating> ratedShows;
	
	public Show() {
		ratedShows = new ArrayList<Rating>();
		
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<Rating> getRatedShows() {
		return ratedShows;
	}

	public void setRatedShows(List<Rating> ratedShows) {
		this.ratedShows = ratedShows;
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




