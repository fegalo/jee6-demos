package dev.jee6demo.jpastart;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.jee6demo.jpastart.Player;

public class JpaTest {

	private static EntityManagerFactory eMF;
	private static EntityManager entityManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		eMF = Persistence.createEntityManagerFactory("test");
		entityManager = eMF.createEntityManager();
		
		Player player=new Player("Walter", "White", new Date());
		EntityTransaction trx =null;
		try {
			trx = entityManager.getTransaction();
			trx.begin();
			entityManager.persist(player);
			trx.commit();
		} catch (RuntimeException e) {
			if (trx != null && trx.isActive()) {
				trx.rollback();
			}
			throw e;
		}
	}
	@Test
	public void test1(){
		Player player=entityManager.find(Player.class, 1L);
		assertEquals("Walter",player.getName());
	}

	@AfterClass
	public static void tearDownAfterClass() {
		entityManager.close();
		eMF.close();
	}

}
