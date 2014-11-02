package be.rd.structures.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruben on 11/2/14.
 */
public class Fibonacci {

    public static void main(String[] args) {
        int[] res = fibonacci(10);
        for(int nr : res){
            System.out.println(String.valueOf(nr));
        }

        /*System.out.println(fibonacciValueAt(0));
        System.out.println(fibonacciValueAt(1));
        System.out.println(fibonacciValueAt(2));
        System.out.println(fibonacciValueAt(3));*/
        System.out.println(fibonacciValueAt(45));

        // test again book solution... mine is faster ...
        new Fibonacci().cachedFibN(45);

    }

    /**
     * if len <= 2 then the method always returns an array with the first 2 items
     * @param len
     * @return
     */
    public static int[] fibonacci(int len){
        len = len < 2 ? 2 : len;
        int[] result = new int[len];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i < len; i++){
            result[i] = result[i-2] + result[i-1];
        }
        return result;
    }

    /**
     *
      * @param idx starts at zero
     * @return
     */
    public static int fibonacciValueAt(int idx){
        long startOffset = System.nanoTime();
        if(idx < 0){
            throw new IllegalArgumentException("Index of fibonacciValueAt starts at 0. " + idx + " is not valid.");
        }
        if(idx == 0){
            return 0;
        }
        if(idx == 1){
            return 1;
        }

        int[] prev2 = new int[2];
        prev2[0] = 0;
        prev2[1] = 1;
        for(int i = 1; i < idx; i++){
            int result = prev2[0] + prev2[1];
            prev2[0] = prev2[1];
            prev2[1] = result;
        }
        System.out.println("duration(" + idx  + ") : " + Long.toString(System.nanoTime() - startOffset));
        return prev2[1];
    }

    /**
     * so called quick solutoin from book...
     * Is fancy but slower then my iterative approach
     * Also this approach is more complex so no reason at all to ever use it...
     */
    private Map<Integer, Integer> fibCache = new HashMap<Integer, Integer>();
    public int cachedFibN(int n) {
        long startOffset = System.nanoTime();
        if (n < 0) {
            throw new IllegalArgumentException(
                    "n must not be less than zero");
        }
        fibCache.put(0, 0);
        fibCache.put(1, 1);
        int res = recursiveCachedFibN(n);
        System.out.println("duration(" + n  + ") : " + Long.toString(System.nanoTime() - startOffset));
        return res;
    }
    private int recursiveCachedFibN(int n) {
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
        fibCache.put(n, value);
        return value;
    }

}
