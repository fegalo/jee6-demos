package dev.jee6demo;

import org.apache.log4j.Logger;
/**
 * This class is an minimal example of how to write
 * events and listener from threads (like in java swing)
 * 
 * Signal: represents the event
 * Listener: "capture" the signal, is invoked asynchronously.
 * Generator: generate the signal, and call the listener. 
 *
 */
public class Main_Events {
	static Logger log= Logger.getLogger(Main_Events.class);
	
	public static void main(String args[]){
		mainNormal();
		//mainStopping();
	}
	/**
	 * Main method without stooping
	 */
	public static void mainNormal(){
		Listener listener=new Listener(){
			@Override
			public void onLaunchedSignal(Signal signal) {
				log.info("Launched Signal: "+signal.getMessage());
			}
		};
		Generator generator =new Generator(listener);
		log.info("Start generator thread");
		generator.start();
		log.info("main method ending");
	}
	/**
	 * Main method without stooping
	 */
	public static void mainStopping(){
		Listener listener=new Listener(){
			@Override
			public void onLaunchedSignal(Signal signal) {
				log.info("Launched Signal: "+signal.getMessage());
			}
		};
		Generator generator =new Generator(listener);
		log.info("Start Generator Thread");
		generator.start();
		log.info("End Generator Thread");
		generator.stop();
		stop_time(1000);
		log.debug("isInterrupted FLAG 'Main': "+Thread.currentThread().isInterrupted());
	}
	/**
	 * Signal Generator class. It needs a Listener to be call with the Signal
	 *
	 */
	public static class Generator{
		Thread thread;
		public Generator(final Listener listener){//final Object because of run()
			Runnable runnable= new Runnable(){
				@Override
				public void run() {
					stop_time(2000);//wait 2 seconds
					log.debug("isInterrupted FLAG 'Generator': "+Thread.currentThread().isInterrupted());
					//Only launch the signal if the thread has not been interrupted
					if(Thread.currentThread().isInterrupted()){
						log.warn("Generator has been interrupted");
					}else{
						//launch signal
						listener.onLaunchedSignal(new Signal("Generated Signal"));
					}
				}

			};
			thread=new Thread(runnable);
		}
		public void start(){
			thread.start();
		}
		public void stop(){
			thread.interrupt();
		}
	}
	/**
	 * Bean which represents a signal with a message
	 *
	 */
	public static class Signal{
		private String message;

		public Signal(String message) {
			super();
			this.message = message;
		}
		public String getMessage() {
			return message;
		}
	}
	/**
	 * Listener interface to be call by the Generator with the signal.
	 * Obviously onLaunchedSignal the method has to be implemented.
	 * It is called asynchronously by the Generator.
	 * 
	 */
	public interface Listener{
		public void onLaunchedSignal(Signal signal);
	}
	/**
	 * Waits for the specified time
	 * @param mseconds
	 */
	public static void stop_time(int mseconds){
		Object obj=new Object();
		synchronized (obj) {
			try {
				obj.wait(mseconds);
			} catch (InterruptedException e) {
				log.error("The wait has been interrupted: "+e.getMessage());
				Thread.currentThread().interrupt();//If an exception is thrown, set interrupt flag true
			}
		}
	}
}