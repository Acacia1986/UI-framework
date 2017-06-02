package acacia.ui.testing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by miaomiao on 6/2/2017.
 */
public class ReadConfigFile {


    public static Properties getConfigProperties(String configPath){
        String configFile =   System.getProperty("user.dir") + File.separator + configPath;
        Properties configProperties = new Properties();
        try {
            configProperties.load(new FileInputStream(configFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProperties;
    }
}
