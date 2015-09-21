package wwy.event;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisPsubscribeChannel {

	@SuppressWarnings("unused")
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private RedisListener redisListener;

	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(redisListener, Arrays.asList(new PatternTopic("*")));
		System.out.println("订阅了所有频道");
		return container;
	}
}
