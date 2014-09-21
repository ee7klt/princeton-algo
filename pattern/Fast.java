import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;


public class Fast {
    
        
    
//        private static int checkSlopesFast(Point[] tuple) {
//        //this doesn't work because the common slopes may not be at the beginning of the array.
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
    
    private static int checkSlopesFast(Point[] points) {
    
        int i = 1;
        int count = 0;
        while (count == 0) {
            
        
        
        
        }
    
    
    }
    
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
          
          //sort array according to slopes with present point
          Arrays.sort(points, points[i].SLOPE_ORDER);
          //System.out.println(Arrays.toString(points));
          
          //check which points have equal slopes wrt p
          //index is the index of point array with final point of common slope
          int index = checkSlopesFast(points);
          //System.out.printf("Point = %s, Index = %d\n",points[i],index); 
          
          //if there are three or more points with same slope wrt p (4 collinear)
          //draw line from first to last point
          if (index > 2) {
               System.out.printf("%s -> %s -> %s -> %s\n",points[0],points[1],points[2],points[3]);
              //draw line from smallest point to largest point
                           points[0].drawTo(points[index]);
                             StdDraw.show(0);
                              // reset the pen radius
                            StdDraw.setPenRadius();
          }
      }
      
    }
}