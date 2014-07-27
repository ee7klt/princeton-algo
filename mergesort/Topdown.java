import java.util.Arrays;
import java.util.Comparator;


public class Topdown
    
{
    private static Comparable[] aux;
    public static int iter = 0;
    
    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        String arrstr = Arrays.toString(a);
        //System.out.printf("sort(%s,%d, %d)\n",arrstr,lo,hi);
        sort(a, lo, mid);
        int midhi=mid + (hi - mid)/2;
        // System.out.printf("sort(%s,%d, %d)\n",arrstr,mid+1,hi);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
        
    public static void merge (Comparable[] a, int lo, int mid, int hi)
{
    int i = lo, j = mid+1;
    
    Comparable[] aux = new Comparable[a.length];
    Comparable tmp = 0; 
        
        
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
        //a[k] = 0;
    }
    
    //System.out.println(Arrays.toString(aux));
    String arrstr = Arrays.toString(a);
        //System.out.printf("merge(%s,%d, %d, %d)\n",arrstr,lo,mid,hi);
    
    for (int k = lo; k <= hi; k++) {
        tmp = a[k];
        if (i > mid) {
            a[k] = aux[j++];
            //a[j-1] = tmp;
        }
        else if (j > hi) {
            a[k] = aux[i++];
            //a[i-1] = tmp;
        }
        else if (less(aux[j], aux[i])) {
            a[k] = aux[j++];
            //a[j-1] = tmp;
        }
        else  {
            a[k]=aux[i++];
            //a[i-1] = tmp;
        }
       //System.out.println(a[k]);
        //System.out.println(Arrays.toString(a));
        
                             
    }
    
     
    System.out.printf("%d: %s\n",++iter,Arrays.toString(a));
    
    
    
}

private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    

public static void main(String[] args) {
    Topdown TD = new Topdown();
    Comparable[] a  = {39, 80, 24, 68, 98, 25, 22, 91, 71, 67, 20, 38};
    System.out.printf("0: %s\n",Arrays.toString(a));
    //merge(a,0,2,5);
    TD.sort(a,0,11);
    //System.out.println(Arrays.toString(a));
    
    
 
 

}
        
        
}