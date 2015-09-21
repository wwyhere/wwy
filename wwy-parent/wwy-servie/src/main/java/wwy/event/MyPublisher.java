package wwy.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher=applicationEventPublisher;
	}
	
	public void methodToMonitor() {
		applicationEventPublisher.publishEvent(new MyEvent(this, "aaa"));
		applicationEventPublisher.publishEvent(new MyEvent(this, "bbb"));
    }  

}
