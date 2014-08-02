public class Brute {
    
 
    
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
        
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i]);
           Point point1 = points[i];
           int count = 0;
           double oldSlope = 0;
           Boolean[] pointsTruthy = new Boolean[points.length];
           for (
            for (int j = 0; j < points.length; j++) {
               Point point2 = points[j];
               double newSlope = point1.slopeTo(point2);
               if (newSlope == oldSlope) {
                  ++count;
                  
               }
               oldSlope = newSlope;
               
               
            
            }
            
            
        }
        
        
    
    
    }
}