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
				if(checkWon(i, col)) {
					System.out.println("Won");
				}
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
		return(checkHorizontal(row, col) || checkVertical(row, col) || checkDiagonal(row, col));
	}
	
	private boolean checkHorizontal(int row, int col) {
		char placed = board[row][col];
		int count = 1;
		int tempCol = col;
		boolean right = true;
		boolean left = true;
		while(right && tempCol < this.col-1) {
			tempCol++;
			if(board[row][tempCol] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				right = false;
			}
		}
		tempCol = col;
		while(left && tempCol > 0) {
			tempCol--;
			if(board[row][tempCol] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				right = false;
			}
		}
		return false;
	}
	
	private boolean checkVertical(int row, int col) {
		char placed = board[row][col];
		int count = 1;
		int tempRow = row;
		boolean up = true;
		boolean down = true;
		while(up && tempRow > 0) {
			tempRow--;
			if(board[tempRow][col] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				up = false;
			}
		}
		tempRow = row;
		while(down && tempRow < this.row-1) {
			tempRow++;
			if(board[tempRow][col] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				down = false;
			}
		}
		return false;
	}
	
	private boolean checkDiagonal(int row, int col) {
		return(checkTopLeftAndBottomRight(row, col) || checkTopRightAndBottomLeft(row, col));
	}
	
	private boolean checkTopLeftAndBottomRight(int row, int col) {
		char placed = board[row][col];
		int tempRow = row;
		int tempCol = col;
		int count = 1;
		boolean topLeft = true;
		boolean botRight = true;
		while(topLeft && tempRow > 0 && tempCol > 0) {
			tempRow--;
			tempCol--;
			if(board[tempRow][tempCol] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				topLeft = false;
			}
		}
		tempRow = row;
		tempCol = col;
		while(botRight && tempRow < this.row-1 && tempCol < this.col-1) {
			tempRow++;
			tempCol++;
			if(board[tempRow][tempCol] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				botRight = false;
			}
		}
		return false;
	}
	
	private boolean checkTopRightAndBottomLeft(int row, int col) {
		char placed = board[row][col];
		int tempRow = row;
		int tempCol = col;
		int count = 1;
		boolean topRight = true;
		boolean botLeft = true;
		while(topRight && tempRow > 0 && tempCol < col-1) {
			tempRow--;
			tempCol++;
			if(board[tempRow][tempCol] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				topRight = false;
			}
		}
		tempRow = row;
		tempCol = col;
		while(botLeft && tempRow < this.row-1 && tempCol > 0) {
			tempRow++;
			tempCol--;
			if(board[tempRow][tempCol] == placed) {
				count++;
				if(count == 4) {
					return true;
				}
			} else {
				botLeft = false;
			}
		}
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
