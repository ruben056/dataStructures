package be.rd.structures.arrays;

import java.util.*;

/**
 * Created by ruben on 6/8/14.
 */
public class RandomNumberGenerator {

    /**
     * returns unsorted int[] of sequential numbers
     * Because it was important for a test to have only unique numbers in the int[]
     *
     * @param resultSize
     * @return
     */
    public static int[] generateUniqueNrList(int resultSize){

        int[] result = new int[resultSize];
        for (int idx = 1; idx <= resultSize; ++idx){
            result[idx-1] = idx;
        }

        return shuffleArray(result);
    }

    /**
     * This is a bit of a bummer, shuffling arrays is not allready available in java
     * And colletions only contain Classes (not primitives) ... aijajaij...
     * For the purpose of the testing this will have to do ...
     *
     * @param array
     * @return
     */
    public static int[] shuffleArray(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : array) {
            list.add(i);
        }

        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }




}
