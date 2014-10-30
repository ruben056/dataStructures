package be.rd.structures.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rdm on 30/10/2014.
 */
public class InsertSort
{

    public static void main(String[] args){
        int[] toBeSorted = new int[]{5,4,3,2,1};
        List<Integer> sorted = new InsertSort().sort(toBeSorted);

        System.out.println("Result:");
        logIntArr(sorted);
    }

    public static void logIntArr(List<Integer> sorted)
    {
        System.out.print("[");
        for(Integer nr : sorted)
        {
            System.out.print(nr.intValue() +",");
        }
        System.out.println("]");
    }

    public List<Integer> sort(int[] values)
    {
        List<Integer> sortedLl = new LinkedList<>();
        loopNumbers: for(int cur : values)
        {
            for(int i = 0; i < sortedLl.size() ; i++)
            {
                if(cur < sortedLl.get(i)){
                    sortedLl.add(i, Integer.valueOf(cur));
                    continue loopNumbers;
                }
            }
            sortedLl.add(Integer.valueOf(cur));
        }

        return sortedLl;
    }
}
