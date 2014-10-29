package be.rd.structures.linkedlist;

/**
 * Reverses each word but keeps the order of the words.
 * Also leaves the punctuation marks as is.
 */
public class ReverseLetterPerWord
{
    private final static String INPUT = "blabla sdfqsdf.\n slmqdfj!! qsdfqsdf.";

    public static void main(String[] args){
        new ReverseLetterPerWord().test();
    }

    public void test(){
        System.out.println(INPUT);
        System.out.println("reverse per word:");
        System.out.println(reverseLettersPerWord(INPUT));
    }

    /**
     * Uses linked list because we don't know how big each list will be
     * (arraylist would have to reallocate memory all the time...)
     * @param s
     * @return
     */
    public String reverseLettersPerWord(String s){

        StringBuilder sb = new StringBuilder();

        SimpleNode head = null;
        SimpleNode prev = null;
        for(char c : s.toCharArray()){

            if(!Character.isLetter(c)){
                // reverse linkedlist
                if(head != null){
                    head = Reverse.reverseIterative(head);
                    sb.append(head.toString());
                    head = null;
                    prev = null;
                }
                sb.append(c);
                continue;
            }

            // as long as it is a letter build a linked list so we can
            // reverse it as soon as we encounter a char
            SimpleNode cur = new SimpleNode(c, prev, null);
            if(prev != null){
                prev.next = cur;
            }
            else{
                head = cur;
            }
            prev = cur;
        }

        return sb.toString();
    }
}