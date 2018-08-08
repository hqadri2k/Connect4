package haroon.qadri.connect4.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IndexController {
	
	int[][] board = new int[9][8];

	@FXML
	private Button playHuman;
	@FXML
	private Button playAI;
	@FXML
	private Button about;
	
}
