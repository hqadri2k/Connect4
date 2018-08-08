package haroon.qadri.connect4;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Core {
	
	public void newGame(boolean human) {
		GameBoard gb = new GameBoard();
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
}
