public class PercolationStats {
    
    private double[]  fracOpen;  //array keeping track of percentage of sites open for each of the T experiment.
    private int thisSite;
    
    public PercolationStats(int N, int T)    {// perform T independent computational experiments on an N-by-N grid
     //System.out.println(StdRandom.uniform());
     
        fracOpen = new double[T];  //assign length T to fracOpen
        //perform T experiments
        for (int x = 0; x < T ; x+=1) {
            
        
        Percolation percolation = new Percolation(N); 
        int counter = 0;    //counts number of open sites
     while (percolation.percolates() == false) {   //while system does not percolate, open random site
        //generate random index site
         int i = StdRandom.uniform(N)+1; 
         int j = StdRandom.uniform(N)+1;
         System.out.println("Random site to open is ("+i+","+j+")");
         //open random site if it was not already previously opened.
         //thisSite = percolation.xyto1D(i,j);
         //if (grid[thisSite] == false) {
            percolation.open(i,j);
         //} else {System.out.println("Site (" + i +","+ j +") previously opened. Skipping it.");}
     }   //end while loop
     
     //double perc = 
     
        }  //end for loop
        
    }
   //public double mean()                     // sample mean of percolation threshold
   //public double stddev()                   // sample standard deviation of percolation threshold
   //public double confidenceLo()             // returns lower bound of the 95% confidence interval
   //public double confidenceHi()             // returns upper bound of the 95% confidence interval
    public static void main(String[] args)   {// test client, described below
        PercolationStats percolationstats = new PercolationStats(3,1);
       
        
    }
}