public class Question1 {
       public static void main(String[] args)
       {
            int nQueens = 9;
            int[][] board = new int[nQueens][nQueens];
      		System.out.println("The purpose of this application is to Play nQueens. It will try to determine the");
    		System.out.println("maximum number of times a queen can exist on a board based on an input ");
    		System.out.println("value from the user; w/o the queens being able to cross each other");
    		
            System.out.printf("\nCalculating the possible number of NQueens combinations for a checkerboard size of %sx%s",nQueens,nQueens);
            NQueenSimulator nQueenSim = new NQueenSimulator(nQueens);
            System.out.printf("\nNQueens has %s solutions for a boards size of %sx%s", nQueenSim.calcNQueen(board,0),nQueens,nQueens);
            
            nQueenSim = null;
       }
}

