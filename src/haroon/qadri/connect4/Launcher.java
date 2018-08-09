package haroon.qadri.connect4;

import haroon.qadri.connect4.controllers.GameBoardController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
	
	private static Core core;

	@Override
	public void start(Stage primaryStage) throws Exception {
		core = new Core(primaryStage);
		NodeControllerPair ncp = core.loadScene(Config.GAME_BOARD);
		primaryStage.setWidth(Config.WIDTH);
		primaryStage.setHeight(Config.HEIGHT);
		Scene scene = new Scene((Parent) ncp.getNode(), 900, 800);
		GameBoardController gbc = (GameBoardController) ncp.getController();
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Connect 4");
		primaryStage.setResizable(false);
		String css = this.getClass().getResource("/stylesheet.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		/*NodeControllerPair ncp2 = core.loadScene(Config.INDEX);
		MainController mc = (MainController) ncp.getController();
		mc.getMainPane().getChildren().add(ncp2.getNode());*/
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Core getCore() {
		return core;
	}
}
