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
          
         
              
              
          /**make a copy of points, and iterate through copy
          *the order of points will keep changing through the loop
          *so loop through copy so that all points are hit.
          */
              
          Point[] copy = Arrays.copyOf(points,points.length);
         
          
          
         for (int i=0; i < points.length ; i++) {
          
          
          /**There's a more elegant way.  
            * If you don't discard any points and always find all the equal-valued slope points in a 'run' 
            * then you won't get any subsegments.  
            * You'll still see permutations in the order of the points, 
            * but you can ignore all the permutations that aren't in the special order you're looking for.  
            * Hint: use a stable sort with the right set-up and then the 
            * discarding of 'runs' that are not in the correct order is pretty much automatic.
           *[mergesort which is used in arrays.sort() is stable]
           **/
          
           
             
          //sort array according to slopes made with present point
          Arrays.sort(copy, points[i].SLOPE_ORDER);
          
          //System.out.println(Arrays.toString(points));
          
                       
          int ncoll = 0;        //number of points collinear, in addition to present point
          int start_j = 0;
          int end_j = 0;
           int count = 0;
          Double slope = points[i].slopeTo(copy[0]);
           Double presentSlope  = points[i].slopeTo(copy[1]);
          int j = 2;
      
          /**
           * Compute slopes to all other points with respect to current point, points[i]
           * looks for "runs" of equal slopes.
           * if "run" is greater than 3, print out line and output points
           */
       
          
                
                
               
                /**
                 * only count points that are collinear, and run is in lexicographic order, so we don't print subset of lines, 
                 * or multiple lines on a given run
                 * If smallest point in a run is smaller than points[i], then points[i] is not the start of the run
                 * on the other hand, if smallest point in a run is larger than points[i], then all points in that run will be larger than it.
                 * Thus points[i] will be the start of the run.
                 * If we print only points where points[i] is the start of the run, this will ensure no permutations and subsets.
                 */
                
          while (j != copy.length) {
                boolean loopEnter = false;
                while ((Math.abs(presentSlope - slope) <0.0001) && (j != copy.length)){    //if we get consecutively identical slopes
                    System.out.printf("%f,%f\n", slope, presentSlope);
                    ncoll++;        //increment run counter
                    end_j = j;
                    slope = presentSlope;
                    presentSlope = points[i].slopeTo(copy[j]); 
                     j++;
                      loopEnter = true;
                } 
                    
                    if (ncoll >= 3) {       //if run is of more than 4 points collinear, print out points and draw line.
                        
                       
                  /**find out if points[i] is the start of that run.i.e. need points[i] to be the smallest point in run
                    * equality makes sure horizontal lines are included too.
                    */
                        
                        if (points[i].compareTo(copy[start_j]) < 0) {    
                         points[i].drawTo(copy[end_j]);
                         StdDraw.show(0); 
                         String output = "";
                      for (int k = start_j; k <= end_j; k++) {
                          output = output + " -> "+copy[k];
                      }
                      System.out.printf("%s%s\n",points[i],output);
                    }
                    }
                   
                   ncoll = 1;        //reset counter to find next run
                   start_j = j;
                   
                   if (!loopEnter) {
                       
                       slope = presentSlope;
                       presentSlope = points[i].slopeTo(copy[j]); 
                       j++;
                       
                   }
                       
          
               
          }
          
          
         
          
         
          
          
         
      }
      
    }
}