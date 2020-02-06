package br.com.chrystian.utils;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class PropertyLoader {

    private static final Logger LOGGER = LogManager.getLogger();

    private PropertyLoader() {
    }

    private static String getProperty(final String property) {
        Properties properties;

        try {
            properties = new Properties();

            String env = InputProperties.getEnvironment();
            String environmentsPath = DefaultValues.ENVIRONMENTS_PATH;

            try (InputStream propFileInpStream = new FileInputStream(environmentsPath + env + "/config.properties")) {
                properties.load(propFileInpStream);
            }

            LOGGER.info(MessageFormat.format("Finding {0} in archive 'environments/{1}/config.properties: {2}'", property, InputProperties.getEnvironment(), properties.getProperty(property)));

            return properties.getProperty(property);

        } catch (IOException | NullPointerException e) {
            LOGGER.error(MessageFormat.format("Property '{0}' or directory 'environments/{1}/config.properties' wasn't found in config archives", property, InputProperties.getEnvironment()), e);
        }
        return null;
    }

    @Getter
    public enum Service {

        BASEURI {
            @Override
            public String getValue() {
                return getProperty("service.baseuri");
            }
        },
        BASEPATH {
            @Override
            public String getValue() {
                return getProperty("service.basepath");
            }
        };

        public abstract String getValue();

    }

    @Getter
    public enum DataSource {

        DRIVER {
            @Override
            public String getValue() {
                return getProperty("datasource.driver");
            }
        },
        URL {
            @Override
            public String getValue() {
                return getProperty("datasource.url");
            }
        },
        USUARIO {
            @Override
            public String getValue() {
                return getProperty("datasource.usuario");
            }
        },
        SENHA {
            @Override
            public String getValue() {
                return getProperty("datasource.senha");
            }
        };

        public abstract String getValue();

    }

}