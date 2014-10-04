//KL Tah
//Oct 3rd 2014
//Princeton (Coursera) Algorithms I
//Assignment 4: 8 Puzzle 


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class Board {
    
     private  int[] myBoard;
     private int blocksDim;
     private  final int[] goal;   //goal board. immutable
     private int i,j,k;   //loop counters
     private int ham = 0, man = 0;
        
        
    public Board(int[][] blocks)          { // construct a board from an N-by-N array of blocks
           blocksDim = blocks.length;
           myBoard = new int[blocksDim*blocksDim];
           goal = new int[blocksDim*blocksDim];
           
           //populate myBoard with initial board
           //myBoard is the board mapped to a 1d array
           for ( i = 0; i < blocksDim; i++) {
            for ( j = 0; j < blocksDim; j++) {
                
               myBoard[j+blocksDim*i] = blocks[i][j];
               System.out.println(myBoard[j+blocksDim*i]);
            }
            
            //form the goal board, which has size
            //of the initial board-1, and elements all in order
            
            for ( k = 0; k < blocksDim*blocksDim-1; k++) {
                goal[k] = k+1;  
                System.out.println(goal[k]);
            }
            
            //the last element of the goal board is 0,
            //which represents an unpopulated cell
            goal[blocksDim*blocksDim-1] = 0;
            
        }
        
        
        
    }
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()               {  // board dimension N
       return blocksDim;
    
    }
    
    public int hamming()                   { // number of blocks out of place
        for (i = 0; i< blocksDim*blocksDim; i++) {
          if (goal[i] != myBoard[i]) ham++;
          System.out.printf("goal = %d, board = %d\n",goal[i],myBoard[i]);
        }
        return ham;
    }
//    public int manhattan()                 // sum of Manhattan distances between blocks and goal
//    public boolean isGoal()                // is this board the goal board?
//    public Board twin()                    // a board obtained by exchanging two adjacent blocks in the same row
//    public boolean equals(Object y)        // does this board equal y?
//    public Iterable<Board> neighbors()     // all neighboring boards
//    public String toString()               // string representation of the board (in the output format specified below)
}
