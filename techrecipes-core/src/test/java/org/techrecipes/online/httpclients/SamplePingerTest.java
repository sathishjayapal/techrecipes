package org.techrecipes.online.httpclients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SamplePingerTest {

    @Test
    void checkSiteStatus() {
        SamplePinger samplePinger= new SamplePinger();
        samplePinger.checkSiteStatus();
    }
}