import java.util.Arrays;

public class PercolationStats {
    
    private double[]  fracOpen;  //array keeping track of percentage of sites open for each of the T experiment.
    private int thisSite;
    private int gridSize;
    private int counter;
    private int N;
    private int T;
    private double mu;
    private double sigma;
    
    public PercolationStats(int N, int T)    {// perform T independent computational experiments on an N-by-N grid
     //System.out.println(StdRandom.uniform());
        this.T = T;
        this.N = N;
        fracOpen = new double[T];  //assign length T to fracOpen
        gridSize = (int)Math.pow(N,2);
        //perform T experiments
        for (int x = 0; x < T ; x++) {
            
        
        Percolation percolation = new Percolation(N); 
         counter = 0;    //counts number of open sites
     while (percolation.percolates() == false) {   //while system does not percolate, open random site
        //generate random index site
         int i = StdRandom.uniform(N)+1; 
         int j = StdRandom.uniform(N)+1;
         //System.out.println("Random site to open is ("+i+","+j+")");
         //open random site if it was not already previously opened.
         //thisSite = percolation.xyto1D(i,j);
         if (percolation.isOpen(i,j) == false) {
            percolation.open(i,j);
            ++counter;
            //System.out.println("Counter = "+counter);
         } //else {System.out.println("Site (" + i +","+ j +") previously opened. Skipping it.");}
     }   //end while loop
     
     //System.out.println("Fraction of open sites for experiment "+(x+1)+" of "+T+" is: "+counter+" of "+(gridSize));
     fracOpen[x] = (double) counter/gridSize;
     System.out.println("Fraction of open sites for experiment "+(x+1)+" of "+T+" is: "+fracOpen[x]);
     
        }  //end for loop
        
    }
    public double mean() {                     // sample mean of percolation threshold
       mu = StdStats.mean(fracOpen);
        return mu;
    }
    public double stddev() {
        if (T==1) {
            return Double.NaN;
        } else { 
            sigma =  StdStats.stddev(fracOpen);
            return sigma;
        }
    }// sample standard deviation of percolation threshold
   public double confidenceLo()  {           // returns lower bound of the 95% confidence interval
     return (mu - (1.96*sigma/Math.pow(T,.5)));
}
public double confidenceHi()    {         // returns upper bound of the 95% confidence interval
 return (mu + (1.96*sigma/Math.pow(T,.5)));
}
    public static void main(String[] args)   {// test client, described below
        PercolationStats percolationstats = new PercolationStats(1000,5);
        System.out.println(Arrays.toString(percolationstats.fracOpen));
        System.out.println(percolationstats.mean());
        System.out.println(percolationstats.stddev());
       System.out.println(percolationstats.confidenceLo());
       System.out.println(percolationstats.confidenceHi());
        
    }
}