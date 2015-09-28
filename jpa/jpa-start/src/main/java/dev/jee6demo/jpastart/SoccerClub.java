package dev.jee6demo.jpastart;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

public class SoccerClub {

	private EntityManager entityManager;

	public SoccerClub() {
		super();
		entityManager=Persistence.createEntityManagerFactory("test").createEntityManager();
	}

	public void addPlayer(Player player) throws Exception {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(player);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void deletePlayer(Player player) throws Exception {
		try{
			entityManager.getTransaction().begin();
			entityManager.remove(player);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public List<Player> getPlayers() throws Exception {
		Query query = entityManager.createQuery("SELECT m from Player as m");
		return query.getResultList();
	}

}
