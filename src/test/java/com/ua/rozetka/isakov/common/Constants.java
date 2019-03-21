package com.ua.rozetka.isakov.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Constants {
    public static final long INT_WEB_TIMEOUT = 20000;
    private static final String STR_DEFAULT_PROPERTIES = "src/test/resources/web_props/stagePROD.properties";
    private static Properties properties = new Properties();

    public static Properties getProperties() {
        if (properties.isEmpty()) {
            try {
                properties
                        .load(
                                new FileReader(
                                        new File(
                                                System.getProperty("webProps", STR_DEFAULT_PROPERTIES)
                                        )));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}