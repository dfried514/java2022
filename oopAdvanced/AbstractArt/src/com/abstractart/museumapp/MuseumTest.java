package com.abstractart.museumapp;

import java.util.ArrayList;
import java.util.Random;

public class MuseumTest {
	public static <T> ArrayList<T> getShuffledList(ArrayList<T> list) {
		ArrayList<T> listClone = new ArrayList<T>();
		for (T t : list) {
			listClone.add(t);
		}
		Random random = new Random();
		for (int i = listClone.size() - 1; i > 0; i--) {
			int randomIdx = random.nextInt(i);
			T tmp = listClone.get(i);
			listClone.set(i,  listClone.get(randomIdx));
			listClone.set(randomIdx, tmp);
		}
		return listClone;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Museum museum = new Museum();
		
		ArrayList<Art> museumArt = new ArrayList<Art>();
		
		Painting p1 = new Painting("American Gothic", "Grant Wood", "oil", 
				"Dry description of a farmer and his Plain-Jane wife. (1930)");
		
		Painting p2 = new Painting("The Last Supper", "Leonardo da Vinci", "oil",
				"Painted on a refactory wall, Convent of Santa Maria delle Grazie in Milan. (1498)");
		
		Painting p3 = new Painting("Nighthawks", "Edward Hopper", "oil", 
				"Iconic depiction of urban isolation. (1942)");
		
		Painting p4 = new Painting("The Sleeping Gypsy", "Henri Rousseau", "oil",
				"Fantastical delineation of a lion and a resting gypsy. (1897)");
		
		Painting p5 = new Painting("Salvador Mundi", "Leonardo da Vinci", "oil", 
				"A well spent day brings happy sleep, so a life well spent brings happy death. (1500)");
			
//		museum.addPainting(p1);
//		museum.addPainting(p2);
//		museum.addPainting(p3);
//		museum.addPainting(p4);
//		museum.addPainting(p5);
		
		museumArt.add(p1);
		museumArt.add(p2);
		museumArt.add(p3);
		museumArt.add(p4);
		museumArt.add(p5);
		
		Sculpture s1 = new Sculpture("The Thinker", "Auguste Rodin", "bronze", 
				"Nude male figure of over life-size sitting on a stone pedestal. (1902");
		
		Sculpture s2 = new Sculpture("David of Michelangelo", "Michelangelo", "marble",
				"5.17-metre marble statue of the Biblical figure David. (1500)");
		
		Sculpture s3 = new Sculpture("Bust of Nefertiti", "Thutmose", "limestone", 
				"Discovered in 1912, art from ancient Egypt. (1345 BC)");
		
//		museum.addSculpture(s1);
//		museum.addSculpture(s2);
//		museum.addSculpture(s3);
		
		museumArt.add(s1);
		museumArt.add(s2);
		museumArt.add(s3);
		
		final ArrayList<Art> shuffledArt 
			= getShuffledList((ArrayList<Art>)museumArt);
		
		for (Art art : shuffledArt) {
			art.viewArt();
		}
		
//		final ArrayList<Painting> shuffledPaintings
//			= getShuffledList((ArrayList<Painting>)museum.getPaintings());
//		
//		final ArrayList<Sculpture> shuffledSculptures 
//			= getShuffledList((ArrayList<Sculpture>)museum.getSculptures());
//		
//		for (Painting p : shuffledPaintings) {
//			p.viewArt();
//		}
//		System.out.println("--------------");
//		for (Sculpture s : shuffledSculptures) {
//			s.viewArt();
//		}
	}
}
