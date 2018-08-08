package haroon.qadri.connect4;

import javafx.scene.Node;

public class NodeControllerPair {
	
	private Node node;
	private Object controller;
	
	public NodeControllerPair() {
		
	}
	
	public NodeControllerPair(Node node) {
		this.node = node;
	}
	
	public NodeControllerPair(Node node, Object controller) {
		this.node = node;
		this.controller = controller;
	}
	
	public Node getNode() {
		return node;
	}
	
	public Object getController() {
		return controller;
	}
	
	public void setNode(Node node) {
		this.node = node;
	}
	
	public void setController(Object controller) {
		this.controller = controller;
	}
}
