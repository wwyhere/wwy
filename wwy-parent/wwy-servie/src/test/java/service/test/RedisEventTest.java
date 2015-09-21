package service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisEventTest {

    @SuppressWarnings({"unchecked", "resource"})
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-redis.xml",
                "classpath:spring/applicationContext-task.xml");
        RedisTemplate<String, String> redisTemplate = applicationContext.getBean("redisTemplate", RedisTemplate.class);
        redisTemplate.convertAndSend("频道1", "测试消息1");
        Thread.sleep(1000);
        redisTemplate.convertAndSend("频道2", "测试消息2");
    }
}
