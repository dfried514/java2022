package com.friedman.tvshows.models;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ratings")
public class Rating {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@NotNull(message = "Must not be empty.")
    @Min(value= 1, message = "Must be at least 1.")
	@Max(value = 5, message = "Must be no greater than 5.")
    private Integer value;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotNull(message = "Cannot be blank.")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "show_id")
	@NotNull(message = "Cannot be blank.")
	private Show show;
	
	public Rating() {
		
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




	public Integer getValue() {
		return value;
	}




	public void setValue(Integer value) {
		this.value = value;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Show getShow() {
		return show;
	}




	public void setShow(Show show) {
		this.show = show;
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
