package wwy.kafka;

import java.util.Properties;

import com.wwy.utils.PropertiesUtils;

/**
 * 
 * @author wwy
 * @date 2015年6月13日下午2:16:51
 */
public class Consumer {
    
    public static void main(String[] args) {
        Properties properties = PropertiesUtils.loadProperties("kafka-producer");
        System.out.println(properties);
    }
}
