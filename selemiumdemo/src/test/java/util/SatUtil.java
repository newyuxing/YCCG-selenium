package util;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SatUtil {

    private static Properties properties = new Properties();

    private SatUtil() {
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty (String key){
        try {
            properties.load(new FileInputStream("src/test/resources/application.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);

    }


}
