package com.wwy.common.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author wwy
 * @date 2015年6月13日下午3:06:47
 */
public class PropertiesUtils {
    
    public static Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesFilePath);
        Enumeration<String> enumeration = resourceBundle.getKeys();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            properties.put(key, resourceBundle.getString(key));
        }
        return properties;
    }
    
    public static ResourceBundle loadBundleProperties(String propertiesFilePath) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesFilePath);
        return resourceBundle;
    }
}
