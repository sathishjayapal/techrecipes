package org.techrecipes.online.file_utils;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * Created by sjayapal on 2/13/2017.
 */
public class FileReaderLambdaExpr {
    String defaultFileName = "data.txt";
    public Collection<String> readAndReturnFileContent(String fileName) throws IOException {
        Collection<String> emptyList = new ArrayList<String>();
        if (fileName == null) {
            fileName = defaultFileName;
        }
        new BufferedReader(
            new InputStreamReader(getSystemResourceAsStream(fileName))).
            lines().forEach(line -> emptyList.add(line));
        return emptyList.size() > 0 ? emptyList : Collections.EMPTY_LIST;
    }
}

