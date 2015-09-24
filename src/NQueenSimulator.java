/*
 * Fred Small 
 * CISC 3150
 * 
 */
public class NQueenSimulator {
       int nQueens = 8;
       boolean debug = false;
       public NQueenSimulator()
       {
       
       }
       public NQueenSimulator(int nQueens)
       {
              this.nQueens = nQueens;
       }
       public NQueenSimulator(int nQueens,boolean debug)
       {
    	   //Used to debug application
    	   	  this.debug = true;
              this.nQueens = nQueens;
       }
       //public int calcNQueen(int[][] board, int currentRow,boolean debug)
       //{
       //this.debug = true;
       //   return calcNQueen(board,currentRow);
       //}
       public int calcNQueen(int[][] board, int currentRow)
       {
           	  if (debug) System.out.println("");
              if (debug) System.out.printf("\nRunning simulation with for a size of %sx%s\n",nQueens,nQueens);
              int combinations = 0;

              // if the curent row = the number of queens 
              // then the calculations are complete.
              if (currentRow == nQueens)
              {
                     printBoard(board);
                     if (debug) printBoardValue(board);
                     return 1;
              }
              

              
              for (int column=0; column< nQueens;column++)     {
            	     // This is a new board so add the queen to the Nth column
            	     // and set the column value to the value to the current row plus one.
            	     // and initial value of zero was passed into the class
            	     // current row gets incremented or decremented depending on if there
            	     // was a backtrack or not
                     if (board[currentRow][column] == 0){
                           board[currentRow][column] = 1+currentRow;
                     
                           
                           getNextSquareOnBoard(board,currentRow,column);
                           combinations += calcNQueen(board,currentRow+1);
                           if (debug) printBoardValue(board);
                           board[currentRow][column]=0;
                           backtrackQueen(board,currentRow);
                     }
              }
              //returns 1 if a solution was found or 0 if all solutions were exhausted
              return combinations; // return to the calling step combinations += calcNQueen(board,currentRow+1);
              
       }
       private void getNextSquareOnBoard(int[][] board, int currentRow, int column)
       {
              for (int row=currentRow+1;row < nQueens;row ++)
              {
            	  	 scanRow(board,row,column,currentRow);
            	  
                     int rowSpan= row - currentRow;
            	  	 scanLeft(board,row,column,currentRow,rowSpan);
            	  	 scanRight(board,row,column,currentRow,rowSpan);
                     
                     if (debug) System.out.printf("\n\n");
              }
       }
       private void scanRow(int[][] board, int row, int column, int currentRow)
       {
    	   if (debug) System.out.println("");
    	   if (debug) System.out.printf("BEFORE(C): CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n",currentRow,row,column,board[row][column]);
    	   if (debug) System.out.println("");
    	   if (board[row][column] == 0)
               board[row][column] = -(1+currentRow);
    	   if (debug) System.out.printf("AFTER(C) : CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
    	   if (debug) System.out.println("");
       }
       private void scanLeft(int[][] board, int row, int column, int currentRow,int rowSpan)
       {
    	   if (debug) System.out.println("");
    	   if (debug) System.out.printf("BEFORE(L): CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n",currentRow,row,column,board[row][column]);
    	   if (debug) System.out.println("");
    	   //if nothing to the left then invalidate
           if(column-rowSpan>=0 && board[row][column-rowSpan]==0)
               board[row][column-rowSpan] = -(1+currentRow);
    	   if (debug) System.out.printf("AFTER(L) : CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
    	   if (debug) System.out.println("");
       }
       private void scanRight(int[][] board, int row, int column, int currentRow,int rowSpan)
       {
    	   if (debug) System.out.println("");
    	   if (debug) System.out.printf("BEFORE(R): CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n",currentRow,row,column,board[row][column]);
    	   if (debug) System.out.println("");
    	   //if nothing to the right then invalidate
           if(column+rowSpan < nQueens && board[row][column+rowSpan]==0)
               board[row][column+rowSpan] = -(1+currentRow);
    	   if (debug) System.out.printf("AFTER(R) : CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
    	   if (debug) System.out.println("");
       }
       private void backtrackQueen(int[][] board,int currentRow)
       {
    	   //if (debug) System.out.printf("AFTER(L) : CurrentRow=%s Row=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
    	   //if (debug) printBoardValue(board);
    	   for(int row=currentRow+1;  row<nQueens;row++)
           {
                for (int col=0;col <nQueens; col++)
                {
                      if (board[row][col] > currentRow || board[row][col] < -currentRow)
                      {
                             board[row][col]=0;
                             if (debug) printBoardValue(board);
                      }
                }
                  
           }
       }
       private void printBoardValue(int board[][])
       {
    	   System.out.println("");
    	   System.out.println("\tBacktracking");
           //System.out.printf("\n\nGame Solution %s\n",solution);
           //System.out.printf("\n\nPossible N-Queen Solution\n");
           System.out.printf("\t=========================\n");

    	   System.out.println("");
           System.out.printf("\t");

           System.out.printf(" 0\t");  
           for (int i =0; i<nQueens;i++)
           {
                  System.out.printf("%2s\t",i+1);                  
           }
           System.out.println("");
           System.out.printf("\t");
           
           for (int i =0; i<=nQueens;i++)
           {
                  System.out.printf("--\t",i+1);                  
           }
           
           System.out.println("");
           System.out.printf("\t");
           for (int i =0; i< nQueens;i++)
           {
                  System.out.printf("%2s\t",i+1);
                  for(int j = 0; j < nQueens;j++)
                  {
                	  if (board[i][j] < 0)
                		  System.out.printf("%2s\t",board[i][j]);
                	  if (board[i][j] > 0)
                		  System.out.printf("%2s\t",board[i][j]);
                  }
                  System.out.println("");
                  System.out.printf("\t");
                  //for (int k =0; k<=nQueens;k++)
                  //{
                  //       //System.out.printf("--\t",k+1);                  
                  //}
                  System.out.println("");
                  System.out.printf("\t");
           }
       }
       private void printBoard(int board[][])
       {
    	   	  System.out.println("");
              System.out.printf("\n\nPossible N-Queen Solution\n");
              System.out.println("");
              
              System.out.printf("0\t");  
              for (int i =0; i<nQueens;i++)
              {
                     System.out.printf("%s\t",i+1);                  
              }
              System.out.println("");
              
              for (int i =0; i<=nQueens;i++)
              {
                     System.out.printf("-\t",i+1);                  
              }
              
              System.out.println("");
              for (int i =0; i< nQueens;i++)
              {
                     System.out.printf("%s\t",i+1);
                     for(int j = 0; j < nQueens;j++)
                     {
                           if (board[i][j] > 0){
                                  System.out.printf("Q\t");
                           }
                           else
                           {
                                  System.out.printf(" \t");
                           }
                     }
                     System.out.println("");
                     for (int k =0; k<=nQueens;k++)
                     {
                            System.out.printf("-\t",k+1);                  
                     }
                     System.out.println("");
              }
       }
}

