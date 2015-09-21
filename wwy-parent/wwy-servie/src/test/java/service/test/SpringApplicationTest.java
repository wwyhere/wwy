package service.test;

import java.io.IOException;

import kafka.producer.ProducerConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import wwy.constant.Config;

public class SpringApplicationTest {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-redis.xml",
                "classpath:spring/applicationContext-kafka.xml");
        Config config = applicationContext.getBean("config", Config.class);
        ProducerConfig producerConfig = (ProducerConfig) applicationContext.getBean("producerConfig");
        System.out.println(producerConfig);
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("system.testConstants"));
        System.out.println(config.getTestConstants());
    }
}
