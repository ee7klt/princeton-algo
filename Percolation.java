
import java.util.Arrays;


public class Percolation {
 public Percolation(int N){ 
     boolean[][] grid = new boolean[N][N];
     System.out.println(Arrays.deepToString(grid));
 };   // create N-by-N grid, with all sites blocked
public void open(int i, int j){System.out.println("hi");}    ;     // open site (row i, column j) if it is not already
public boolean isOpen(int i, int j){System.out.println("hi");
    return true;}  ;  // is site (row i, column j) open?
public boolean isFull(int i, int j){System.out.println("hi");
    return true;} ;   // is site (row i, column j) full?
public boolean percolates(){System.out.println("hi");
    return true;}   ;          // does the system percolate?


public static void main(String[] args) {
    Percolation percolation = new Percolation(5);
    
}



}


