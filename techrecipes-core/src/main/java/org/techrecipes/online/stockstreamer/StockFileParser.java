package org.techrecipes.online.stockstreamer;

import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
@Component
public interface StockFileParser {
    public static final Logger logger = LoggerFactory.getLogger(StockFileParser.class);
    Properties propertiesData = new Properties();

    default void defaultProperties() {
        logger.debug("Debugging method End ==> StockFileParser.defaultProperties with Params [].");
        try {
            InputStream itStream = StockFileParser.class.getResourceAsStream("/tickrfilepath.properties");
            propertiesData.load(itStream);
        } catch (IOException ioe) {
            logger.error("Properties file not found");
        }
        logger.debug("Debugging method start ==> StockFileParser.defaultProperties with Params [].");
    }

    default String getTickrDailyFile() {
        logger.debug("Debugging method End ==> StockFileParser.getTickrDailyFile with Params [].");
        defaultProperties();
        String downloadFilePath = (String) propertiesData.get("Sample365FTPClient.pathname");
        String pathname = downloadFilePath + "stocks" + DateTimeFormat.forPattern("MMDDYYYY").print(new DateTime()) + ".txt";
        logger.debug("Debugging method End ==> StockFileParser.getTickrDailyFile with Params [].");
        return pathname;
    }
}