package dev.jee6demo.jpastart;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.Name;

import org.junit.BeforeClass;
import org.junit.Test;
import dev.jee6demo.jpastart.Player;

public class JpaTest3 {

	static SoccerClub soccerClub;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		final Context context = EJBContainer.createEJBContainer(new Properties()).getContext();
		soccerClub = (SoccerClub) context.lookup("java:global/jpa-ejb/SoccerClub");
	}
	
	@Test
	public void test1() throws Exception{
		soccerClub.addPlayer(new Player("Walter", "White", new Date()));
		List<Player> list=soccerClub.getPlayers();
		
		assertNotNull(list);
		assertTrue(list.size()>0);
		assertEquals("Walter", list.get(0).getName());
	}

}
