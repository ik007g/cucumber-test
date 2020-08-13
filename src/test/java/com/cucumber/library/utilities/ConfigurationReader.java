package com.cucumber.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        // try with resource --> try/catch block can take a parameter , AutoCloseable
        //reads file in java. we need to pass the path of the file
        String path=System.getProperty("user.dir")+"/configuration.properties";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            //file Reader as byte code
            //fileInputStream here is our configFile as Byte code
            //properties class can read byte code so we need the file as byte code
            // load contents of the file the properties object.
            properties.load(fileInputStream);

        } catch (IOException e) {
            System.out.println("The config file did not load");
            e.printStackTrace();
        }

    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
