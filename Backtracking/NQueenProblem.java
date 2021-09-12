package Backtracking;

import java.util.Scanner;

public class NQueenProblem {

	public static void placeNQueens( int n ) {
		
		int board[][] = new int[n][n];
		int leftDia[] = new int[30];
		int rightDia[] = new int[30];
		int colms[] = new int[30];
		placeQueensOptimized(n, 0, board, leftDia, rightDia, colms );
		placeQueens(n, 0, board);
	}
	
	
	private static void placeQueensOptimized(int n, int col, int[][] board,int[] leftDia, int rightDia[], int colms[] ) {
		if( col == n ) {
			//valid board configuration
			for( int i = 0; i < n; i++ ) {
				for( int j = 0; j < n; j++ ) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		    System.out.println();
			return;
		}
		
		for( int i = 0; i < n; i++ ) {
			if(( leftDia[i - col + n - 1] != 1 && rightDia[i + col] != 1) && colms[i] != 1) {
				
				board[i][col] = 1;
				leftDia[i - col + n - 1] = rightDia[i + col] = colms[i] = 1;
				
				placeQueensOptimized(n, col + 1, board, leftDia, rightDia, colms);
				
				board[i][col] = 0;
				leftDia[i - col + n - 1] = rightDia[i + col] = colms[i] = 0;
			}
		}
	}


	private static void placeQueens(int n, int row, int[][] board) {
		
		if( row == n ) {
			//valid board configuration
			for( int i = 0; i < n; i++ ) {
				for( int j = 0; j < n; j++ ) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		//check for all columns
		for( int i = 0; i < n; i++ ) {
			
			//check if it is safe to place queen
			if(isSafe(board, row, i)) {
				
				//then place the queen 
				board[row][i] = 1;
				//& move to next row
				placeQueens( n, row + 1, board);
				//backtrack
				board[row][i] = 0;
			}
			
		}
		
	}

	private static boolean isSafe(int board[][], int row, int col ) {
		int i, j;
		//return false if two queens share the same column
		for( i = 0; i < row; i++ ) {
			if( board[i][col] == 1 ) {
				return false;
			}
		}
		
		//return false if two queens share the same \ diagonal
		for( i = row, j = col; j >= 0 && i >= 0; i--, j--) {
			if( board[i][j] == 1 ) {
				return false;
			}
		}
		
		//return false if two queens share the same / diagonal
		for( i = row, j = col; i >= 0 && j < board.length; i--, j++ ) {
			if( board[i][j] == 1 ) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		placeNQueens(n);
		s.close();
	}

}
