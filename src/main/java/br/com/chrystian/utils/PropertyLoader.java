package br.com.chrystian.utils;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import static br.com.chrystian.utils.DefaultValues.ENVIRONMENTS_PATH;

@Log4j2
public class PropertyLoader {

    private static final String PROPERTY_NOT_FOUND = "Property '{0}' or directory 'environments/{1}/config.properties' wasn't found in config archives";
    private static final String SEARCH_FOR_PROPERTY = "Searching {0} in archive 'environments/{1}/config.properties: {2}'";

    private static String getProperties(final String property) {
        Properties properties = new Properties();
        String env = getEnvironment();

        try (InputStream propFileInpStream = new FileInputStream(ENVIRONMENTS_PATH + env + "/config.properties")) {
            properties.load(propFileInpStream);

            log.info(MessageFormat.format(SEARCH_FOR_PROPERTY, property, env, properties.getProperty(property)));

            return properties.getProperty(property);

        } catch (IOException | NullPointerException e) {
            log.error(MessageFormat.format(PROPERTY_NOT_FOUND, property, env, e));
        }
        return MessageFormat.format(PROPERTY_NOT_FOUND, property, env);
    }

    public static String getBaseURI() {
        return getProperties("service.baseuri");
    }

    public static String getBasePath() {return getProperties("service.basepath");}

    public static String getEnvironment() {
        return System.getProperty("env") == null ? "dev" : System.getProperty("env");
    }

}