
public class NQueen {
	
	int nQueens = 8;
	
	public NQueen (int nQueens)
	{
		this.nQueens = nQueens;
	}
	public boolean findNextSquare(int board[][],int col,int row)
	{
		System.out.printf("Column=%s,Row=%s\n",col,row);
		if (col >= this.nQueens)
			return true;
		
		for (int i=0;i < this.nQueens;i++) {
			// System.out.printf("%s",i);
			if (checkNQueenSquares(board,i,col)) {
				board[i][col] = 1;
				if (findNextSquare(board,col + 1,row))
						return true;
				board[i][col]=0;
			}
			//
			//row++;
		}
		return false;
	}
	private boolean checkNQueenSquares(int board[][],int row,int col)
	{
		int i;
		int j;

		//if (row >= this.nQueens) return false;
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
		for (i=row, j = col;j >=0 && i< this.nQueens; i++, j--){
			if (board[i][j] == 1)
				return false;
		}		
		return true;
	}
	public void printBoard(int board[][])
	{
		System.out.printf("0\t");	
		for (int i =0; i< this.nQueens;i++)
		{
			System.out.printf("%s\t",i+1);			
		}
		System.out.println("");
		for (int i =0; i< this.nQueens;i++)
		{
			System.out.printf("%s\t",i+1);
			for(int j = 0; j < this.nQueens;j++)
			{
				if (board[i][j] == 1){
					System.out.print("Q\t");
				}
				else
				{
					System.out.print("X\t");
				}
			}
			System.out.println("");
		}
	}
}
