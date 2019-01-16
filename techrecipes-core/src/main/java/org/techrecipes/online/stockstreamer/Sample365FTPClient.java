package org.techrecipes.online.stockstreamer;

import org.apache.commons.io.FileUtils;
import org.joda.time.*;
import org.joda.time.field.MillisDurationField;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by sjayapal on 5/2/2017.
 */
public class Sample365FTPClient implements StockFileParser {
    static final int BUFFER_SIZE = 4096;
    static final Logger logger = LoggerFactory.getLogger(Sample365FTPClient.class);

    public Boolean downloadStockTickrFile() {
        Boolean returnData = Boolean.FALSE;
        Instant startTime = Instant.now();
        URL url = null;
        try {
            defaultProperties();
            String downloadFilePath = (String) propertiesData.get("Sample365FTPClient.pathname");
            String pathname = downloadFilePath + "stocks" + DateTimeFormat.forPattern("MMDDYYYY").print(new DateTime()) + ".txt";
            File stockFile = new File(pathname);
            if (!stockFile.exists()) {
                String ftpUrl = (String) propertiesData.get("Sample365FTPClient.ftpUrl");
                url = new URL(ftpUrl);
                URLConnection conn = url.openConnection();
                InputStream inputStream = conn.getInputStream();
                FileUtils.write(stockFile, "", Charset.defaultCharset());
                FileOutputStream outputStream = new FileOutputStream(stockFile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();
            } else {
                logger.error(" ***** File already downloaded for the day *****");
            }
            returnData = Boolean.TRUE;
        } catch (MalformedURLException e) {
            logger.error("FTP issue downloading file in Sample365FTPClient.class", e);
        } catch (IOException e) {
            logger.error("FTP issue downloading file in Sample365FTPClient.class", e);
        } catch (Exception e) {
            logger.error("Un recoverable FTP error. File not downloaded", e);
        }
        Instant endTime = Instant.now();
        int periodTime = MillisDurationField.INSTANCE.getDifference(endTime.getMillis(), startTime.getMillis());
        logger.debug("Time taken to FTP file to local is " + periodTime+" milli seconds");
        return returnData;
    }
}
