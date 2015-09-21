package wwy.service.impl;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import wwy.service.KafkaProducerService;

/**
 * 
 * @author wwy
 * @date 2015年7月4日下午4:47:16
 */
@Service("kafkaProducerService")
public class KafkaProducerServiceImpl implements KafkaProducerService {
    
    @Value("#{kafkaProducerProperties}")
    private Properties producerProperties;
    
    /*
     * @see wwy.service.KafkaProducerService#sendMessage(java.lang.String,
     * java.lang.String)
     */
    @Override
    public void sendMessage(String topic, String msg) {
        ProducerConfig config = new ProducerConfig(producerProperties);
        Producer<String, String> producer = new Producer<String, String>(config);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, msg);
        producer.send(data);
        producer.close();
    }
    
    @Override
    public void sendMessage(String topic, String key, String msg) {
        ProducerConfig config = new ProducerConfig(producerProperties);
        Producer<String, String> producer = new Producer<String, String>(config);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, key, msg);
        producer.send(data);
        producer.close();
    }
    
    @Override
    public void sendMessage(String topic, String key, Object partKey, String msg) {
        ProducerConfig config = new ProducerConfig(producerProperties);
        Producer<String, String> producer = new Producer<String, String>(config);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, key, partKey, msg);
        producer.send(data);
        producer.close();
    }
}
