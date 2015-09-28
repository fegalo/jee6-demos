package dev.jee6demo.jpastart;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateful
public class SoccerClub {

	@PersistenceContext(unitName = "test", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void addPlayer(Player player) throws Exception {
		entityManager.persist(player);
	}

	public void deletePlayer(Player player) throws Exception {
		entityManager.remove(player);
	}

	public List<Player> getPlayers() throws Exception {
		Query query = entityManager.createQuery("SELECT m from Player as m");
		return query.getResultList();
	}

}
