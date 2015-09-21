package wwy.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:constants.properties", ignoreResourceNotFound = false)
public class Config {

    @Autowired
    private Environment environment;

    private String testConstants;
    private String testConstantsExists;

    public String getTestConstants() {
        if (testConstants == null) {
            return environment.getProperty("system.testConstants");
        }
        return testConstants;
    }

    public void setTestConstants(String testConstants) {
        this.testConstants = testConstants;
    }

    public String getTestConstantsExists() {
        if (testConstantsExists == null) {
            return environment.getProperty("system.testConstantsExists");
        }
        return testConstantsExists;
    }

    public void setTestConstantsExists(String testConstantsExists) {
        this.testConstantsExists = testConstantsExists;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
