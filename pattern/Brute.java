import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;


public class Brute {
    

    
        
   /**
    * find out if the tuples are collinear
    */
    
    public static boolean checkSlopes(Point[] tuple) {
   
        Boolean truthy = false;
     
        
        Double slope = tuple[0].slopeTo(tuple[1]);
        //System.out.printf("i = 1, slope = %f\n",slope);
        int i = 2;
        while (slope == tuple[0].slopeTo(tuple[i++])) {
            //System.out.printf("i = %d, slope = %f\n",i-1,tuple[0].slopeTo(tuple[i-1]));
            if (i == 4) {truthy = true;}
            if (i == tuple.length) break;   
        }
        //System.out.println(i);
        
        
        return truthy;
    }
    
         
    
 
    
    public static void main(String[] args) {
        
        
        //init
  Scanner sc = new Scanner(System.in);
        
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
       System.out.print("Points drawn. Press any key to continue.\n");
      sc.nextLine();
        
        
        
        //find combinations of 4-tuples and check if they are collinear
        
      
        for (int i=0; i < points.length; i++) {
            
             
             //find combination of all 4-tuples
            for (int j=0; j<i; j++) {
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < k; l++) { 
                        Point[] tuple = {points[i],points[j],points[k],points[l]};
                        
                        //are all 4 points in this particular combination collinear?
                        //System.out.println(Arrays.toString(tuple));
                        Boolean collinear = checkSlopes(tuple);
                        //System.out.printf("Collinear? %s\n",collinear);
                        //System.out.printf("--------------------------\n");
                        
                        //if collinear, do stuff
                        if (collinear == true) {
                            
                            //put the 4 points in lexicographic order
                            Arrays.sort(tuple);
                            
                            //print out the points
                            System.out.printf("%s -> %s -> %s -> %s\n",tuple[0],tuple[1],tuple[2],tuple[3]);
                           // for (int m = 0; m < tuple.length; m++) {
                     
                              
                          // }
                            
                            //draw line from smallest point to largest point
                           tuple[0].drawTo(tuple[3]);
                             StdDraw.show(0);
                              // reset the pen radius
                            StdDraw.setPenRadius();
                        
                        }
                        
                    }
                }
            }
        }
        
         
   
        
        
    
    
    }
}