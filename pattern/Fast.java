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
          
          /**
           * make array to keep slopes;
           */
          
          Double[] slopes = new Double[points.length-1];
              
              
          /**make a copy of points, and iterate through copy
          *the order of points will keep changing through the loop
          *so loop through copy so that all points are hit.
          */
              
          Point[] copy = Arrays.copyOf(points,points.length);
          Point[] temp = new Point[points.length+1];
          
          
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
          
         
          Arrays.fill(temp, null);
          temp[0] = points[i];
          /**
           * Compute slopes to all other points with respect to current point, points[i]
           * looks for "runs" of equal slopes.
           * if "run" is greater than 3, print out line and output points
           */
         // System.out.println(Arrays.toString(copy));
          for (int j = 1; j < points.length;j++) {
                Double presentSlope = points[i].slopeTo(copy[j]); 
                
                //System.out.printf("%s,%s\n", copy[j-1],copy[j]);
                //System.out.println((copy[j-1].compareTo(copy[j])));
                
                /**
                 * only count points that are collinear, and run is in lexicographic order, so we don't print subset of lines, 
                 * or multiple lines on a given run
                 * && (copy[j-1].compareTo(copy[j]) > 0)
                 * 
                 */
                
               
                if (Math.abs(presentSlope - slope) <0.0001){    //if we get consecutively identical slopes
                   
                    ncoll++;        //increment run counter
                    end_j = j;
                    temp[count++]=copy[j];   //put points in to temp array
                } else {
                    
                    if (ncoll >= 3) {       //if run is of more than 4 points collinear, print out points and draw line.
                        
                        //find out if points are strictly ascending or strictly descending
                        boolean order = true;
                        for (int l = 1; l < temp.length; l++) {
                          if (temp[l-1].compareTo(temp[l]) < 0) order = false;
                        }
                        
                        if (order) {
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
                   slope = presentSlope;    
                }
                //System.out.printf("slope = %f, presentSlope = %f, ncoll = %d\n",slope,presentSlope,ncoll);
          }
          
          
         
          
         
          
          
          //if there are 4 or more points collinear, 
          
          
          //check which points have equal slopes wrt p
          //index is the index of point array with final point of common slope
         // int index = checkSlopesFast(points);
          //System.out.printf("Point = %s, Index = %d\n",points[i],index); 
          
          //if there are three or more points with same slope wrt p (4 collinear)
          //draw line from first to last point
//          int index = 3;
//          if (index > 2) {
//               System.out.printf("%s -> %s -> %s -> %s\n",points[0],points[1],points[2],points[3]);
//              //draw line from smallest point to largest point
//                           points[0].drawTo(points[index]);
//                             StdDraw.show(0);
//                              // reset the pen radius
//                            StdDraw.setPenRadius();
//          }
      }
      
    }
}