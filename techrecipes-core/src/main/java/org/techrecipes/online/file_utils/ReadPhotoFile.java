package org.techrecipes.online.file_utils;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
/**
 * Created by sathishjayapal on 5/30/16.
 */
public class ReadPhotoFile {
    public static void callImageFile(File dataFile) {
        try {
            Metadata metadata = ImageMetadataReader.
                    readMetadata(dataFile);
            ExifIFD0Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
            System.out.println("***************************");
            directory.getTags().stream().
                    filter(tag -> StringUtils
                            .isNotBlank(directory.getDescription(tag.getTagType()))).
                    forEach(tag -> System.out.println(
                            directory.getTagName(tag.getTagType()) + "-" + directory
                                    .getDescription(tag.getTagType())));
            System.out.println("***************************");
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        String[] arr = {"JPG"};
        FileUtils.iterateFiles(new File("./target"), arr, Boolean.TRUE)
                .forEachRemaining(x -> callImageFile(x));
        System.out.println(FileUtils.getUserDirectory().getAbsoluteFile());
    }
}
