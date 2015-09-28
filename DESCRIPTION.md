### jsp

	TODO

### cdi

* __cdi-demo__: First CDI example
* __cdi-interceptors__: Interceptor classes and methods are used to interpose on method invocations or lifecycle events on a target class.
* __cdi-decorators__: Decorators are seemingly similar to interceptors,but implements additional business logic for a bean.
* __cdi-pro-dis__: Producer methods provide a way to inject objects that are not beans, objects whose values may vary at runtime, and objects that require custom initialization.The disposer method is called automatically when the context ends, and the parameter in the annotated method receives the object produced by the producer method.If there is more than one bean, it is necessary to distinguish between them using custom annotations.
* __cdi-named__: Named annotation to use named beans
* __cdi-events__: Events allow beans to communicate without any compile-time dependency.One bean can define an event, another bean can fire the event, and yet another bean can handle the event. An observer method listen to the event and is invoked when the event is fired.

### ejb

* __ejb-start__: First EJB example
* __ejb-timer__: Scheduled task with EJB
* ejb-jms...: //TODO
* ejb-ws...: EJB as a web service

### jms

* __jms-pub-sub__: JMS example with publisher (producer) and subscriber (consumer)
* __jms-pub-sub-activemq__: JMS example with ActiveMQ

### jpa

* __hsql-start__: Example of the hsql DDBB,used in JPA examples
* __jpa-start__: First JPA example
* __jpa-ejb__: JPA in an EJB container or application server
* jpa-criteria...: //TODO

### jsf

* __jsf-start__: First JSF example.
* __jsf-form__: Use of a Bean for a form using POST.It includes validation.
* __jsf-ajax__: Use of a Bean for a form using AJAX and annotated validation.
* __jsf-advanced__: Listener and validators methods for JSF beans.


### jaxrs

* __jaxrs-server__
* jaxrs-client... //TODO
	
### jaxws

* __sun-jaxws-server__: sun implementation for jaxws
* __sun-jaxws-client__: client for _sun-jaxws-server_
* jaxws-client... //TODO
* jaxws-server... //TODO
* jaxws-mtom... //TODO

### more

* validation //TODO
* resource //TODO

#servers

* __glassfish-demo__: Glasssfish 3.1.2 embedded with maven
* __jboss-demo__: JBoss AS 7.2 embedded with maven
* __parent-demo__: How to configure profiles to use servers in children projects