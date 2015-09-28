package dev.jee6demo.jpastart;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.jee6demo.jpastart.Player;

public class JpaTest  extends TestCase {

	@Resource
	private UserTransaction userTransaction;

	@PersistenceContext
	private EntityManager entityManager;


	public void setUp() throws Exception {
		Properties p = new Properties();
		EJBContainer.createEJBContainer(p).getContext().bind("inject", this);
		
		Player player=new Player("Walter", "White", new Date());
		try {
			userTransaction.begin();
			entityManager.persist(player);
			userTransaction.commit();
		} catch (RuntimeException e) {
			if (userTransaction != null) {
				userTransaction.rollback();
			}
			throw e;
		}

	}

	@Test
	public void test1(){
		Player player=entityManager.find(Player.class, 1L);
		assertEquals("Walter",player.getName());
	}

}
