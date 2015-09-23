//import java.util.Scanner;

public class Question1NQueen {
	public static void main (String[] args)
	{
		int nQueens = 8;
		int solutions = 0;
		int column = 0;
		//Question1 question = new Question1();
		//NQueen question = new NQueen();
		System.out.println("The purpose of this application is to Play nQueens. It will try to determine a");
		System.out.println("single combination where the queens do not cross paths");
		System.out.println("based on an inupt value from the user");
		System.out.println("");
		//@SuppressWarnings("resource")
		//Scanner point = new Scanner(System.in);
		
		//nQueens = point.nextInt();
		NQueen question = new NQueen(nQueens);
		for (int row = 0;row< 1;row++){
			System.out.printf("Game on : Question 1\n");
			int[][] board = new int[nQueens][nQueens];
		

			//if(!question.locateSquare(board,column,nQueens,row)){
			//System.out.println("Question1");
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
}
