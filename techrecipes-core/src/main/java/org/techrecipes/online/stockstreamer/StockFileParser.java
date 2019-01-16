package org.techrecipes.online.stockstreamer;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface StockFileParser {
    public static final Logger LOG = LoggerFactory.getLogger(StockFileParser.class);
    Properties propertiesData = new Properties();

    default void defaultProperties() {
        try {
            InputStream itStream = StockFileParser.class.getResourceAsStream("/tickrfilepath.properties");
            propertiesData.load(itStream);
        } catch (IOException ioe) {
            LOG.error("Properties file not found");
        }
    }
}