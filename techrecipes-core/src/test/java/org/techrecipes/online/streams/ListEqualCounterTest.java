package org.techrecipes.online.streams;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListEqualCounterTest {

    String noneMatched[] = {"Elephant", "Tiger", "Lion", "Bear", "Cheetah"};
    String oneMatched[] = {"Elephant", "Tiger", "Tiger", "Leopard", "Komodo Dragon"};
    ListEqualCounter listEqualCounter = new ListEqualCounter();

    @Test
    void checkAnyDupsInListUsingStreamsFrequency() {
        Assert.assertTrue(listEqualCounter.checkAnyDupsInListUsingStreamsFrequency("Tiger", Arrays.asList(noneMatched)) == 1);
        Assert.assertTrue(listEqualCounter.checkAnyDupsInListUsingStreamsFrequency("Tiger", Arrays.asList(oneMatched)) == 2);
    }

    @Test
    void checkAnyDupsInListUsingHashSet() {
        Assert.assertTrue(listEqualCounter.checkAnyDupsInListUsingStream(Arrays.asList(noneMatched)) == 5);
        Assert.assertTrue(listEqualCounter.checkAnyDupsInListUsingStream(Arrays.asList(oneMatched)) == 4);
    }

    @Test
    void checkAnyDupsInListUsingStream() {
        Assert.assertTrue(listEqualCounter.checkAnyDupsInListUsingHashSet(Arrays.asList(noneMatched)) == 0);
        Assert.assertTrue(listEqualCounter.checkAnyDupsInListUsingHashSet(Arrays.asList(oneMatched)) == 1);
    }
}