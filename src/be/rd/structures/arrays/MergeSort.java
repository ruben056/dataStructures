package be.rd.structures.arrays;

import be.rd.structures.linkedlist.Node;

/**
 * Created by ruben on 6/12/14.
 */
public class MergeSort {

    private int[] numbers;

    private int number;

    public static void main(String[] args1)
    {
        int[] toBeSorted = new int[]{5,4,3,2,1};
        new MergeSort().sort(toBeSorted);

        System.out.println("Result:");
        logIntArr(toBeSorted);
    }

    public static void logIntArr(int[] arr)
    {
        System.out.print("[");
        for(int nr : arr)
        {
            System.out.print(nr +",");
        }
        System.out.println("]");
    }

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    /**
     *
     *
     * @param low
     * @param middle
     * @param high
     */
    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        int[] tmpArr = new int[numbers.length];
        for (int i = low; i <= high; i++) {
            tmpArr[i] = numbers[i];
        }

        int leftIdx = low;
        int rightIdx = middle + 1;
        int replaceIdx = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (leftIdx <= middle && rightIdx <= high) {
            int left = tmpArr[leftIdx];
            int right = tmpArr[rightIdx];
            if (left <= right) {
                numbers[replaceIdx] = left;
                leftIdx++;
            } else {
                numbers[replaceIdx] = right;
                rightIdx++;
            }
            replaceIdx++;
        }
        // Copy the rest of the left side of the array into the target array
        while (leftIdx <= middle) {
            numbers[replaceIdx] = tmpArr[leftIdx];
            replaceIdx++;
            leftIdx++;
        }

        System.out.println("helper:");
        logIntArr(tmpArr);
        System.out.println("numbers:");
        logIntArr(numbers);
    }



}