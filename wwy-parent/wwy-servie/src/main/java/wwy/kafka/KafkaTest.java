package wwy.kafka;


/**
 * 
 * @author wwy
 * @date 2015年6月6日下午11:33:36
 */
public class KafkaTest {
    
    public static void main(String[] args) {
        KafkaProduce producerThread = new KafkaProduce(KafkaPropertiesConfig.topic);
        producerThread.start();
        
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaPropertiesConfig.topic);
        consumerThread.start();
    }
}
