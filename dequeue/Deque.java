//KL Tah
//July 7th 2014
//Princeton (Coursera) Algorithms I
//Assignment 2: Randomized Queues and Deques



import java.util.Iterator;
import java.util.NoSuchElementException;




public class Deque<Item> implements Iterable<Item> {
    
    
    private int N;    //size of stack
    private Node first,last; //top of stack
    
    private class Node {
      private Item item;
      private Node next;
    }
    
    public Deque()   {                        // construct an empty deque 
     first = null;
     last = null;
     N = 0;
     //assert check();
    }
    
    
    public boolean isEmpty()    {             // is the deque empty?
       return first == null;
    }
    
    
    public int size()  {                       // return the number of items on the deque
       return N;
    }
    public void addFirst(Item item)    {      // insert the item at the front (stack LIFO)
         Node oldfirst = first;
       first = new Node();
       first.item = item;
       first.next = oldfirst;
       N++;
       //assert check();
    }
    public void addLast(Item item)   {        // insert the item at the end (queue FIFO)
        Node oldlast = last;
       last = new Node();
       last.item = item;
       last.next = null;
       if (isEmpty()) first = last;
       else oldlast.next = last;
       N++;
       //assert check();
    }
    public Item removeFirst()       {         // delete and return the item at the front (stack LIFO/queue FIFO)
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      Item item = first.item; //save item to return
      first = first.next;  //delete first node
      if (isEmpty()) last = null;
      N--;
      return item; // return saved item
    
    }
   // public Item removeLast()       {          // delete and return the item at the end (neither stack nor queue)
    //   if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    //  Item item = last.item; //save item to return
      
    //  N--;
    //  return item // return saved item
    
    //}
public Iterator<Item> iterator()   {      // return an iterator over items in order from front to end
    return new ListIterator();
}

private class ListIterator implements Iterator<Item> {
   private Node current = first;
   public boolean hasNext() {return current != null; }
   public void remove() {throw new UnsupportedOperationException();}
   
   public Item next() {
     if (!hasNext()) throw new NoSuchElementException();
     Item item = current.item;
     current=current.next;
     return item;
   }

}
    
    public static void main(String[] args) {  // unit testing
    
    
    }
}



