package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    private T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToCheck) {
        array = Stream.concat(Arrays.stream(array), Arrays.stream(arrayToMerge)).toArray(size -> Arrays.copyOf(array, size));
        return getNumberOfOccurrences(valueToCheck);
    }

    public T getMostCommonFromMerge( T[] arrayToMerge) {

        array = Stream.concat(Arrays.stream(array), Arrays.stream(arrayToMerge))
                .toArray(size -> Arrays.copyOf(array, size));

        return Arrays.stream(array)
                .max((Comparator.comparingInt(this::getNumberOfOccurrences)))
                .orElse(null);
    }

    public Integer getNumberOfOccurrences( T valueToCheck) {
        return((int) Arrays.stream(array)
                .filter(val -> val == valueToCheck)
                .count());
    }

    public T[] removeValue(T valueToRemove) {
        return Arrays.stream(array)
                .filter(element -> !element.equals(valueToRemove))
                .toArray(size -> Arrays.copyOf(array, size));
    }
}
