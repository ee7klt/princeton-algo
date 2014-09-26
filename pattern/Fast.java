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
    
        
    
//        private static int checkSlopesFast(Point[] tuple) {
//        //this doesn't work because the common slopes may not be at the beginning of the array.
          //UPATE 9/14: actually, maybe they don't have to be at the beginining. since looping
    //through all points, eventually we'll get to where they come to the beginning of the array.
    
    
//        Boolean truthy = false;
//     
//        
//        Double slope = tuple[0].slopeTo(tuple[1]);
//        //System.out.printf("i = 1, slope = %f\n",slope);
//        int i = 2;
//        int index = 1;
//        
//        
//        
//        while (slope == tuple[0].slopeTo(tuple[i++])) {
//            //System.out.printf("i = %d, slope = %f\n",i-1,tuple[0].slopeTo(tuple[i-1]));
//            index++;
//            if (i == tuple.length) break;   
//        }
//        //System.out.println(i);
//        
//        
//        return index;
//    }
//    
    
//    private static int checkSlopesFast(Point[] points) {
//    
//        int i = 1;
//        int count = 0;
//        while (count == 0) {
//            
//        
//        
//        
//        }
//    
//    
//    }
    
    public static void main(String[] args) {
    
     StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
       
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
         //init
  //Scanner sc = new Scanner(System.in);
        
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
       //System.out.print("Points drawn. Press any key to continue.\n");
      //sc.nextLine();
      
      
     // System.out.println(Arrays.toString(points));
      for (int i=0; i < points.length; i++) {
          
          
          /**There's a more elegant way.  
            * If you don't discard any points and always find all the equal-valued slope points in a 'run' 
            * then you won't get any subsegments.  
            * You'll still see permutations in the order of the points, 
            * but you can ignore all the permutations that aren't in the special order you're looking for.  
            * Hint: use a stable sort with the right set-up and then the 
            * discarding of 'runs' that are not in the correct order is pretty much automatic.
           *[mergesort which is used in arrays.sort() is stable]
           **/
          
          
          //sort array according to slopes with present point
          Arrays.sort(points, points[i].SLOPE_ORDER);
          
          System.out.println(Arrays.toString(points));
          
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