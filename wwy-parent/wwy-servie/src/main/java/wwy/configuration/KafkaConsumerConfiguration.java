package wwy.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * 
 * @author wwy
 * @date 2015年7月5日上午12:19:42
 */
@Configuration
@PropertySources({ @PropertySource(value = "classpath:kafka-consumer.properties", ignoreResourceNotFound = false) })
public class KafkaConsumerConfiguration {

	@SuppressWarnings("unused")
	@Autowired
	private Environment environment;

	@Value("#{kafkaConsumerProperties}")
	private Properties kafkaConsumerProperties;

	// public String getZookeeperConnect() {
	// return kafkaConsumerProperties.getProperty("zookeeper.connect");
	// }
	//
	// public String getZookeeperSessionTimeOutMs() {
	// return
	// kafkaConsumerProperties.getProperty("zookeeper.session.timeout.ms");
	// }
	//
	// public String getZookeeperSyncTimeMs() {
	// return kafkaConsumerProperties.getProperty("zookeeper.sync.time.ms");
	// }
	//
	// public String getAutoCommitIntervalMs() {
	// return kafkaConsumerProperties.getProperty("auto.commit.interval.ms");
	// }

	/**
	 * @return the kafkaConsumerProperties
	 */
	public Properties getKafkaConsumerProperties() {
		return kafkaConsumerProperties;
	}

	/**
	 * @param kafkaConsumerProperties
	 *            the kafkaConsumerProperties to set
	 */
	public void setKafkaConsumerProperties(Properties kafkaConsumerProperties) {
		this.kafkaConsumerProperties = kafkaConsumerProperties;
	}
}
