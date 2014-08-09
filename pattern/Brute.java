import java.util.Arrays;


public class Brute {
    

    
        
   /**
    * find out if the tuples are collinear
    */
    
    public static boolean checkSlopes(Point[] tuple) {
   
        Boolean truthy = false;
     
     
        Double slope = tuple[0].slopeTo(tuple[1]);
     
        int i = 2;
        while (slope == tuple[0].slopeTo(tuple[i++])) {
           if (i == tuple.length) break;   
        }
     
        if (i == 4) {truthy = true;}
        
        return truthy;
    }
    
         
    
 
    
    public static void main(String[] args) {
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
        }
        
        
        
       StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        
        
        
        //find combinations of 4-tuples and check if they are collinear
        
      
        for (int i=0; i < points.length; i++) {
            for (int j=0; j<i; j++) {
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < k; l++) { 
                        Point[] tuple = {points[i],points[j],points[k],points[l]};
                        Boolean a = checkSlopes(tuple);
                        //System.out.println(a);
                        if (a == true) {
                            System.out.println(Arrays.toString(Arrays.sort(tuple)));
                            for (int m = 0; m < tuple.length; m++) {
                     
                               tuple[m].draw();
                                StdDraw.show(0);
                            }
                        
                        }
                        
                    }
                }
            }
        }
        
         
   
        
        
    
    
    }
}