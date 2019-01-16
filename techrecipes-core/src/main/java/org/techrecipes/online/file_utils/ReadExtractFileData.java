package org.techrecipes.online.file_utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sjayapal on 12/27/2016.
 */
public class ReadExtractFileData {

    /**
     *
     * @return
     */
    public int refactorFileData() {
        final String fileNameInfo = "sample.csv";
        List<DataSample> dataSamples = Collections.EMPTY_LIST;
        try {
            List<String> str = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader
                    (new FileReader(fileNameInfo));
            bufferedReader.lines()
                    .forEach(line -> {
                        str.add(line);
                    });
            dataSamples = buildDataSamples(str);
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
        return dataSamples.size();
    }

    private List<DataSample> buildDataSamples(List<String> str) {
        List<DataSample> dataSamples = new ArrayList<>();
        for (String data : str) {
            String splitData[] = StringUtils.split(data, ",");
            DataSample dataSample = new DataSample();
            dataSample.setName(splitData[0]);
            dataSample.setEmail(splitData[2]);
            dataSample.setLicNumber(splitData[1]);
            dataSamples.add(dataSample);
        }
        return dataSamples;
    }
}

class DataSample {
    private String name;
    private String licNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(String licNumber) {
        this.licNumber = licNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}