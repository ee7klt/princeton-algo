/*************************************************************************
 * Name: KL Tah
 * Email: kltah1@gmail.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;
import java.util.Arrays;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new BySlope();;       // YOUR DEFINITION HERE
    
    //compare points by height
     public final Comparator<Point> HEIGHT_ORDER = new ByHeight();;

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    private double pInf = Double.POSITIVE_INFINITY;
    private double nInf = Double.NEGATIVE_INFINITY;

    
    /**
     * @this: point to which p1 and p2 is referenced
     * @param p1: first point to compare with this
     * @param p2: second point to compare with this
     * @return 1 if slope from this point to p1 is greater than slope to p2
     * @return -1 if slope from this point to p1 is less than slope to p2
     * @return 0 if slopes to p1 and p2 from this point are equal
     */
    private  class BySlope implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            
            //casting as int is a hack until i can figure out a more precise solution
            //return (int) (Point.this.slopeTo(p1) - Point.this.slopeTo(p2)); 
            
            //SOLUTION!!
            double diff = Point.this.slopeTo(p1) - Point.this.slopeTo(p2);
            
            if (diff > 0) {
                return 1;
            }else if (diff < 0) {
                return -1;
            }
            else return 0;
            
        
        }
    }
    
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
         double slope = 0;
        if ((this.x == that.x) && (this.y == that.y)) {
            slope = nInf;
        } else if (this.y == that.y) {
            slope = 0;
        } else if (this.x == that.x) {
            slope = pInf;
        } else  slope = (double) (this.y-that.y)/(this.x-that.x);
        
        return slope;
        
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    
    
     /**
     * @this: point to which @that is referenced
     * @return 1 if @that is higher than @this by lexicographic order
     * @return -1 if @that is lower than @this by lexicographic order
     * @return 0 if @this == @that are the same points
     */
    
      private  class ByHeight implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        /* YOUR CODE HERE */
        int truthy = 0;
        if (p1.x == p2.x && p1.y == p2.y) {
          truthy = 0;
        } else if (p1.y < p2.y) {
           truthy = -1;
        } else if ((p1.y == p2.y) && (p1.x < p2.x)) {
           truthy = -1;
        } else truthy = 1;
        return truthy;
        
    }
     }
      
      
     
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        int truthy = 0;
        if (this.x == that.x && this.y == that.y) {
          truthy = 0;
        } else if (this.y < that.y) {
           truthy = -1;
        } else if ((this.y == that.y) && (this.x < that.x)) {
           truthy = -1;
        } else truthy = 1;
        return truthy;
        
    }
     

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        Point point1 = new Point(2,3);
        Point point2 = new Point(4,9);
        //Point point2 = new Point(6,-6);
        //Point point3 = new Point(5,3);
        //double slope = point1.slopeTo(point2);
        //System.out.println(slope);
        //System.out.println(point1.compareTo(point2));
        //System.out.println(point2.compareTo(point1));
         //System.out.println(point1.compareTo(point1));
         //Point[] points = new Point[] {point1,point2,point3};
         //Arrays.sort(points);
         //System.out.println(Arrays.toString(points));
         point1.draw();
         point2.draw();
         //point1.drawTo(point2);
          StdDraw.show(0);
         
      
        
    }
}