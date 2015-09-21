package wwy.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisListener implements MessageListener {

	@SuppressWarnings("unused")
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		byte[] messageChannel = message.getChannel();
		byte[] messageBody = message.getBody();
		if (messageChannel == null || messageBody == null) {
			return;
		}
		String channel = new String(messageChannel);
		String body = new String(messageBody);

		publishEvent(new RedisEvent(this, channel, body));
	}

	private void publishEvent(ApplicationEvent applicationEvent) {
		if (applicationEvent.getClass().isAssignableFrom(RedisEvent.class)) {
			RedisEvent event = (RedisEvent) applicationEvent;
			System.out.println("频道:" + event.getChannel() + "发布了消息:" + event.getMsg());
		}
	}
}
