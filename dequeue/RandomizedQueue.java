
//KL Tah
//Sept 21st 2014
//Princeton (Coursera) Algorithms I
//Assignment 2: Randomized Queues and Deques





import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;   //array of items
    private int N;       //number of elements on stack
    
    /**
     * initialize stack of size 2
     */
    public RandomizedQueue()    {             // construct an empty randomized queue
        a = (Item[]) new Object[2];
    }
    
   /**
    * @return true if stack is empty, else false 
    */
    public boolean isEmpty()               {  // is the queue empty?
     return N==0;   
        
    }
    
    
    /**
     * @return number of items on stack
     */
    public int size()                      {  // return the number of items on the queue
     return N;   
        
    }
    
    
    /**
     * move stack to new array of size max
     * @param max: size of new array
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    /**
     * Adds item to the stack
     * @param item: item to add
     * if array is full, double its size
     */
    public void enqueue(Item item)          { // add the item
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }
   //public Item dequeue()                    // delete and return a random item
   //public Item sample()                     // return (but do not delete) a random item
    public Iterator<Item> iterator()        { // return an independent iterator over items in random order
       
       return new RandIterator();
        
    }
    
    private class RandIterator implements Iterator<Item> {
        private int i = N;
       public void remove() {throw new UnsupportedOperationException();}
       public boolean hasNext() {return i > 0;};
       public Item next() {
           if (hasNext()) throw new NoSuchElementException();
           return a[--i];
       };
    }    
    
    
     public static void main(String[] args)   { // unit testing
        RandomizedQueue<Integer> randq = new RandomizedQueue<Integer>();
        
        for (int i = 1; i < 10; i++) {
        randq.enqueue(i);
        System.out.println(Arrays.toString(randq.a));
        System.out.println(randq.size());
        
        }
        
        
    }
}