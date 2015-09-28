package dev.jee6demo.cdidec;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class BeanConsumerDecorator implements BeanConsumer{
	@Inject
	@Delegate
	private BeanConsumer beanConsumer;

	public String use() {
		return beanConsumer.use()+"-decorator-";
	}

}
