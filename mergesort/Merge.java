import java.util.Arrays;
import java.util.Comparator;

public class merge {

public static void merge (Comparable[] a, int lo, int mid, int hi)
{
    int i = lo, j = mid+1;
    
    Comparable[] aux = new Comparable[a.length];
    Comparable tmp = 0; 
        
        
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
    }
    
    //System.out.println(Arrays.toString(aux));
    
    
    for (int k = lo; k <= hi; k++) {
       if (i > mid) a[k] = aux[j++];
       else if (j > hi) a[k] = aux[i++];
       else if (less(aux[j], aux[i])) a[k] = aux[j++];
       else  a[k]=aux[i++];
       //System.out.println(a[k]);
        System.out.println(Arrays.toString(a));
        
                             
    }
    
     
    System.out.println(Arrays.toString(a));
    
    
    
}

private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
        
public static void main(String[] args) {
    Comparable[] a  = {2,5,6,1,3,9};
    //System.out.println(Arrays.toString(a));
    merge(a,0,2,5);
 
 

}



}


