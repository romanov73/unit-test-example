package ru.ulstu.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    public static final PropertyManager INSTANCE = new PropertyManager();
    private final static String CONFIG_NAME = "config.properties";
    private enum ConfigKey {
        FILE_STORAGE("fileStorage"),
        TARGET_STORAGE("targetStorage"),
        DB_NAME("dbName"),
        DB_USER("dbUser"),
        DB_PASSWORD("dbPassword"),
        DB_HOST("dbHost"),
        DB_PORT("dbPort");

        private String keyName;

        ConfigKey(String key) {
            this.keyName = key;
        }

        public String getKeyName() {
            return keyName;
        }
    }

    private Properties properties;

    private PropertyManager() {
        properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream resourceStream = loader.getResourceAsStream(CONFIG_NAME)) {
            properties.load(resourceStream);
        } catch (Exception ex) {
            System.out.println(String.format("Config read error: %s", ex.getMessage()));
        }
    }

    public static PropertyManager getInstance() {
        return INSTANCE;
    }

    public String getFileStorage() {
        return properties.getProperty(ConfigKey.FILE_STORAGE.getKeyName());
    }

    public String getTargetStorage() {
        return properties.getProperty(ConfigKey.TARGET_STORAGE.getKeyName());
    }

    public void getProperty(String key) {
        properties.getProperty(key);
    }
}
