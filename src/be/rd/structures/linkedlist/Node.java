package be.rd.structures.linkedlist;

/**
 * Created by ruben on 6/14/14.
 */
public class Node
{
    private Node previous;
    int info;
    private Node theNext;

    public Node(Node n){
        this.info = n.info;
        this.previous = n.getPrevious();
        this.theNext = n.getTheNext();
    }

    public Node(){
        super();
    }
    public Node(int info){
        this();
        this.info =info;
    }

    public Node(int info, Node previous){
        this(info);
        this.previous = previous;
        previous.theNext = this;
    }

    public void setPrevious(Node prev){
        this.previous = prev;
        if(prev != null)
        {
            prev.theNext = this;
        }
    }

    public void setNext(Node next){
        this.theNext = next;
        if(next != null)
        {
            next.previous = this;
        }
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getTheNext() {
        return theNext;
    }

    public int getInfo() {
        return info;
    }

    public boolean hasNext(){
        return (theNext != null);
    }

    public boolean hasPrevious()
    {
        return (previous != null);
    }

    @Override
    public String toString() {
        return String.valueOf(info);
    }


    /**
     * Logging the list in reverse order, starting from the current node
     */
    public void logBackward()
    {
        if(!this.hasNext())
        {
            System.out.print("[");
        }
        System.out.print(this.getInfo());
        if( !this.hasPrevious())
        {
            System.out.println("]"); // finish
        }
        else
        {
            System.out.print(",");
            this.getPrevious().logBackward(); // continue
        }
    }
    /**
     * logging the list in correct order, starting from the current node
     */
    public void logForward(boolean andBackWard)
    {
        if( !this.hasPrevious())
        {
            System.out.print("[");
        }
        System.out.print(this.getInfo());
        if(!this.hasNext())
        {
            System.out.println("]"); // finish
            if(andBackWard)
                this.logBackward();
        }
        else
        {
            System.out.print(",");
            this.getTheNext().logForward(andBackWard); // continue
        }
    }
}
