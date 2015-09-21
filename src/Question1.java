import java.util.Scanner;

public class Question1 {
	public static void main (String[] args)
	{
		int nQueens = 8;
		int solutions = 0;
		int column = 0;
		//Question1 question = new Question1();
		//NQueen question = new NQueen();
		System.out.println("The purpose of this application is to Play nQueens. It will try to deermine the");
		System.out.println("maximum number of combinations a quuen can exist on a board");
		System.out.println("based on an inupt value from the user");
		System.out.println("");
		@SuppressWarnings("resource")
		Scanner point = new Scanner(System.in);
		
		//nQueens = point.nextInt();
		NQueen question = new NQueen(nQueens);
		for (int row = 0;row< nQueens;row++){
			System.out.printf("Game Number %s\n",row+1);
			int[][] board = new int[nQueens][nQueens];
		

			//if(!question.locateSquare(board,column,nQueens,row)){
			System.out.println("Question1");
			if(!question.findNextSquare(board,column,row)){
				System.out.println("Bad number of queens");
			}
			else
			{
				solutions++;
				//question.printBoard(board, nQueens);
				question.printBoard(board);
			}
			System.out.println(" ***** GAME OVER *****");
			System.out.println("\n\n");
		}

		question = null;
		System.out.println("");
		System.out.printf("Solutions=%s\n",solutions);
		System.out.println("Done");
	}
	/*
	public boolean locateSquare(int board[][],int col,int nQueens,int row)
	{
		if (col >= nQueens)
			return true;
		for (int i=0;i < nQueens;i++) {
			// System.out.printf("%s",i);
			if (placeSquare(board,i,col,nQueens)) {
				board[i][col] = 1;
				if (locateSquare(board,col + 1,nQueens,row))
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

		if (row >= nQueens) return false;
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
		System.out.printf("0\t");	
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
	*/
}
