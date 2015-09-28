package dev.jee6demo.cdievent;

import javax.enterprise.event.Observes;

public class HelloListener {

    public void listenToHello(@Observes HelloEvent helloEvent){

        System.out.println("HelloEvent: " + helloEvent);

    }

}
