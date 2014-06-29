
import java.util.Arrays;


public class Percolation {
    
 private boolean[] grid;  //grid is [1,N^2]
 private int N;
 private WeightedQuickUnionUF UF; 
 private int nextSite;     // any of the neighboring sites
 private int thisSite;    //current site
     //= new WeightedQuickUnionUF(N);
 private int topVirtual = 0;   //index of top virtual site in grid[]
 private int bottomVirtual = N^2+1; //index of bottom virtual site in grid[]
 
 
 
 
 private void indexValidation(int i, int j) {   //throw exception for invalid indices
    if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
     if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index i out of bounds");
 }
 
 private int xyto1D(int i, int j) {    //maps cartesian i,j [1,N] to int [1,N^2]
     
     indexValidation(i,j);
     int index;
     index = i*N+j;                  //start counting from bottom left, proceed horizontally, then move up to next row (standard cartesians)
     //System.out.println(index);
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
      UF = new WeightedQuickUnionUF((int)Math.pow(N,2)+2);                //define new UF data structure
     System.out.println(Arrays.toString(grid));
     //System.out.println(UF.connected(1,2));
     

     
 };   

 
 public void open(int i, int j){  // open site (row i, column j) if it is not already
     indexValidation(i,j);       //is site within grid?
     thisSite = xyto1D(i,j);
     grid[thisSite] = true;   //mark site as open
    System.out.println("Opening site (" + i +","+ j +")");
     
    
    //if site is on top row, connect it to the top virtual site
    if (i == N) {
         UF.union(thisSite,bottomVirtual);
    }
    
    //if site is on bottom row, connect it to bottom virtual site
    if (i == 1) {
         UF.union(thisSite,topVirtual);
    }
    
    //check to see if neighboring sites are within grid.
    //if so, check to see if they are open
    //if so, connect them to present site
    
    if (i > 1) {  //left
          
          if (isOpen(i-1,j)) {
              nextSite = xyto1D(i-1,j);
             System.out.println("left is open!");
             System.out.println("connected = "+UF.connected(thisSite,nextSite));
             if (!UF.connected(thisSite,nextSite)) {
                 UF.union(thisSite,nextSite);
                 System.out.println("connected = "+UF.connected(thisSite,nextSite));
             };
             
          };

    };
     if (i <  N) {  //right
          if (isOpen(i+1,j)) {
              nextSite = xyto1D(i+1,j);
             System.out.println("right is open!");
             System.out.println("connected = "+UF.connected(thisSite,nextSite));
             if (!UF.connected(thisSite,nextSite)) {
                 UF.union(thisSite,nextSite);
                 System.out.println("connected = "+UF.connected(thisSite,nextSite));
             };
             
          };

    };
      if (j > 1) { //bottom
          if (isOpen(i,j-1)) {
              nextSite = xyto1D(i,j-1);
             System.out.println("bottom is open!");
             System.out.println("connected = "+UF.connected(thisSite,nextSite));
             if (!UF.connected(thisSite,nextSite)) {
                 UF.union(thisSite,nextSite);
                 System.out.println("connected = "+UF.connected(thisSite,nextSite));
             };
             
          };

    };
       if (j < N) { //top
          if (isOpen(i,j+1)) {
              nextSite = xyto1D(i,j+1);
             System.out.println("top is open!");
             System.out.println("connected = "+UF.connected(thisSite,nextSite));
             if (!UF.connected(thisSite,nextSite)) {
                 UF.union(thisSite,nextSite);
                 System.out.println("connected = "+UF.connected(thisSite,nextSite));
             };
             
          };

    };
      
        
    
};    

 
public boolean isOpen(int i, int j){ // is site (row i, column j) open?
    
    boolean truthy = false;
    indexValidation(i,j);
    if (grid[xyto1D(i,j)] == true) { 
        truthy = true;
    }
    //System.out.println(truthy);
    return truthy;
};
      



public boolean isFull(int i, int j){
    
    boolean truthy = false;
    thisSite = xyto1D(i,j);
    if (UF.connected(thisSite,topVirtual) == true) {    //trace grid to root.
        truthy = true;                           //if root of current site is the top virtual site, the site is full
    };
    return truthy;} ;   // is site (row i, column j) full?


public boolean percolates(){
    
    //WeightedQuickUnionUF UF=new WeightedQuickUnionUF(N);
    
    
    return true;}   ;          // does the system percolate?


public static void main(String[] args) {
    Percolation percolation = new Percolation(3);
    percolation.open(2,2);
    percolation.open(2,1);
    percolation.open(3,2);
    percolation.open(3,1);
    
    
    //percolation.isOpen(2,1);
    
    
}



}


