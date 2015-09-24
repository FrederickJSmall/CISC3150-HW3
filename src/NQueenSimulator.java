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
              if (debug) System.out.printf("\nRunning simulation with for a size of %sx%s\n",nQueens,nQueens);
              int combinations = 0;
              //int solution = 0;
              if (currentRow == nQueens)
              {
                     printBoard(board);
                     if (debug) printBoardValue(board);
                     return 1;
              }
              

              
              for (int column=0; column< nQueens;column++)     {
                     if (board[currentRow][column] == 0){
                           board[currentRow][column] = 1+currentRow;
                     
                           
                           findValidSpacesOnBoard(board,currentRow,column);
                           combinations += calcNQueen(board,currentRow+1);
                           board[currentRow][column]=0;
                           resetBoard(board,currentRow);
                     }
              }
              return combinations;
       }
       private void findValidSpacesOnBoard(int[][] board, int currentRow, int column)
       {
              
              for (int row=currentRow+1;row < nQueens;row ++)
              {
                     //if (board[row][column] == 0)
                     //      board[row][column] = -(1+currentRow);
            	  	 scanRow(board,row,column,currentRow);
            	  
                     int rowSpan= row - currentRow;
            	  	 scanLeft(board,row,column,currentRow,rowSpan);
            	  	 scanRight(board,row,column,currentRow,rowSpan);
                     //if(column-rowSpan>=0 && board[row][column-rowSpan]==0)
                     //      board[row][column-rowSpan] = -(1+currentRow);
                     
                     //if(column+rowSpan < nQueens && board[row][column+rowSpan]==0)
                     //      board[row][column+rowSpan] = -(1+currentRow);
                     
                     if (debug) System.out.printf("\n\n");
              }
       }
       private void scanRow(int[][] board, int row, int column, int currentRow)
       {
    	   if (debug) System.out.println("");
    	   if (debug) System.out.printf("BEFORE(C): CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n",currentRow,row,column,board[row][column]);
           if (board[row][column] == 0)
               board[row][column] = -(1+currentRow);
    	   if (debug) System.out.printf("AFTER(C) : CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
       }
       private void scanLeft(int[][] board, int row, int column, int currentRow,int rowSpan)
       {
    	   if (debug) System.out.println("");
    	   if (debug) System.out.printf("BEFORE(L): CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n",currentRow,row,column,board[row][column]);
           if(column-rowSpan>=0 && board[row][column-rowSpan]==0)
               board[row][column-rowSpan] = -(1+currentRow);
    	   if (debug) System.out.printf("AFTER(L) : CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
       }
       private void scanRight(int[][] board, int row, int column, int currentRow,int rowSpan)
       {
    	   if (debug) System.out.println("");
    	   if (debug) System.out.printf("BEFORE(R): CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n",currentRow,row,column,board[row][column]);
           if(column+rowSpan < nQueens && board[row][column+rowSpan]==0)
               board[row][column+rowSpan] = -(1+currentRow);
    	   if (debug) System.out.printf("AFTER(R) : CurrentRow=%s TestingRow=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
       }
       private void resetBoard(int[][] board,int currentRow)
       {
    	   //if (debug) System.out.printf("AFTER(L) : CurrentRow=%s Row=%s, Column=%s, Value=%s\n\n",currentRow,row,column,board[row][column]);
    	   //if (debug) printBoardValue(board);
    	   for(int row=currentRow+1;  row<nQueens;row++)
           {
                for (int col=0;col <nQueens; col++)
                {
                      if (board[row][col] > currentRow || board[row][col] < -currentRow)
                             board[row][col]=0;
                }
                  
           }
       }
       private void printBoardValue(int board[][])
       {
    	   System.out.println("");
    	   System.out.println("\tBoard Values before reset");
           //System.out.printf("\n\nGame Solution %s\n",solution);
           //System.out.printf("\n\nPossible N-Queen Solution\n");
           System.out.printf("\t=========================\n");
           
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
                        //if (board[i][j] > 0){
                               System.out.printf("%2s\t",board[i][j]);
                        //}
                        //else
                        //{
                        //       System.out.printf(" \t");
                        //}
                  }
                  System.out.println("");
                  System.out.printf("\t");
                  for (int k =0; k<=nQueens;k++)
                  {
                         //System.out.printf("--\t",k+1);                  
                  }
                  System.out.println("");
                  System.out.printf("\t");
           }
       }
       //static void printBoard(int board[][],int N,int solution)
       private void printBoard(int board[][])
       {
              //System.out.printf("\n\nGame Solution %s\n",solution);
              System.out.printf("\n\nPossible N-Queen Solution\n");
              System.out.printf("======================\n");
              
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

