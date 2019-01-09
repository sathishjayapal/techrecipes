package org.techrecipes.online.stockstreamer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * Created by sjayapal on 5/2/2017.
 */
public class Sample365FTPClient {
    static final String FTPServer = "ftp.nasdaqtrader.com";
    static final int BUFFER_SIZE = 4096;
    String ftpUrl = "ftp://ftp.nasdaqtrader.com/symboldirectory/bxtraded.txt";
    public static void main(String args[]) {
        Sample365FTPClient ftpClient = new Sample365FTPClient();
        ftpClient.downloadStockTickrFile();
    }
    public void downloadStockTickrFile() {
        URL url = null;
        try {
            url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            InputStream inputStream = conn.getInputStream();
            File saveFile = File.createTempFile("stocks", ".txt");
            if (saveFile.exists()) {
                saveFile.delete();
            } else {
                saveFile.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(saveFile);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("File downloaded " + saveFile.getAbsolutePath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
