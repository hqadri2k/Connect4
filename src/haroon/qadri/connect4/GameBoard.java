package haroon.qadri.connect4;

public class GameBoard {
	
	final char RED = 'R';
	final char YELLOW = 'Y';
	final char EMPTY = ' ';
	
	boolean redTurn;
	
	int redCounters;
	int yellowCounters;
	
	char[][] board;
	int col = 7;
	int row = 7;
	
	public GameBoard() {
		board = new char[row][col];
		setupBoard();
		printBoard();
		redTurn = true;
		redCounters = 0;
		yellowCounters = 0;
	}
	
	public int makeMove(int col, int row) {
		for(int i=this.row-1; i>=0; i--) {
			if(board[i][col] == EMPTY) {
				board[i][col] = (redTurn ? RED:YELLOW);
				incrementCounters();
				checkWon(i, col);
				redTurn = (redTurn ? false:true);
				printBoard();
				return i;
			}
		}
		return -1;
	}
	
	private void incrementCounters() {
		if(redTurn) {
			redCounters++;
		} else {
			yellowCounters++;
		}
	}
	
	private boolean checkWon(int row, int col) {
		if(redTurn) {
			if(redCounters >= 4) {
				return checkPatterns(row, col);
			}
		} else {
			if(yellowCounters >= 4) {
				return checkPatterns(row, col);
			}
		}
		return false;
	}
	
	private boolean checkPatterns(int row, int col) {
		checkHorizontal(row,col);
		return false;
	}
	
	private boolean checkHorizontal(int row, int col) {
		char[] rowArray = board[row];
		return false;
	}
	
	private boolean checkVertical(int row, int col) {
		return false;
	}
	
	private boolean checkDiagonal() {
		return false;
	}
	
	private void setupBoard() {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				board[i][j] = EMPTY;
			}
		}
	}
	
	public void printBoard() {
		System.out.println();
		for(int i=0; i<row; i++) {
			System.out.print("[");
			for(int j=0; j<col; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.print(" ]");
			System.out.println();
		}
	}
	
	public boolean isRedTurn() {
		return redTurn;
	}

}
