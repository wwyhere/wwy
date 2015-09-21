package wwy.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({ @PropertySource(value = "classpath:constants.properties", ignoreResourceNotFound = false) })
public class Config {
    
    @Autowired
    private Environment environment;
    
    public String getTestConstants() {
        return environment.getProperty("system.testConstants");
    }
}
