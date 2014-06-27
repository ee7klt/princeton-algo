
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
     //create NxN grid + top and bottom virtual sites
     //top virtual site has index 0
     //bottom virtual site has index N^2+1
     //grid sites have indices 1 to N^2
     grid = new boolean[(int)Math.pow(N,2)+2];         
      UF = new WeightedQuickUnionUF(N);                //define new UF data structure
     System.out.println(Arrays.toString(grid));
     //System.out.println(UF.connected(1,2));
     

     
 };   

 
 public void open(int i, int j){  // open site (row i, column j) if it is not already
     indexValidation(i,j);       //is site within grid?
     int thisSite = xyto1D(i,j);
     grid[thisSite] = true;   //mark site as open
    System.out.println(Arrays.toString(grid));
     
    //check to see if neighboring sites are within grid.
    //if so, check to see if they are open
    //if so, connect them to present site
    
    if ((i-1) > 0) {
          
    };
        
    
};    

 
public boolean isOpen(int i, int j){ // is site (row i, column j) open?
    
    boolean truthy = false;
    indexValidation(i,j);
    if (grid[xyto1D(i,j)] == true) { 
        truthy = true;
    }
    System.out.println(truthy);
    return truthy;
};
      



public boolean isFull(int i, int j){
    return true;} ;   // is site (row i, column j) full?


public boolean percolates(){
    
    //WeightedQuickUnionUF UF=new WeightedQuickUnionUF(N);
    
    
    return true;}   ;          // does the system percolate?


public static void main(String[] args) {
    Percolation percolation = new Percolation(2);
    percolation.open(1,1);
    percolation.isOpen(2,1);
    
    
}



}


