package awesomecucumber.utils;

import awesomecucumber.constants.EnvType;

import java.util.Properties;

public class ConfigReader {
    private final Properties properties;
    private static ConfigReader configReader;

    private ConfigReader() {
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
            case STAGE ->
                   properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");

            case PROD ->
                    properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            default -> throw new IllegalStateException("Invalid env" + env);
        }
    }
public static ConfigReader getInstance(){
        if(configReader == null){
            configReader = new ConfigReader();
        }
        return configReader;
}

public String getBaseURL(){
      String prop =  properties.getProperty("baseURL");
      if(prop != null) return prop;
      else throw new RuntimeException("property base url is not specified");
}

}
