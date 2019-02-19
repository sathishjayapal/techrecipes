package org.techrecipes.online.file_utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.techrecipes.online.stockstreamer.StockFileParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class FileContentsDeleteTest {
    FileContentsDelete contentsDelete;
    static final Logger logger = LoggerFactory.getLogger(FileContentsDelete.class);
    static String PRINTWRITER_FILEPATH;

    @BeforeAll
    static void populateFileContents() {
        Properties dataProps = new Properties();
        try {
            InputStream itStream = StockFileParser.class.getResourceAsStream("/tickrfilepath.properties");
            dataProps.load(itStream);
            PRINTWRITER_FILEPATH = dataProps.getProperty("FileContentsDelete.printwriterfilepath");
            System.out.println("PRINTWRITER_FILEPATH = " + PRINTWRITER_FILEPATH);
        } catch (IOException e) {
            logger.error("FileContentsDelete  data delete", e);
        }
    }

    @BeforeEach
    public void beforeFunction() {
        contentsDelete = new FileContentsDelete();
        System.out.println("FileContentsDeleteTest.populateFileContentsBefore");
    }

    @Test
    void deletFileWithPrintWriter() {
        contentsDelete.deletFileWithPrintWriter(PRINTWRITER_FILEPATH);
        System.out.println("deletFileWithPrintWriter File Contents");
    }
}