package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by shengjk1 on 2016/12/18.
 */
public class Form extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//登录表单中可以使用GridPane布局
		GridPane gridPane=new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		//gap属性管理行列之间的间隔
		gridPane.setHgap(10);//行间隔
		gridPane.setVgap(10);
		//padding管理grid 面板边缘周围的间隔，insets分别指定了上、右、下、左四边的间隔
		gridPane.setPadding(new Insets(25,25,25,25));
		
		
		
		
		
		
		Text scenetitle=new Text("Welcome");
		scenetitle.setId("welcome-text");
//		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
		gridPane.add(scenetitle,0,0,2,1);
		
		//Label
		Label userName=new Label("User Name:");
		gridPane.add(userName,0,1);
		TextField userTextField=new TextField();
		gridPane.add(userTextField,1,1);
		
		Label pw=new Label("Password:");
		gridPane.add(pw,0,2);
		PasswordField pwBox=new PasswordField();
		gridPane.add(pwBox,1,2);
		
		gridPane.setGridLinesVisible(true);
		
		
		
		//在gridPane上面添加按钮
		Button bt =new Button("Sign in");
//		bt.setAlignment(Pos.BOTTOM_RIGHT);
		HBox box=new HBox(10);
		box.setAlignment(Pos.BOTTOM_RIGHT);
		box.getChildren().add(bt);
//		gridPane.add(bt,1,4);
		gridPane.add(box,1,4);
		
		
		
		final Text actiontarget=new Text();
		gridPane.add(actiontarget,1,6);
		
		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("sing in button pressed");
			}
		});
		
		
		
		
		Scene scene=new Scene(gridPane,600,575);
		primaryStage.setScene(scene);
		scene.getStylesheets().add("Login.css");
		
		
		primaryStage.setTitle("JavaFx Welcome");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
