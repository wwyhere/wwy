package wwy.configuration;

import java.util.Properties;

import kafka.producer.ProducerConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author wwy
 * @date 2015年7月5日上午12:19:42
 */
@Configuration
public class KafkaProducerConfiguration {
    
    @Value("#{kafkaProducerProperties}")
    private Properties producerProperties;
    
    /**
     * 生产者bean
     * 
     * @return
     */
    @Bean(name = "producerConfig")
    public ProducerConfig getProducerConfiguration() {
        if (producerProperties == null) {
            throw new IllegalArgumentException("未配置生产者属性!");
        }
        return new ProducerConfig(producerProperties);
    }
    
    /**
     * @return the producerProperties
     */
    public Properties getProducerProperties() {
        return producerProperties;
    }
    
    /**
     * @param producerProperties
     *            the producerProperties to set
     */
    public void setProducerProperties(Properties producerProperties) {
        this.producerProperties = producerProperties;
    }
}
