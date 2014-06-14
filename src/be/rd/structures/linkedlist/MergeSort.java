package be.rd.structures.linkedlist;

/**
 * Created by ruben on 6/14/14.
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        new MergeSort().testLinkedList();
    }
    /**
     * Merge sort for doubly linked list :
     * has the same stable performance but not the drawback of using up a lot of space
     */

    public void testLinkedList()
    {
        /* linked list sort:**/
        /*Node head = new Node(7);
        Node second = new Node(4, head);
        Node third = new Node(6, second);
        Node fourth = new Node(9, third);
        Node fifth = new Node(3, fourth);*/

        Node head = new Node(1);
        Node second = new Node(3, head);
        Node third = new Node(2, second);
        Node fourth = new Node(4, third);
        Node fifth = new Node(5, fourth);

        head.logForward(true);

        head = merge_sort(head);
        head.setPrevious(null); // to make it totally correct...

        head.logForward(true);
    }

    public Node merge_sort(Node head) {
        if (head == null || head.getTheNext() == null) {
            return head;
        }
        Node middle = getMiddle(head);      //get the middle of the list
        Node secondHalf = middle.getTheNext();
        middle.setNext(null);   //split the list into two halfs
        Node headFirstPart = merge_sort(head); //recurse on that
        Node headSecondPart = merge_sort(secondHalf);
        return merge(headFirstPart, headSecondPart);
    }

    /*public Node merge(Node startNode, Node middleNode) {
        Node newHead = new Node(); // this keeps the now lowest value in the "next", hence the name, for the scope of this function
        Node curr = newHead; // for the first iteration in the loop they are the same so we can set value on newHead
        // then the curr is reinitialized at the end of each iteration to reflect the "current" node

        while (startNode != null && middleNode != null) {
            if (startNode.info <= middleNode.info) {
                curr.setNext(startNode); // also sets next on dummyhead in first iteration
                startNode = startNode.getTheNext();
            } else {
                curr.setNext(middleNode); // also sets next on dummyhead in first iteration
                middleNode = middleNode.getTheNext();
            }
            curr = curr.getTheNext(); // after one iteration curr is no longer same var as dummyHead
        }
        curr.setNext((startNode == null) ? middleNode : startNode);
        return newHead.getTheNext();
    }*/

    public Node merge(Node headFirstPart, Node headSecondPart) {
        Node newHead = new Node(); // this keeps the now lowest value in the "next", hence the name, for the scope of this function
        Node curNode = new Node(); // for the first iteration in the loop they are the same so we can set value on newHead
        // then the curr is reinitialized at the end of each iteration to reflect the "current" node that is being processed

        // keep reference tot the new hed of the merged values
        if(headFirstPart.getInfo() <= headSecondPart.getInfo())
        {
            newHead.setNext(headFirstPart);
        }
        else
        {
            newHead.setNext(headSecondPart);
        }

        while (headFirstPart != null && headSecondPart != null) {
            if (headFirstPart.getInfo() <= headSecondPart.getInfo()) {
                curNode.setNext(headFirstPart); // A. just keep reference to startnode in the curr, dont set the curr yet so the next line will not by applied to curr as well
                headFirstPart = headFirstPart.getTheNext(); // B. get the next Node
            } else {
                curNode.setNext(headSecondPart);// A. just keep reference to startnode in the curr, dont set the curr yet so the next line will not by applied to curr as well
                headSecondPart = headSecondPart.getTheNext();// B. get the next Node
            }
            curNode = curNode.getTheNext(); // C. now set the curNode
        }
        curNode.setNext((headFirstPart == null) ? headSecondPart : headFirstPart);
        return newHead.getTheNext();
    }

    /**
     * fast : moves 2 nodes per iteration
     * slow : moves 1 node per iteration
     *
     * ==> fast goes twice as fast as slow so when fast reaches the end (and iteration stops)
     * slow will have reached the middle...
     * @param head
     * @return
     */
    public Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow, fast;
        slow = fast = head;
        while (fast.hasNext() && fast.getTheNext().hasNext()) {
            slow = slow.getTheNext();
            fast = fast.getTheNext().getTheNext();
        }
        return slow;
    }
}
