package haroon.qadri.connect4;

public class GameBoard {
	
	char[][] board;
	int col = 8;
	int row = 9;
	
	public GameBoard() {
		board = new char[col][row];
		printBoard();
	}
	
	public void printBoard() {
		for(int i=0; i<row; i++) {
			System.out.print("[");
			for(int j=0; j<col; j++) {
				System.out.print(" x");
			}
			System.out.print(" ]");
			System.out.println();
		}
	}

}
