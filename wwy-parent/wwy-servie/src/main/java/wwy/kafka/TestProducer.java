package wwy.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 
 * @author wwy
 * @date 2015年6月7日上午2:03:01
 */
public class TestProducer {
    
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("metadata.broker.list", "192.168.159.130:9092,192.168.159.130:9093,192.168.159.130:9094");
        props.put("serializer.class", "kafka.serializer.StringEncoder"); // 默认字符串编码消息
        props.put("zookeeper.session.timeout.ms", "400000");
        ProducerConfig config = new ProducerConfig(props);
        
        Producer<String, String> producer = new Producer<String, String>(config);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>("my-replicated-topic", "测试消息");
        producer.send(data);
        producer.close();
    }
}
