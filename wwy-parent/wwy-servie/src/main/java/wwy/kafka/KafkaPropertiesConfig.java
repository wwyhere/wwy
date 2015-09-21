package wwy.kafka;

/**
 * 
 * @author wwy
 * @date 2015年6月6日下午11:26:41
 */
public class KafkaPropertiesConfig {
    
    public final static String zkConnect = "192.168.159.130:2181,192.168.159.130:2182,192.168.159.130:2183";
    public final static String groupId = "group1";
    public final static String topic = "my-replicated-topic";
    public final static String kafkaServerURL = "192.168.159.130";
    public final static int kafkaServerPort = 9092;
    public final static int kafkaProducerBufferSize = 64 * 1024;
    public final static int connectionTimeOut = 20000;
    public final static int reconnectInterval = 10000;
    public final static String topic2 = "topic2";
    public final static String topic3 = "topic3";
    public final static String clientId = "SimpleConsumerDemoClient";
}
