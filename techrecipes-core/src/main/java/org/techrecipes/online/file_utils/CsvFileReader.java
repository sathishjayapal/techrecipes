package org.techrecipes.online.file_utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    String comma_delimiter = ",";
    int id_idx = 0;
    int first_name_idx = 1;
    int last_name_idx = 2;
    int biller_id_idx = 3;
    int biller_name_idx = 4;
    String full_name;

    public void readCSVFile(String fileName) {
        BufferedReader fileReader = null;
        List listData = new ArrayList();
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String tokens[] = line.split(comma_delimiter);
                if (tokens.length > 0) {
                    HumanObject humanObject = new HumanObject();
                    humanObject.setId(tokens[id_idx]);
                    String firstName = tokens[first_name_idx];
                    String fullName = "";
                    if (tokens.length >= 2 && (StringUtils.isNotEmpty(firstName) &&
                            StringUtils.isNotEmpty(tokens[last_name_idx]))) {
                        String lastName = tokens[last_name_idx];
                        fullName = StringUtils.joinWith(",", new String[]{firstName, lastName});
                    } else if (StringUtils.isNotEmpty(firstName)) {
                        humanObject.setFull_name(tokens[first_name_idx]);
                    } else if (StringUtils.isNotEmpty(tokens[last_name_idx])) {
                        humanObject.setFull_name(tokens[last_name_idx]);
                    }
                    if (tokens.length >= 4 && StringUtils.isNotEmpty(tokens[biller_name_idx])) {
                        humanObject.setBiller_name(tokens[biller_name_idx]);
                        humanObject.setBiller_id(tokens[biller_id_idx]);
                    }
                    listData.add(humanObject);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in Reading the CSV file");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException ioe) {
                System.out.println("Error while closing fileReader!!!");
                ioe.printStackTrace();
            }
        }
        System.out.println(listData.size());
    }
}
