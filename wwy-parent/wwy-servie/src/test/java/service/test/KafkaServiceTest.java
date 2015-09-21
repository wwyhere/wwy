package service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import test.BaseSpringTest;
import wwy.kafka.KafkaPropertiesConfig;
import wwy.service.KafkaProducerService;

/**
 * 
 * @author wwy
 * @date 2015年7月11日下午8:35:05
 */
public class KafkaServiceTest extends BaseSpringTest {
    
    @Autowired
    private KafkaProducerService kafkaProducerService;
    
    @Value("#{kafkaConsumerProperties}")
    private Properties consumerProperties;
    
    public static final String topic = "my-replicated-topic";
    
    @Test
    public void testProducer() {
        kafkaProducerService.sendMessage(topic, "测试消息");
    }
    
    @Test
    public void testConsumer() {
        Properties props = new Properties();
        props.put("group.id", KafkaPropertiesConfig.groupId);
        props.putAll(consumerProperties);
        String topic = "my-replicated-topic";
        ConsumerConfig consumerConfig = new ConsumerConfig(props);
        ConsumerConnector consumer = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            System.out.println("receive：" + new String(it.next().message()));
        }
    }
}
