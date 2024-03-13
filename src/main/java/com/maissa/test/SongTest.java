package com.maissa.test;

import com.maissa.dao.SongDao;
import com.maissa.entities.Song;

public class SongTest {
	public static void main(String[] args) {
		// créer un objet Song
		Song s = new Song();
		s.setNomsinger("Taylor Swift");
		s.setNomsong("All too well");
		
		Song s1 = new Song();
		s1.setNomsinger("Taylor Swift");
		s1.setNomsong("illicit affairs");
		
		Song s2 = new Song();
		s2.setNomsinger("Henry Moodie");
		s2.setNomsong("Drunk text");
		
		// ajouter l'objet Song à la BD
		SongDao sinDao = new SongDao();
		sinDao.ajouter(s);
		sinDao.ajouter(s1);
		sinDao.ajouter(s2);
		sinDao.modifier(s2);
		sinDao.supprimer(s1);
		
		System.out.println("Appel de la méthode listerTous");
		for (Song si : sinDao.listerTous())
			System.out.println(si.getCode()+" "+si.getNomsinger());
		
		System.out.println("Appel de la méthode listerParNom");
		for (Song si : sinDao.listerParNom("Tay"))

			System.out.println(si.getCode()+" "+si.getNomsinger());

		// tester les autres méthodes de la classe SongDao
	}
}
