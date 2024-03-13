package com.maissa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.maissa.entities.Song;
import com.maissa.util.JPAutil;
//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class SongDao {
	private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA2");
	//méthode ajouter d'une entité à la bd
	public void ajouter(Song s)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(s);
		tx.commit();
	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(Song s)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(s);
		tx.commit();
	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Song s)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		s=entityManager.merge(s); // important
		entityManager.remove(s);
		tx.commit();
	}
	//méthode Consulter d'une entité à partir de la bd
	public Song consulter(Song s,Object id)
	{
		return entityManager.find(s.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<Song> listerTous() {
		List<Song> songs = entityManager.createQuery("select s from Song s").getResultList();
		return songs;
	}
	//méthode pour lister tous les client dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<Song> listerParNom(String nomsinger) {List<Song> songs =entityManager.createQuery( "select s from Song s where s.nomsinger like :pnom").setParameter("pnom","%"+nomsinger+"%").getResultList();
	return songs; }
}

