package com.abstractart.museumapp;

public class Sculpture extends Art {
	private String material;

	public Sculpture(String title, String author, String material, String description) {
		this.title = title;
		this.author = author;
		this.material = material;
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
	public String getMaterial() {
		return material;
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
	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	protected void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Title:  " + this.title);
		System.out.println("Author:  " + this.author);
		System.out.println("Material:  " + this.material);
		System.out.println("Description:  " + this.description);
		System.out.println();
	}
}
