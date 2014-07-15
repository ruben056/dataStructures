package be.rd.structures.linkedlist;

/**
 * Created by rdm on 15/07/14.
 */
public class SimpleNode
{
    public SimpleNode next;
    public SimpleNode previous;
    public int data;

    public SimpleNode(int data, SimpleNode previous, SimpleNode next){
        this.data = data;
        this.previous = previous;
        this.data = data;
    }

    public boolean hasPrevious(){
        return previous != null;
    }

    public boolean hasNext(){
        return next != null;
    }

    public void logForward()
    {
        if( !this.hasPrevious())
        {
            System.out.print("[");
        }
        System.out.print(this.data);
        if(!this.hasNext())        {
            System.out.println("]"); // finish
        }
        else
        {
            System.out.print(",");
            this.next.logForward(); // continue
        }
    }
}