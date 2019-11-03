package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Login {
	
	@FXML
	TextField username = new TextField();
	@FXML
	Button login2;
	@FXML
	PasswordField password = new  PasswordField();
	
	static Connection connect=null;
	static String DatabaseName="student";
	static String url = "jdbc:mysql://localhost:3306/" + DatabaseName;
	static String user="root";
	static String pass="Nishchala123";
	
	
	public void initialize() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  connect=DriverManager.getConnection(url,user,pass);
		  username.setFocusTraversable(false);

	}
	
	@FXML 
	ImageView i3= new ImageView();
	
	public void screenDestroy1(Event e)
	{
		Stage primstage = (Stage) i3.getScene().getWindow();
		primstage.close();
	}
	
	
	public void login(ActionEvent e) throws IOException, SQLException
	{	Choice c1 = new Choice();
		AD ad1 = new AD();
		WD wd1 = new WD();
		SD sd1 = new SD();
		AI ai1 = new AI();
		String s1 = "";
		String s2 = "";
		s1 = username.getText();
		s2 = password.getText();
		
		if(s1.equals("")||s2.equals(""))
		{
			Alert alerts=new Alert(AlertType.WARNING);
		    alerts.setTitle("Warning Dialog");
		    alerts.setHeaderText(null);
		    alerts.setContentText("Kindly enter all the fields!");
		    alerts.showAndWait();
		    return;
		}
		
		
			
		String sql="Select * from table1 where Username =? and Password =?";
		PreparedStatement q1= connect.prepareStatement(sql);
		q1.setString(1,s1);
		q1.setString(2,s2);
		final ResultSet result = q1.executeQuery();
		if (result.next() == false) {
		   System.out.println("Incorrect credentials");
		   Alert alerts=new Alert(AlertType.WARNING);
		   alerts.setTitle("Warning Dialog");
		   alerts.setHeaderText(null);
		   alerts.setContentText("Incorrect Credentials!");
		   alerts.showAndWait();
		   return;
		}
		else
		{
		
		System.out.println("User logged in");
		Alert alerts=new Alert(AlertType.INFORMATION);
        alerts.setTitle("Information Dialog");
        alerts.setHeaderText(null);
        alerts.setContentText("User Logged In Successfully!");
        alerts.showAndWait();
        
       
        Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		//primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.show();
		
		Stage primstage = (Stage) login2.getScene().getWindow();
   		primstage.close();
   		c1.setStr(s1);
   		ad1.getuser(s1);
   		wd1.getuser(s1);
   		sd1.getuser(s1);
   		ai1.getuser(s1);
   		
   		
		}
		
	
	}

}
