package org.techrecipes.online.file_utils;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Created by sjayapal on 2/15/2017.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader processor) throws IOException;
}
