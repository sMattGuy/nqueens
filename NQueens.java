public class NQueens{
	public static int solutions = 0;
	public static void printCurrentBoard(int board[][],int size){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(((board[i][j]==1)?"Q":"X")+" ");
			}
			System.out.print("\n");
		}
	}
	public static boolean checkCells(int board[][], int col, int row, int size){
		//check left
		int i,j;
		for(i=0;i<col;i++){
			if(board[row][i] == 1){
				return false;
			}
		}
		//check up left diagnol
		for(i=row,j=col;i>=0 && j>=0;i--, j--){
			if(board[i][j] == 1){
				return false;
			}
		}
		//check down left diagnol
		for(i=row,j=col;i<size && j>=0;i++,j--){
			if(board[i][j] == 1){
				return false;
			}
		}
		return true;
	}
	public static boolean placeQueenInCol(int board[][], int col, int size){
		//if at end
		if(col >= size){
			solutions++;
			System.out.println("printing solution");
			System.out.print("[");
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					if(board[i][j] == 1){
						System.out.print("("+(i+1)+","+(j+1) + ") ");
					}
				}
			}
			System.out.print("]\n");
			printCurrentBoard(board,size);
			return true;
		}
		boolean result = false;
		for(int i=0;i<size;i++){
			if(checkCells(board,col,i,size)){
				board[i][col] = 1;
				result = placeQueenInCol(board, col+1, size) || result;
				board[i][col] = 0;
			}
		}
		return result;
	}
	public static void main(String args[]){
		if(args.length != 1){
			System.out.println("requires size");
			return;
		}
		int size = Integer.parseInt(args[0]);
		int board[][] = new int [size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				board[i][j] = 0;
			}
		}
		placeQueenInCol(board,0,size);
		System.out.println("\nNumber of solutions:" + solutions);
	}
}