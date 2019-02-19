package org.techrecipes.online.streams;

import com.github.javafaker.Faker;

import java.util.*;

class ListStreamSearch {

    public int streamMapSample(List<Integer> inputList) {
        //Take each integer from the arraylist and multiply by 2 and add the value iteratively.
        return inputList.stream().map(e -> e * 2).reduce(0, Integer::sum);

    }

    public OptionalInt streaMapSampleOptional(List<Integer> integerList) {
        //Take each integer from the arraylist and multiply by 2 and add the value iteratively.
        return integerList.stream().mapToInt(w -> w * 2).reduce(Integer::sum);
    }

    public int checkSpecificNameItemInList(String inputNameStr) {
        Faker faker = new Faker();
        String names[] = {faker.name().fullName(), inputNameStr, faker.name().fullName(),
                faker.name().fullName()};
        return Arrays.binarySearch(names, inputNameStr);
    }

}

class ParallelStreamIteration {
    final static long MAX = 50000000;

    public static double computeSqrt() {
        double result = 0;
        for (int i = 0; i < MAX; i++) {
            result += Math.sqrt(i);
        }
        return result;
    }
}

class ListEqualCounter {

    public int checkAnyDupsInListUsingStreamsFrequency(String lookup, List lookupList) {
        return Collections.frequency(lookupList, lookup);
    }

    public int checkAnyDupsInListUsingHashSet(List lookList) {
        Set setData = new HashSet(lookList);
        return lookList.size() - setData.size();
    }

    public long checkAnyDupsInListUsingStream( List lookupList) {
        return lookupList.stream().distinct().count();
    }
}
