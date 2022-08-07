package com.abstractart.museumapp;

public class Painting extends Art {
	private String paintType;
	
	public Painting(String title, String author, String paintType, String description) {
		this.title = title;
		this.author = author;
		this.paintType = paintType;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDescription() {
		return description;
	}
	public String getPaintType() {
		return paintType;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	protected void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Title:  " + this.title);
		System.out.println("Author name:  " + this.author);
		System.out.println("Paint type:  " + this.paintType);
		System.out.println("Description:  " + this.description);
		System.out.println();
	}
}
