package org.techrecipes.online.references;
import org.techrecipes.online.file_utils.ReadPhotoFile;
import java.util.Optional;
/**
 * Created by sathishjayapal on 6/14/16.
 */
public class OptionalSys {
    Optional<ReadPhotoFile> readPhotoFile;
    public static void main(String args[]) {
    }
    public Optional<ReadPhotoFile> getReadPhotoFile() {
        return readPhotoFile;
    }
    public void setReadPhotoFile(Optional<ReadPhotoFile> readPhotoFile) {
        this.readPhotoFile = readPhotoFile;
    }
}
