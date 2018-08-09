package haroon.qadri.connect4;

import java.io.IOException;

import haroon.qadri.connect4.controllers.GameBoardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Core {
	
	private static Stage stage;
	
	public Core(Stage stage) {
		this.stage = stage;
	}
	
	public void newGame(boolean human) {
		GameBoard gb = new GameBoard();
		NodeControllerPair ncp = loadScene(Config.GAME_BOARD);
		GameBoardController gbc = (GameBoardController) ncp.getController();
		}
	
	public NodeControllerPair loadScene(String name) {
		FXMLLoader loader = new FXMLLoader();
		Node node = null;
		Object controller = null;
		try {
			node = loader.load(getClass().getResourceAsStream(name));
			controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeControllerPair ncp = new NodeControllerPair(node, controller);
		return ncp;
	}
	
	public static Stage getStage() {
		return stage;
	}
}
