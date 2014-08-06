import java.util.Arrays;


public class Brute {
    
    
   /**
    * find out if the tuples are collinear
    */
    
    public boolean checkSlopes(Point p1, Point p2, Point p3, Point p4) {
   
     Boolean truthy = false;
     
     
   
        
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
        
        
        
       
        
        
        
        //find combinations of 4-tuples and check if they are collinear
        
      
        for (int i=0; i < points.length; i++) {
            for (int j=0; j<i; j++) {
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < k; l++) { 
                        Point[] tuple = {points[i],points[j],points[k],points[l]};
                        
                    }
                }
            }
        }
        
       
         
   
        
        
    
    
    }
}