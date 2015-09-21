package wwy.service;

/**
 * 
 * @author wwy
 * @date 2015年7月4日下午4:47:34
 */
public interface KafkaProducerService {
    
    /**
     * 发送消息
     * 
     * @param topic
     *            主题
     * @param msg
     *            消息
     */
    public void sendMessage(String topic, String msg);
    
    /**
     * 发送消息
     * 
     * @param topic
     * @param key
     * @param msg
     */
    void sendMessage(String topic, String key, String msg);
    
    /**
     * 发送消息
     * 
     * @param topic
     * @param key
     * @param partKey
     * @param msg
     */
    void sendMessage(String topic, String key, Object partKey, String msg);
}
