package awesomecucumber.utils;

import awesomecucumber.constants.EnvType;

import java.util.Properties;

public class ConfigReader {

    private final Properties properties;
    private static ConfigReader configReader;

    private ConfigReader() {
        String env = System.getProperty("env", EnvType.STAGE.name());
        EnvType envType;

        try {
            envType = EnvType.valueOf(env);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid environment: " + env, e);
        }

        if (envType == EnvType.STAGE) {
            properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
        } else if (envType == EnvType.PROD) {
            properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
        } else {
            throw new IllegalStateException("Unsupported environment: " + env);
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getBaseURL() {
        String prop = properties.getProperty("baseURL");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property baseURL is not specified in the config file");
        }
    }
}
