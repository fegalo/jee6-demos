package dev.jee6demo.jpastart;

import static org.junit.Assert.*;

import java.util.Date;
import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import junit.framework.TestCase;

import org.junit.Test;

import org.junit.runner.RunWith;

import dev.jee6demo.jpastart.Player;

@RunWith(JPARunner.class)//Not recommended, better: http://tomee.apache.org/examples-trunk/injection-of-entitymanager/README.html
@ManagedBean
public class JpaTest2  extends TestCase {

	@Resource
	private UserTransaction userTransaction;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void test1() throws Exception{
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
		Player player2=entityManager.find(Player.class, 1L);
		assertEquals("Walter",player2.getName());
	}

}
