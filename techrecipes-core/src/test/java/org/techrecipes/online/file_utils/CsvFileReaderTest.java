package org.techrecipes.online.file_utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileReaderTest {

    @Test
    void readCSVFile() {
        CsvFileReader csvFileReader = new CsvFileReader();
        csvFileReader.readCSVFile("/Users/skminfotech/IdeaProjects/techrecipes/techrecipes-core/src/main/resources/CsvFileReaderTestData.csv");
    }
}
