package be.rd.structures.arrays;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

/**
 * O(n * log n) : for instance : 100 elements --> 200 'iterations'
 * Created by ruben on 11/3/14.
 */
public class QuickSort {

    public static void main(String[] args) {

        QuickSort o = new QuickSort();
        List<Integer> nrs = RandomNumberGenerator.generateUniqueNrList(10);
        List<Integer> sorted = o.sort(nrs);

        for(Integer nr : sorted){
            System.out.println(nr.toString());
        }
    }

    private List<Integer> sort(List<Integer> nrs){

        if (nrs.size() < 2){
            return nrs;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        Integer pivot = nrs.get(0);

        for(Integer cur : nrs){
            if(cur.compareTo(pivot) == 0){
                continue;
            }
            if(cur.compareTo(pivot) < 0){
                left.add(cur);
            }else{
                right.add(cur);
            }
        }

        List<Integer> result = new ArrayList<>(nrs.size());
        result.addAll(sort(left));
        result.add(pivot);
        result.addAll(sort(right));

        return result;
    }
}
