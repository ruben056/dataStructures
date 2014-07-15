package be.rd.structures.linkedlist;

/**
 * Created by rdm on 15/07/14.
 *
 * Reverses a basic doubly linked list
 * basically for each node starting from the head, the prev and next are switched
 * You can do this both iteratively with a loop as recursively
 * I would think iteratively is the "safer" solution since you will not have stack overflow issues on
 * big lists.
 */
public class Reverse
{
    public static void main(String[] args){
       new Reverse().test();
    }

    public void test(){
        SimpleNode head = new SimpleNode(1, null, null);
        SimpleNode second = new SimpleNode(2, head, null);
        head.next = second;
        SimpleNode third = new SimpleNode(3, second, null);
        second.next = third;
        SimpleNode fourth = new SimpleNode(4, third, null);
        third.next = fourth;
        SimpleNode fifth = new SimpleNode(5, fourth, null);
        fourth.next = fifth;

        head.logForward();

        head = reverseIterative(head);
        head.logForward();
        head = reverseIterative(head);
        head.logForward();

        head = reverseRecursively(head);
        head.logForward();
    }

    public SimpleNode reverseIterative(SimpleNode head){

        SimpleNode cur = head;
        while(cur.next != null){
            SimpleNode next = cur.next;
            SimpleNode prev = cur.previous;

            cur.previous = next;
            cur.next = prev;

            cur = next;
        }

        // last node(top?)  becomes head:
        cur.next = cur.previous;
        cur.previous = null;
        return cur;
    }

    public SimpleNode reverseRecursively(SimpleNode cur){
        SimpleNode next = cur.next;
        SimpleNode prev = cur.previous;

        cur.next = prev;
        cur.previous = next;
        if(next == null){
            // end of the list
            return cur;
        }else{
            // continue
            return reverseIterative(next);
        }
    }
}