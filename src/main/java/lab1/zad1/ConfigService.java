package lab1.zad1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */
public class ConfigService {

    private Properties config = new Properties();

    public ConfigService(String path) {
        try {
            config.load(new FileInputStream(path));
        } catch (IOException e) {
            System.out.println("File not found due to: " + e.getMessage());
            throw new IllegalStateException(e);
        }
    }

    public ConfigService(Properties properties) {
        this.config = properties;
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
