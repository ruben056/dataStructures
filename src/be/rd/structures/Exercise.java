package be.rd.structures;

import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by ruben on 6/15/14.
 */
public class Exercise {

    public static void main(String[] args)
    {
        new Exercise().start();
    }


    /**
     * Keeps the count of one char then sort can occur based on the counter...
     */
    class Counter
    {
        private char ch;
        private int cntr = 0;

        public Counter(char ch)
        {
            this.ch = ch;
        }
        public void count()
        {
            cntr++;
        }

        public char getCh() {
            return ch;
        }
        public int getCntr() {
            return cntr;
        }
    }

    private String charsToSortByOccurence = "abcdefghijklmnopqrstuvwxyz_";


    private void start()
    {
        //1. read the file and count occurrences of all relevant characters
        Counter[] charCntrs = getCounterPerChar(charsToSortByOccurence);
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("/home/ruben/java/workspace/dataStructures/src/inputFile.txt"));
            String line;
            while((line = br.readLine()) != null)
            {
                char[] charsInLine = line.toCharArray();
                for(int i = 0; i < charsInLine.length; i++)
                {
                    char curChar = charsInLine[i];
                    countIfRelevant(charCntrs, curChar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); //...
        } finally{
            if(br != null)
            {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error while closing inputStream");
                }
            }
        }

        //2. sort all chars by the counter (highest occurence first)...
        Arrays.sort(charCntrs, new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return o2.getCntr() - o1.getCntr();
            }
        });

        //3. log result
        for(Counter cur : charCntrs)
        {
            /*System.out.println(cur.getCh()+ "(" + cur.getCntr() + ")");*/
            System.out.print(cur.getCh());
        }
    }

    public void countIfRelevant(Counter[] charArr, char c)
    {
        for(Counter curCounter :charArr)
        {
            if(curCounter.getCh() == c)
            {
                curCounter.count();
                return; // assume for this case charArr has no doubles
            }
        }
    }


    private Counter[] getCounterPerChar(String s)
    {
        Counter[] cntrs = new Counter[s.length()];
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length ; i++)
        {
            cntrs[i] =  new Counter(charArr[i]);
        }

        return cntrs;
    }
}
