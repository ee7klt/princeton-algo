
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;


public class Subset {   
 public static void main(String[] args){
   
     RandomizedQueue<String> randq = new RandomizedQueue<String>();
     
   
     
    String s;
     
    
    
    //command-line argument
    int k = Integer.parseInt(args[0]);
    
    //read sequence of strings from standard input
    while (!StdIn.isEmpty()) {
        s=StdIn.readString();
       randq.enqueue(s);
     }
     
    
    
    //initiate iterator, and print out first k values of the randomized queue
    Iterator<String> i = randq.iterator();
         while (i.hasNext() && (k-- > 0)) {
             String inte = i.next();
             System.out.println(inte);
         }
    
 
 
 
 
 }
}
