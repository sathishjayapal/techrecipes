package org.techrecipes.online.file_utils;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.fail;
/**
 * Created by sjayapal on 10/17/2016.
 */
public class Listingfiles {
    public static void main(String args[]) throws IOException {
        Optional<List<Path>> returnedPath = returnFiles(
                "/Users/sathishjayapal/Dropbox (Projects)/Projects Team Folder/Books");
        returnedPath.get().forEach(path -> readPdfBytArray(path));
    }
    public static Optional<List<Path>> returnFiles(String path) {
        Path startPath = Paths.get(path).normalize().toAbsolutePath();
        System.out.println("\nTEST: Java 8 Stream Parallel");
        try {
            Stream mapData;
            List<Path> arraysData = Files.find(
                    startPath,
                    Integer.MAX_VALUE,
                    (filePath, fileAttr) -> fileAttr.isRegularFile()).parallel()
                    .collect(Collectors.toList());
            return Optional.of(arraysData);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        return Optional.empty();
    }
    private static Map readPdfBytArray(Path fileName) {
        Map someDataMap = new HashMap();
        try {
            byte[] tempArray = FileUtils.readFileToByteArray(fileName.toFile());
            someDataMap.put(fileName.getFileName(), tempArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return someDataMap;
    }
}
