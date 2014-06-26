
import java.util.Arrays;


public class Percolation {
    
 private boolean[] grid;
 private int N;
 private WeightedQuickUnionUF UF; 
     //= new WeightedQuickUnionUF(N);
 
 
 
 
 private void indexValidation(int i, int j) {   //throw exception for invalid indices
    if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
     if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index i out of bounds");
 }
 
 private int xyto1D(int i, int j) {    //maps cartesian i,j [1,N] to int [0,N^2-1]
     
     indexValidation(i,j);
     int index;
     index = (i-1)*N+(j);
     System.out.println(index);
     return index;   
 }
 
 public Percolation(int N){   // create N-by-N grid, with all sites blocked
     this.N=N;
      //grid = new boolean[(int)Math.pow(N,2) + 2];   //+2 for virtual sites on top and bottom to make detection fast
     grid = new boolean[(int)Math.pow(N,2)+2];
      UF = new WeightedQuickUnionUF(N);
     System.out.println(Arrays.toString(grid));
     System.out.println(UF.connected(1,2));
     
System.out.println(UF);
     
 };   

 
 public void open(int i, int j){
     indexValidation(i,j);
     grid[xyto1D(i,j)] = true;
     
    System.out.println(Arrays.toString(grid));
}    ;     // open site (row i, column j) if it is not already
public boolean isOpen(int i, int j){ // is site (row i, column j) open?
    
    System.out.println("hi");
    return true;}  ;  
public boolean isFull(int i, int j){System.out.println("hi");
    return true;} ;   // is site (row i, column j) full?


public boolean percolates(){
    
    WeightedQuickUnionUF UF=new WeightedQuickUnionUF(N);
    
    System.out.println("hi");
    return true;}   ;          // does the system percolate?


public static void main(String[] args) {
    Percolation percolation = new Percolation(2);
    percolation.open(1,1);
    
    
}



}


