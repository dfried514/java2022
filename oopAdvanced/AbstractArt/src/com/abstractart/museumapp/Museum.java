package com.abstractart.museumapp;

import java.util.ArrayList;

public class Museum {
	private ArrayList<Painting> paintings;
	private ArrayList<Sculpture> sculptures;
	
	public Museum() {
		paintings = new ArrayList<Painting>();
		sculptures = new ArrayList<Sculpture>();
	}
	public void addPainting(Painting painting) {
		paintings.add(painting);
	}
	public void addSculpture(Sculpture sculpture) {
		sculptures.add(sculpture);
	}
	public ArrayList<Painting> getPaintings() {
		return paintings;
	}
	public ArrayList<Sculpture> getSculptures() {
		return sculptures;
	}
}
