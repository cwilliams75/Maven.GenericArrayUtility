package com.zipcodewilmington.arrayutility;


import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] array;

    public ArrayUtility(E[] array) {
        this.array = array;
    }

    public Integer countNumberOfOccurrence(E[] array, E valueToEvaluate) {
        int numberOfDuplicates = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToEvaluate)) {
                numberOfDuplicates++;
            }
        }
        return numberOfDuplicates;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        return countNumberOfOccurrence(ArrayUtils.addAll(array, arrayToMerge), valueToEvaluate);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        HashMap<E, Integer> merged = new HashMap<>();
        E[] both = ArrayUtils.addAll(array, arrayToMerge);
        for (int i = 0; i < both.length; i++) {
            if (merged.containsKey(both[i])){
            int count = merged.get(both[i]);
            count++;
            merged.put(both[i], count);
        }
        else
            { merged.put(both[i], 1);
        }
    }

    E mostCommon = null;
    int currentHighest = 0;
     for (Map.Entry<E, Integer> entry : merged.entrySet()){
        if(entry.getValue() >= currentHighest){
    mostCommon = entry.getKey();
    currentHighest = entry.getValue();
    }

    }

     return mostCommon;
}

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        return countNumberOfOccurrence(array, valueToEvaluate);

    }

    public E[] removeValue(E valueToRemove) {
        return ArrayUtils.removeAllOccurences(array, valueToRemove);

    }
}
