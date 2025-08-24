package awesomecucumber.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filePath) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
