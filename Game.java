package game;
import java.util.*;

public class Game {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//first lets make a board of size 3 x 3
		char[][] board = new char[3][3];
		
		
		//initially our board is empty
		for(int row=0; row < board.length; row++) {
			for(int col=0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		
		//there are two players X and O, by convention O goes first
		char player = 'O';
		boolean gameOver = false;
		
		
		
		while(!gameOver) {
			//take position from player 
			System.out.println("Player " + player + " enter:");
			int row =0;
			int col=0;
			
			boolean invalid = false;
			do {
				row = sc.nextInt();
				col = sc.nextInt();
				
				if(row>2 || row<0 || col>2 || col<0) {
					System.out.println("Please enter valid index.");
					invalid = true;
				}
				
				else if(board[row][col] == ' ') {
					board[row][col] = player;
					invalid = false;
				}
				else {
				System.out.println("Invalid move.Try again!");
				invalid = true;
			}
				
			}while(invalid);
			
			
			
			//check if the game is over and a player won
			if(gameWon(board,player)) {
				System.out.println("Player "+player +" won!!");
				gameOver = true;
			}
			else if(isDraw(board)) {
	                System.out.println("The game is a draw!");
	                gameOver = true;
	        }
			else {
				//next player will play
				player = player == 'X' ? 'O' : 'X' ;
			}
			
			display(board);
		}
		
		
	}
	
	//display our board 
		public static void display(char[][] board) {
			for(int row=0; row < board.length; row++) {
				for(int col=0; col < board[row].length; col++) {
					System.out.print(board[row][col] + "|");
				}
				System.out.println();
			}
		}
		
		//check if someone won
		public static boolean gameWon(char[][] board, char player) {
			
			//for row
			for(int row =0; row<board.length; row++) {
				if(board[row][0] == player && board[row][1] == player && board[row][2] == player ) {
					return true;
				}
			}
			
			//for columns
			for(int col =0; col<board.length; col++) {
				if(board[0][col] == player && board[1][col] == player && board[2][col] == player ) {
					return true;
				}
			}
			
			//for primary diagonal
			if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
				return true;
			}
			
			//for secondary diagonal
			if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
				return true;
			}
		
		
			return false;
			
		}
		
		// Check if the game is a draw
	    public static boolean isDraw(char[][] board) {
	        for(int row = 0; row < board.length; row++) {
	            for(int col = 0; col < board[row].length; col++) {
	                if(board[row][col] == ' ') {
	                    return false;  // There's at least one empty space, so it's not a draw
	                }
	            }
	        }
	        return true;  // No empty spaces left, it's a draw
	    }

}
