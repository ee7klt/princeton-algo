/*************************************************************************
 * Name: KL Tah
 * Email: kltah1@gmail.com
 * Date: June/September 2014 
 * Course: Princeton (Coursera) Algorithms 1
 * 
 * Compilation:  javac Fast.java
 * Execution:    java fast input.txt
 * Dependencies: StdDraw.java, Point.java
 *
 * Description: Find collinear points by Mergesorting according to slopes.
 *
 *************************************************************************/


import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;


public class Fast {
    

    
    public static void main(String[] args) {
    
        
        /**draw points to stdout
          * 
          */
        
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
       
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
        
      // read in the input
      
         String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
            //draw all points
             p.draw();   
             
        }
    
          StdDraw.show(0);
       
          
          /**
           * sort points by lexicographic order
           * this is because sort will look at the compareTo method and
           * sort according to it if present, else it'll use it's on comparison benchmark
           * compareTo was defined in Point.java
           */
          Arrays.sort(points); 
          
         
              
              
          /**make a copy of points, and iterate through points[]
          *  the order of copy[] will keep changing through the loop
          *  so loop through points[] so that all points are hit.
          */
              
          Point[] copy = Arrays.copyOf(points,points.length);
         
           //because slope to itself is nInf, 
          //first element of copy[] (the sorted array by slopes) will always be points[i]
          
         for (int i=0; i < points.length ; i++) {
              Arrays.sort(copy,points[i].SLOPE_ORDER);     //sort copy[] by slopes wrt points[i]
              System.out.printf("%s,%s\n",points[i],copy[0]);   
             
         }
}
}