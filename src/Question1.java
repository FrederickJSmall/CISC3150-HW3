import java.util.Scanner;

public class Question1 {
	public static void main (String[] args)
	{
		int nQueens = 8;
		Question1 question = new Question1();
		System.out.println("The purpose of this application is to Play nQueens. It will try to deermine the");
		System.out.println("maximum number of combinations a quuen can exist on a board");
		System.out.println("based on an inupt value from the user");
		System.out.println("");
		@SuppressWarnings("resource")
		Scanner point = new Scanner(System.in);
		
		//nQueens = point.nextInt();
		for (int i = 0;i< nQueens;i++){
			System.out.printf("Game Number %s\n",i+1);
			int[][] board = new int[nQueens][nQueens];
		

			if(!question.locateSquare(board,i,nQueens)){
				System.out.println("Bad number of queens");
			}
			
			question.printBoard(board, nQueens);
			System.out.println(" ***** GAME OVER *****");
			System.out.println("\n\n");
		}

		question = null;
		System.out.println("");
		System.out.println("Done");
	}
	public boolean locateSquare(int board[][],int col,int nQueens)
	{
		if (col >= nQueens)
			return true;
		for (int i=0;i < nQueens;i++) {
			if (placeSquare(board,i,col,nQueens)) {
				board[i][col] = 1;
				if (locateSquare(board,col + 1,nQueens))
						return true;
				board[i][col]=0;
			}
		}
		return false;
	}
	private boolean placeSquare(int board[][],int row,int col,int nQueens)
	{
		int i;
		int j;

		//Check rows
		for (i = 0; i < col; i++)
		{
			if (board[row][i] == 1)
				return false;
		}
		for (i=row, j = col;i >=0 && j >=0; i--, j--){
			if (board[i][j] == 1)
				return false;
		}
		for (i=row, j = col;j >=0 && i< nQueens; i++, j--){
			if (board[i][j] == 1)
				return false;
		}		
		return true;
	}
	public void printBoard(int board[][],int nQueens)
	{
		System.out.printf("X\t");	
		for (int i =0; i< nQueens;i++)
		{
			System.out.printf("%s\t",i+1);			
		}
		System.out.println("");
		for (int i =0; i< nQueens;i++)
		{
			System.out.printf("%s\t",i+1);
			for(int j = 0; j < nQueens;j++)
			{
				if (board[i][j] == 1){
					System.out.print("Q\t");
				}
				else
				{
					System.out.print(" \t");
				}
			}
			System.out.println("");
		}
	}
	
}
