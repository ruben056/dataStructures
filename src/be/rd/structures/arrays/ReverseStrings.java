package be.rd.structures.arrays;

/**
 * Created by ruben on 11/2/14.
 */
public class ReverseStrings {

    public static void main(String[] args){
        String s = "toReversetoreversetoreverse";
        /*System.out.println(new ReverseStrings().reverse2(s));*/
        System.out.println(new ReverseStrings().reverse(s));

    }

    public String reverse(String s){
        long startOffset = System.nanoTime();
        char[] original = s.toCharArray();
        int lastIdx = original.length-1;
        int i = 0;
        for( ; i < original.length / 2; i++){
            char right = original[lastIdx - i];
            char left = original[i];
            original[i] = right;
            original[lastIdx-i] = left;
        }
        printDurationForOffset(startOffset);
        return String.valueOf(original);
    }

    /**
     * book solution...
     */
    public String reverse2(final String s) {
        long startOffset = System.nanoTime();
        final StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        printDurationForOffset(startOffset);
        return builder.toString();
    }

    public static void printDurationForOffset(long offset){
        System.out.println("duration : " + Long.toString(System.nanoTime() - offset));
    }
}
