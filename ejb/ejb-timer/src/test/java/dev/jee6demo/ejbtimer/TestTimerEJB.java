package dev.jee6demo.ejbtimer;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import dev.jee6demo.ejbtimer.TimerInfo;

public class TestTimerEJB {
	private static EJBContainer ejbContainer;


	@BeforeClass
	public static void startTheContainer() {
		ejbContainer = EJBContainer.createEJBContainer();
	}
	@Test
	public void initTimer() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("   Init Timer");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			TimerInfo timerInfo = (TimerInfo) ejbContainer.getContext().lookup("java:global/ejb-timer/TimerInfoBean");
			timerInfo.startTimer();
			stopInMs(10000);
			//assertEquals("numScheduledTasks: 3 numTimeoutTasks: 9",timerInfo.getInfo());
		} catch (NamingException e) {
			fail("NamingException:"+e.getMessage());
			e.printStackTrace();
		}
	}
	@Test
	public void stopTimer() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("   Stop Timer");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			TimerInfo timerInfo = (TimerInfo) ejbContainer.getContext().lookup("java:global/ejb-timer/TimerInfoBean");
			timerInfo.stopTimer();
			stopInMs(10000);
		} catch (NamingException e) {
			fail("NamingException:"+e.getMessage());
			e.printStackTrace();
		}
	}
	public void stopInMs(int ms){
		Object obj=new Object();
		synchronized (obj) {
			try {
				obj.wait(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
