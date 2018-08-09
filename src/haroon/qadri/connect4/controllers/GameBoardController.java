package haroon.qadri.connect4.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import haroon.qadri.connect4.GameBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameBoardController implements Initializable {
	
	private GameBoard game;
	Image red;
	Image blue;
	
	@FXML
	private GridPane gameBoard;
	
    @FXML
    private void mouseClicked(MouseEvent e) {
    	int gridX = (int) Math.floor(e.getX() / 100);
    	int gridY = (int) Math.floor(e.getY() / 100);
    	boolean isRed = game.isRedTurn();
    	int row = game.makeMove(gridX, gridY);
    	if(row != -1) {
    		Circle circle = new Circle();
    		circle.setRadius(48);
	    	if(isRed) {
	    		circle.setFill(Color.RED);
	    		gameBoard.add(circle, gridX, row);
	    	} else {
	    		circle.setFill(Color.YELLOW);
	    		gameBoard.add(circle, gridX, row);
	    	}
    	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	red = new Image("/red.png");
    	blue = new Image("/blue.png");
		game = new GameBoard();
	}
}
