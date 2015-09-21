package wwy.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * 
 * @author wwy
 * @date 2015年6月11日下午9:44:36
 */
public class TestConsumer {
    
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaPropertiesConfig.zkConnect);
        props.put("group.id", KafkaPropertiesConfig.groupId);
        // props.put("zookeeper.session.timeout.ms", "40000");
        // props.put("zookeeper.sync.time.ms", "200");
        // props.put("auto.commit.interval.ms", "1000");
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
