package org.techrecipes.online.streams;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.OptionalInt;

@RunWith(SpringRunner.class)
class ListStreamSearchTest {
    ListStreamSearch streamMapSample;

    @BeforeEach
    public void setUp() {
        streamMapSample = new ListStreamSearch();
    }

    @Test
    void testStreamMapSample() {

        Assert.assertEquals(42, streamMapSample.streamMapSample(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void testStreaMapSampleOptional() {

        Assert.assertEquals(OptionalInt.of(42), streamMapSample.streaMapSampleOptional(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void checkSpecificNameItemInList() {
        Assert.assertEquals(1, streamMapSample.checkSpecificNameItemInList("Sathish"));
    }
}