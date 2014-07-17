package be.rd.structures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by ruben on 7/14/14.
 */
public class ReverseChars {

    private static final String INPUT = "Hello World!!!\nLine two.";

    public static void main(String[] args){
        ReverseChars rc = new ReverseChars();
//        rc.messyStuff();
        rc.javaUtilLL();
    }

    /**
     * gebruikt java linkedlist
     */
    private void javaUtilLL(){
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> ll = new LinkedList<Character>();
        for(char c : INPUT.toCharArray())
        {
            if(!Character.isLetter(c)){
                while(ll.peek() != null)
                    sb.append(ll.pop());
                sb.append(c);

                ll = new LinkedList<Character>();
                continue;
            }
            ll.push(c);
        }

        System.out.println(sb.toString());
    }


    /**
     * gebruik eigen versie van linkedlist
     */
    private void useOwnLL(){
        // todo zou al moeten gemaakt zijn. moet nog commiten op andere pc
    }

    private void messyStuff(){
        System.out.println(INPUT);

        StringBuilder sb = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(INPUT, "\n");

        while(tokenizer.hasMoreElements()){

            String line = (String)tokenizer.nextElement();

            StringTokenizer t2 = new StringTokenizer(line, " ");

            while(t2.hasMoreElements()){
                String word = (String)t2.nextElement();

                char[] partialResult = new char[word.length()];
                char[] arr = word.toCharArray();
                for(int i = 0 ; i < arr.length;i++ ){
                    partialResult[i] = arr[arr.length - 1 - i];
                }
                sb.append(new String(partialResult)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println("OUTPUT:\n");
        System.out.println(sb.toString());
    }
}