package be.rd.structures.arrays;

import sun.net.www.content.audio.basic;

import java.util.Arrays;

/**
 * Created by ruben on 6/8/14.
 *
 * TODO need to split this up in different classes ... with names that make a little more sense...
 */
public class ArrayTest {

    private static int ONE_MILLION = (int)Math.pow(10,7);

    public static void main(String[] args){
        basicInit();

        int[] searchArr = RandomNumberGenerator.generateRandomNumber(ONE_MILLION);
        linearSearch(searchArr);
        binarySearch(searchArr);
    }


    /**
     * Advantages
     * * simple
     * * sorted and unsorted arrays
     *
     * Disadvantages
     * * speed
     * * only useable on smaller arrays
     *
     * @param searchArr
     */
    private static void linearSearch(int[] searchArr){

        int toSearch = searchArr[searchArr.length - 1]; // always the longs search by looking for last in array...
        long start = startTimer("find linear");
        for (int cur: searchArr){
            if(cur == toSearch){

                log("found " + cur);
                endTimer("find linear", start);
            }
        }

    }

    /**
     * * search is faster
     *
     * * little bit more complex
     * * need to presort ... probably slower then linear search...
     * @param searchArr
     */
    private static void binarySearch(int[] searchArr){

        int toSearch = searchArr[searchArr.length - 1]; // always the longs search by looking for last in array...
        long start = startTimer("(including sort)");
        //1. sort
        long start2 = startTimer("find sort");
        /*bubbleSort(searchArr);*/
        Arrays.sort(searchArr);
        endTimer("find sort", start2);
        //2. binarysearch
        int loIndex = 0;
        int hiIndex = searchArr.length - 1;
        int midIndex;
        while (loIndex <= hiIndex)
        {
            // use unsigned rightshift to avoid overflow causing shift in negative area
            /*midIndex = (loIndex + hiIndex) / 2;*/
            midIndex = (loIndex + hiIndex) >>> 1;

            if (toSearch > searchArr [midIndex])
                loIndex = midIndex + 1;
            else
            if (toSearch < searchArr [midIndex])
                hiIndex = midIndex - 1;
            else
                break;
        }
        if (loIndex > hiIndex){
            log(toSearch + " not found");
        }else{
            endTimer("find binair (including sort)", start);
        }
    }

    /**
     * TODO
     * bubble sort : explanation (simple but slow)
     *
     * quicksort and heapsort are faster!
     *
     * @param x
     * @return
     */
    private static int[] bubbleSort(int[] x) {

        for (int pass = 0; pass <= x.length - 2; pass++) {
            for (int i = 0; i <= x.length - pass - 2; i++) {
                if (x[i] > x[i + 1]) {
                    int temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                }
            }
        }
        return x;
    }


    private static void basicInit(){
        int[] intArr = new int[4];
        for (int i: intArr){
            log(i);
        }

        class Clock{}

        Clock[] clocks = new Clock[4];
        for(Clock clock : clocks){
            log(clock);
        }
    }

    private static long startTimer(String name){
        return System.currentTimeMillis();
    }

    private static long endTimer(String name, long startMillisecs){
        long end = System.currentTimeMillis();
        log("timer " + name + " ended in " + (end-startMillisecs) );
        return end;
    }

    private static void log(int aMessage){
        System.out.println(aMessage);
    }

    private static void log(Object aMessage){
        System.out.println(aMessage);
    }

    private static void log(String aMessage){
        System.out.println(aMessage);
    }
}
