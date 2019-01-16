package org.techrecipes.online.stockstreamer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sample365FTPClientTest {

    @Test
    void downloadStockTickrFile() {
        Sample365FTPClient ftpClient = new Sample365FTPClient();
        ftpClient.downloadStockTickrFile();
    }
}