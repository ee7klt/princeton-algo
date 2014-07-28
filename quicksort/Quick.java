/*
 * KL Tah
 * 27 July 2014
 * Quicksort algorithm. 
 */

import java.util.Arrays;
import java.util.Comparator;

public class Quick
{
    public static void sort(Comparable[] a)
    {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;   //stop when keys equal partitioning item
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a,j+1, hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true)
        {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            System.out.printf("i = %d, j = %d\n",i,j);
            exch(a,i,j);
           
        }
        System.out.printf("i = %d, j = %d\n",i,j);
        exch(a, lo, j);
        
        return j;
        
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
    
        // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
         System.out.printf("%s\n", Arrays.toString(a));
    }
    
    public static void main(String[] args) {
    Comparable[] a  = {'A', 'B', 'A', 'A', 'A', 'B', 'B', 'B', 'A', 'B', 'B', 'A'};
    
    Quick quick = new Quick();
    System.out.println(Arrays.toString(a));
    //merge(a,0,2,5);
    Quick.sort(a);
 //System.out.println(Arrays.toString(a));
 

}

    
    
}

