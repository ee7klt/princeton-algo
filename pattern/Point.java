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

public class Point implements Comparable<Point> {

    // compare points by slope
    //public final Comparator<Point> SLOPE_ORDER;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    public double pInf = Double.POSITIVE_INFINITY;
    public double nInf = Double.NEGATIVE_INFINITY;

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
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        int truthy = 0;
        if (this.y < that.y) {
           truthy = 1;
        } else if ((this.y == that.y) && (this.x < that.x)) {
           truthy = 1;
        }
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
        Point point1 = new Point(2,3);
        Point point2 = new Point(6,-6);
        double slope = point1.slopeTo(point2);
        System.out.println(slope);
        point1.draw();
        point2.draw();
        point1.drawTo(point2);
        
    }
}