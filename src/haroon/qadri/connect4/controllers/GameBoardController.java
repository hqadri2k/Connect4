package haroon.qadri.connect4.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import haroon.qadri.connect4.Config;
import haroon.qadri.connect4.GameBoard;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class GameBoardController implements Initializable {
	
	private GameBoard game;
	Image red;
	Image blue;
	
	private Color NO_COLOUR = Color.rgb(230, 230, 230);
	private Color RED = Color.rgb(255, 0, 0);
	private Color YELLOW = Color.rgb(255, 255, 0);
	
	private final int RADIUS = 32;
	
	@FXML
	private GridPane gameBoard;
	
    @FXML
    private void mouseClicked(MouseEvent e) {
    	int gridX = (int) Math.floor(e.getX() / 80);
    	int gridY = (int) Math.floor(e.getY() / 80);
    	boolean isRed = game.isRedTurn();
    	int row = game.makeMove(gridX, gridY);
    	if(row != -1) {
    		Circle circle = (Circle) (gameBoard.getChildren().get(gridX*Config.COLS+row-(1*gridX)+1));
	    	if(isRed) {
	    		circle.setFill(RED);
	    	} else {
	    		circle.setFill(YELLOW);
	    	}
    	}
    }
    
    private void setupBoard() {
    	gameBoard = new GridPane();
    	for(int i=0; i<Config.ROWS; i++) {
    		gameBoard.addRow(i);
    	}
    	for(int j=0; j<Config.COLS; j++) {
    		gameBoard.addRow(j);
    	}
		for(int x=0; x<Config.COLS; x++) {
			for(int y=0; y<Config.ROWS; y++) {
				Circle circle = new Circle();
				circle.setRadius(24);
				circle.setFill(NO_COLOUR);
				gameBoard.add(circle, x, y);
			}
		}
    }
    
    public void newGame() {
    	//setupBoard();
    	gameBoard.setDisable(false);
		game = new GameBoard(this);
	    FadeTransition ft = new FadeTransition(Duration.millis(1000), gameBoard);
	    ft.setFromValue(0.2);
	    ft.setToValue(1.0);
	    ft.setCycleCount(1);
	    ft.play();
    }
    
    public void reset() {
		for(int x=0; x<Config.COLS; x++) {
			for(int y=0; y<Config.ROWS; y++) {
				Circle circle = (Circle) (gameBoard.getChildren().get(x*Config.COLS+y-(1*x)));
				circle.setFill(NO_COLOUR);
			}
		}
		newGame();
    }
    
    public void endGame() {
    	System.out.println("End game");
    	gameBoard.setDisable(true);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newGame();
		for(int x=0; x<Config.COLS; x++) {
			for(int y=0; y<Config.ROWS; y++) {
				Circle circle = new Circle();
				circle.setRadius(RADIUS);
				circle.setFill(NO_COLOUR);
				gameBoard.add(circle, x, y);
			}
		}
	}
}
