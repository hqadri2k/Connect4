package haroon.qadri.connect4;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
	
	private Core core;

	@Override
	public void start(Stage primaryStage) throws Exception {
		setup();
		NodeControllerPair ncp = core.loadScene(Config.INDEX);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setScene(new Scene((Parent) ncp.getNode(), 800, 600)); 
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void setup() {
		core = new Core();
		core.newGame(true);
	}
}
