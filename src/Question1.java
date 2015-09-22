public class Question1 {
       public static void main(String[] args)
       {
            int nQueens = 6;
            int[][] board = new int[nQueens][nQueens];
      		System.out.println("The purpose of this application is to Play nQueens. It will try to determine the");
    		System.out.println("maximum number of times a queen can exist on a board based on an input ");
    		System.out.println("value from the user");
    		
            NQueenSimulator nQueenSim = new NQueenSimulator(nQueens);
              
            System.out.printf("\nNQueens has %s solutions for a boards size of %sx%s", nQueenSim.calcNQueen(board,0),nQueens,nQueens);
            
            nQueenSim = null;
       }
}

