public class NQueenSimulator {
       int nQueens = 8;
       public NQueenSimulator()
       {
       
       }
       public NQueenSimulator(int nQueens)
       {
              this.nQueens = nQueens;
       }
       public int calcNQueen(int[][] board, int currentRow)
       {
              //System.out.printf("Running simulation with for a size of %sx%s\n",nQueens,nQueens);
              int totalSettingCount = 0;
              int solution = 0;
              if (currentRow == nQueens)
              {
                     solution++;
                     //printBoard(board,N,solution);
                     printBoard(board);
                     return 1;
              }
              

              
              for (int i=0; i< nQueens;i++)     {
                     if (board[currentRow][i] == 0){
                           board[currentRow][i] = 1+currentRow;
                     
                           
                           findValidSpacesOnBoard(board,currentRow,i);
                           totalSettingCount += calcNQueen(board,currentRow+1);
                           board[currentRow][i]=0;
                           resetBoard(board,currentRow);
                     }
              }
              return totalSettingCount;
       }
       private void findValidSpacesOnBoard(int[][] board, int currentRow, int i)
       {
              
              for (int row=currentRow+1;row < nQueens;row ++)
              {
                     if (board[row][i] == 0)
                           board[row][i] = -(1+currentRow);
                     
                     int rowGap= row - currentRow;
                     if(i-rowGap>=0 && board[row][i-rowGap]==0)
                           board[row][i-rowGap] = -(1+currentRow);
                     
                     if(i+rowGap < nQueens && board[row][i+rowGap]==0)
                           board[row][i+rowGap] = -(1+currentRow);
                     
              }
       }
       
       
       private void resetBoard(int[][] board,int currentRow)
       {
              for(int row=currentRow+1;  row<nQueens;row++)
              {
                     for (int col=0;col <nQueens; col++)
                     {
                           if (board[row][col] > currentRow || board[row][col] < -currentRow)
                                  board[row][col]=0;
                     }
                     
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
              
              //for (int i =0; i<=nQueens;i++)
              //{
              //       System.out.printf("-\t",i+1);                  
              //}
       }
}

