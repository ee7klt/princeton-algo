
//KL Tah
//Sept 21st 2014
//Princeton (Coursera) Algorithms I
//Assignment 2: Randomized Queues and Deques





import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;




public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;   //array of items
    private int N = 0;       //number of elements on stack
    
    /**
     * initialize stack of size 2
     */
    public RandomizedQueue()    {             // construct an empty randomized queue
        a = (Item[]) new Object[1];
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
     * Adds item to the stack in a random location
     * @param item: item to add
     * if array is full, double its size
     */
    public void enqueue(Item item)          { // add the item
        if (item == null) throw new NullPointerException("Cannot add null");
        if (N == a.length) resize(2*a.length);
        //System.out.println(N);
        if (N>0) {
            int i = StdRandom.uniform(N);
            //System.out.println(i);
            Item temp = a[i];
            a[i] = item;          //insert new item at random location.
            a[N++] = temp;         //place replaced item at top of stack
        } else a[N++] = item;
       
    }
    
    /**
     * Removes and returns item at the top of stack
     * @return the item at top of stack
     * @throws java.util.NoSuchElementException if stack is empty
     */
    public Item dequeue()                    {// delete and return a random item
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[N-1];
        a[N-1] = null;                              // to avoid loitering
        N--;
        // shrink size of array if necessary
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    
    /**
     * Returns a random item from stack
     * @return a random item from stack
     * @throws java.util.NoSuchElementException if stack is empty
     */
    public Item sample()        {              // return (but do not delete) a random item
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
         int i = StdRandom.uniform(N);
         return a[i];
    }
    
    
    /**
     * Returns an iterator to this stack that iterates through the items in random order
     * @return an iterator to this stack  that iterates through the items in random order
     */
    public Iterator<Item> iterator()        { // return an independent iterator over items in random order
       
       return new RandIterator();
        
    }
    

    /**
     * an iterator, doesn't implement remove()
     */
    private class RandIterator implements Iterator<Item> {
        private Item[] copy;
          private int i = N;
        
        /**
         * put shuffle inside iterator class constructor method
         */
        public RandIterator() {
           copy = Arrays.copyOf(a,N);
           StdRandom.shuffle(copy);
        
        }
         
        
         
        
       public void remove() {throw new UnsupportedOperationException();}
       
       
       
       public boolean hasNext() {return i > 0;};
       public Item next() {
           if (!hasNext()) throw new NoSuchElementException();
           return copy[--i];
       };
    }    
    
    
     public static void main(String[] args)   { // unit testing
        RandomizedQueue<Integer> randq = new RandomizedQueue<Integer>();
      
        for (int i = 1; i < 10; i++) {
        randq.enqueue(i);
        System.out.println(Arrays.toString(randq.a));
        //System.out.println(randq.size());
        
        }
        System.out.println("------------");
          Iterator<Integer> i = randq.iterator();
          System.out.println(i);
         while (i.hasNext()) {
             Integer inte = i.next();
             System.out.println(inte);
         }
         
         randq.enqueue(null);
         
//         Iterator<Integer> j = randq.iterator();
//         while (j.hasNext()) {
//             Integer inte = j.next();
//             System.out.println(inte);
//         }

         
//         for (int j = 1; j < 10; j++) {
//             System.out.println(randq.sample());
//       // System.out.println(randq.dequeue());
//       // System.out.println(Arrays.toString(randq.a));
//        //System.out.println(randq.size());
//        
//        }
         
         
//          StdRandom.shuffle(randq.a);
//          System.out.println(Arrays.toString(randq.a));
//          StdRandom.shuffle(randq.a);
//          System.out.println(Arrays.toString(randq.a));
//          
//          int sz = randq.size();
//         Item[] copy = Arrays.copyOf(randq.a,sz);
//         StdRandom.shuffle(copy);
//         System.out.println(Arrays.toString(copy));
//         
        
         
         
        
        
    }
}