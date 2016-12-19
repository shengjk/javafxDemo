package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn=new Button();
		btn.setText("say Hello world");
		
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("==============");
			}
		});
		
		btn.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("mouse move");
				
			}
		});
		
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("hellp world");
			}
		});
		
		StackPane root=new StackPane();
		root.getChildren().add(btn);
		Scene se=new Scene(root,300,250);
		
		primaryStage.setTitle("hello world");
		primaryStage.setScene(se);
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}