package service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wwy.event.MyPublisher;

public class TestEvent {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml","classpath:spring/applicationContext-redis.xml");
		MyPublisher myPublisher=applicationContext.getBean("myPublisher",MyPublisher.class);
		myPublisher.methodToMonitor();
	}
}
