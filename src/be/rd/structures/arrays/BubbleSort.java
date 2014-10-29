package be.rd.structures.arrays;

/**
 * Created by ruben on 10/29/14.
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] toBeSorted = new int[]{5,4,3,2,1};
        new BubbleSort().sort(toBeSorted);

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
        boolean changed = false;
        do{
            changed=false;
            for(int i = 0; i < values.length - 1; i++){
                int j = values[i];
                int k = values[i+1];
                if(k < j)
                {
                    values[i] = k;
                    values[i+1] = j;
                    changed = true;
                }
            }
        }while(changed);
    }
}