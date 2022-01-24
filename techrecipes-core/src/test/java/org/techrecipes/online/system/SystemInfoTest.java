package org.techrecipes.online.system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemInfoTest {

    @Test
    void checkCores() {
        SystemInfo systemInfo= new SystemInfo();
        systemInfo.checkCores();
        System.out.println("System Info" +systemInfo.toString());
    }
}
