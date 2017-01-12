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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
● JavaFX应用程序的主类需要继承自application.Application类。start()方法是所有JavaFX应用程序的入口。

● JavaFX应用程序将UI容器定义为舞台(Stage)与场景(Scene)。Stage类是JavaFX顶级容器。
Scene类是所有内容的容器。例3-1中创建了Stage和Scene，然后为Scene设置了大小并使其可见。

● 在JavaFX中，Scene中的内容会以由图形节点(Node)构成的分层场景图(Scene Graph)来展现。
在本例中，root节点是一个StackPane对象，它是一个可以调整大小的layout节点。
这就意味着在用户改变stage大小时，root节点可以随scene的大小变化而变化。

● root节点包含一个带文本的按钮子节点，
按钮上添加了一个事件处理器(Event Handler)，它在点击按钮时会向控制台输出信息。

● 当JavaFX应用程序是通过JavaFX Packager工具打包时，main()方法就不是必需的的了，
因为JavaFX Package工具会将JavaFX Launcher嵌入到JAR文件中。
但是保留main()方法还是很有用的，这样你可以运行不带有JavaFX Launcher的JAR文件，
例如在使用某些没有将JavaFX工具完全集成进去的IDE时。
另外嵌入了JavaFX代码的Swing应用程序仍需要main()方法。
 */
public class Main1 extends Application {

    @Override
	//入口
	//JavaFX应用程序将UI容器定义为舞台(Stage)与场景(Scene)。Stage类是JavaFX顶级容器。
    public void start(Stage primaryStage) throws Exception{
//       Button btn =new Button();
//        btn.setText("hello world!");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("hahahha");
//            }
//        });
//		StackPane root =new StackPane();
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//		root.getChildren().add(btn);

		primaryStage.setTitle("Welcome");
		/*
		在登录表单中可以使用GridPane布局，
		因为它允许你创建一个灵活的行列网格来对控件进行布局。
		你可以将控件放到网格中的任意一个单元格，
		也可以设置控件根据需要跨单元格(span)摆放。
		 */
		GridPane grid=new GridPane();
		//居中，以左上角为准
		grid.setAlignment(Pos.CENTER);
		//gap属性管理行列之间的间隔
		grid.setHgap(10);
		grid.setVgap(10);
		//padding管理grid 面板边缘周围的间隔
		//insets分别指定了上、右、下、左四边的间隔 25像素
		grid.setPadding(new Insets(25,25,25,25));

		//增加文本(TEXT)、标签(LABLE)和文本域(TEXT FIELD)
		//创建了一个创建不可编辑的Text对象
		Text scentitle=new Text("Welcome");
		//使用setFont方法来设置了scenetitle变量的字体、字重(粗细)和字号
		scentitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));;
		//在grid中的行列号均从0开始，而scenetitle被添加到第0列、第0行。
		// grid.add()方法的最后两个参数分别表示列跨度为2、行跨度为1
		grid.add(scentitle,0,0,2,1);

		//创建lable对象，放到0列，第1行
		Label userName=new Label("User Name:");
		grid.add(userName,0,1);

		//创建文本输入框 第1列，第1行
		TextField userTextField=new TextField();
		grid.add(userTextField,1,1);

		Label pw =new Label("Password");
		grid.add(pw,0,2);

		PasswordField pwBox=new PasswordField();
		grid.add(pwBox,1,2);
		//便于调试显示网格
//		grid.setGridLinesVisible(true);

		//样例应用程序最后需要添加的两个控件是用于提交数据的Button控件和用于在用户点击按钮后显示信息的Text控件。
		javafx.scene.control.Button btn =new Button("Sign in");
		/*
		的HBox 布局面板，它的spacing被设置为10像素。HBox面板为按钮设置了与grid面板中其它控件不同的对齐方式。alignment属性值为Pos.BOTTOM_RIGHT，表示将对应的节点设置为靠右下对齐。
		按钮被添加为HBox面板的子节点，而HBox面板被添加到grid中的第1列，第4行。
		 */
		HBox hbBtn=new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		////将HBox pane放到grid中的第1列，第4行
		grid.add(hbBtn,1,4);

		//增加用于显示信息的文本
		final Text actiontarger=new Text();
		grid.add(actiontarger,1,6);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//当用户点击按钮时会将actiontarget对象的文本设置为”Sign in button pressed”，颜色设置为砖红色。
				actiontarger.setFill(Color.FIREBRICK);
				actiontarger.setText("Sign in button");
				String user =userTextField.getText();
				System.out.println("user  "+user);
				String pw=pwBox.getText();
				System.out.println("pw  "+pw);
			}
		});

		//如果你没有设置scene的大小，默认情况下scene将使用能将其内部组件全部显示的最小大小。
		Scene scene=new Scene(grid,300,275);
		primaryStage.setScene(scene);
//		//Scene类是所有内容的容器
//        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
