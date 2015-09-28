package dev.jee6demo.ejbtimer;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless(name = "TimerInfoBean", mappedName = "Temporizador")
@Remote(TimerInfo.class)
public class TimerInfoBean implements TimerInfo {
	private static int numScheduledTasks=0;
	private static int numTimeoutTasks=0;
	@Resource
	TimerService timerService;
	public void startTimer() {
		System.out.println("TimerInfoBean - started");
		//timerService.createTimer(2000,"Created new timer");
		timerService.createTimer(2000,1050,"Created new timer");
	}
	public String getInfo() {
		System.out.println("TimerInfoBean info");
		return "numScheduledTasks: "+numScheduledTasks+" numTimeoutTasks: "+numTimeoutTasks;
	}

	public void stopTimer() {
		System.out.println("TimerInfoBean stopped");
	    for(Object obj : timerService.getTimers()) {
	        Timer t = (Timer)obj;
	        if (t.getInfo().equals("Created new timer")) {
	        t.cancel();
	        }
	    }

	}
	@Timeout
	public void timeout(Timer timer)
	{
		System.out.println("TimerInfoBean - Timeout task "+TimerInfoBean.numTimeoutTasks++);
	}

	@Schedule(second="*/4", minute="*", hour="*", info="Automatic Timer Test")
	public void automatico(){
		System.out.println("TimerInfoBean - Scheduled task "+TimerInfoBean.numScheduledTasks++);
	}
}
