package org.techrecipes.online.file_utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.techrecipes.online.stockstreamer.StockFileParser;

import java.io.*;
import java.util.Properties;

public class FileContentsDelete {
    static final Logger logger = LoggerFactory.getLogger(FileContentsDelete.class);
    Properties propertiesData = new Properties();

    public void deletFileWithPrintWriter(String printWriterFileName) {
        try {
            File fileForWriter = new File(printWriterFileName);
            System.out.println("fileForWriter.isFile() && fileForWriter.canWrite()" + (fileForWriter.isFile() && fileForWriter.canWrite()));
            if (fileForWriter.isFile() && fileForWriter.canWrite()) {
                PrintWriter printWriter = new PrintWriter(printWriterFileName);
                printWriter.println();
                printWriter.print("");
                printWriter.close();
            }
        } catch (IOException e) {
            logger.error("FileContentsDelete  data delete", e);
        }
    }
}
