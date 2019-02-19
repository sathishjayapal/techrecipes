package org.techrecipes.online.file_utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.techrecipes.online.stockstreamer.StockFileParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class FileContentsDelete {
    static final Logger logger = LoggerFactory.getLogger(FileContentsDelete.class);
    Properties propertiesData = new Properties();

    public void deletFileWithPrintWriter(String printWriterFileName) {
        try {
            PrintWriter printWriter = new PrintWriter(printWriterFileName);
            printWriter.println();
            printWriter.print("");
            printWriter.close();
        } catch (IOException e) {
            logger.error("FileContentsDelete  data delete", e);
        }
    }
}
