import java.util.Arrays;
import java.util.Comparator;


public class MergeBU
{
    private static Comparable[] aux;
    public static int iter=0;
    
    
    public static void merge (Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo, j = mid+1;
    
        Comparable[] aux = new Comparable[a.length];
      
        
        
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
    
    
    
        for (int k = lo; k <= hi; k++) {
           if (i > mid) a[k] = aux[j++];
           else if (j > hi) a[k] = aux[i++];
           else if (less(aux[j], aux[i])) a[k] = aux[j++];
           else  a[k]=aux[i++];
           //System.out.println(Arrays.toString(a));
        }

     
        //System.out.println(Arrays.toString(a));
    }

private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)
            for (int lo = 0; lo < N-sz; lo += sz+sz) {
                merge(a,lo,lo+sz-1, Math.min(lo+sz+sz-1, N-1));
                System.out.printf("%d: %s\n",++iter,Arrays.toString(a));
            }
    }
    
    
    public static void main(String[] args) {
        
        MergeBU BU = new MergeBU();
    Comparable[] a  = {98, 69, 27, 52, 65, 35, 30, 16, 97, 64};
    System.out.printf("0: %s\n",Arrays.toString(a));
    //merge(a,0,2,5);
    BU.sort(a);
    //System.out.println(Arrays.toString(a));
    
    
 
 

}
     
}
        