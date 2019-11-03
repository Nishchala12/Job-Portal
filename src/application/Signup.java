package application;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Signup 
{
	@FXML
	Button con;
	@FXML
	ImageView i2 = new ImageView();
	@FXML
	TextField name = new TextField();
	@FXML
	TextField prof = new TextField();
	@FXML
	TextField username = new TextField();
	@FXML
	PasswordField password = new PasswordField();
	@FXML
	TextField resume = new TextField();
	
	
	static Connection connect=null;
	static String DatabaseName="student";
	static String url = "jdbc:mysql://localhost:3306/" + DatabaseName;
	static String user="root";
	static String pass="Nishchala123";
	
	public void initialize() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  connect=DriverManager.getConnection(url,user,pass);

		
	}
	
	public void screenDestroy(Event e)
	{
		Stage primstage = (Stage) i2.getScene().getWindow();
		primstage.close();
	}
	
	  public void open1(ActionEvent e) throws IOException, SQLException
		{
		  
		  String s1 = "";
		  String s2 = "";
		  String nam = "";
		  String profession = "";
		  String r="";
		  s1 = username.getText();
		  s2 = password.getText();
		  nam = name.getText();
		  profession = prof.getText();
		  r = resume.getText();
		  
		  
		  if(s1.equals("")||s2.equals("")||nam.equals("")||profession.equals("")||r.equals(""))
		  {
			  Alert alerts=new Alert(AlertType.WARNING);
		      alerts.setTitle("Warning Dialog");
		      alerts.setHeaderText(null);
		      alerts.setContentText("Kindly enter all the fields!");
		      alerts.showAndWait();
		      return;
		  }
		  
		  String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                "[a-zA-Z0-9_+&*-]+)*@" + 
	                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                "A-Z]{2,7}$"; 

			                  
				Pattern pat = Pattern.compile(emailRegex); 
				if (!pat.matcher(s1).matches()) 
				{
					Alert alerts=new Alert(AlertType.WARNING);
					   alerts.setTitle("Warning Dialog");
					   alerts.setHeaderText(null);
					   alerts.setContentText("Invalid E-Mail Format!");
					   alerts.showAndWait();
					   return;

				}
				else
				{
				}
		  
		  if(s2.length()<8)
		  {
			  Alert alerts=new Alert(AlertType.WARNING);
		      alerts.setTitle("Warning Dialog");
		      alerts.setHeaderText(null);
		      alerts.setContentText("Password must be at least 8 characters long!");
		      alerts.showAndWait();
		      return;  
		  }
		  String sq2 = "select * from Table1 where Username=?";
		  PreparedStatement p0 = connect.prepareStatement(sq2);
		  p0.setString(1,s1);
		  final ResultSet result1 = p0.executeQuery();
		  if (result1.next() == true)
		  {
			  Alert alerts=new Alert(AlertType.WARNING);
		      alerts.setTitle("Warning Dialog");
		      alerts.setHeaderText(null);
		      alerts.setContentText("Credentials already exist!");
		      alerts.showAndWait();
		      return;


		  }
		  else {

		  String sql="Insert into Table1(Username, Password, Name, Profession, Resume)" +"values(?,?,?,?,?)";
		  PreparedStatement q1= connect.prepareStatement(sql);
		  q1.setString(1,s1);
		  q1.setString(2,s2);
		  q1.setString(3, nam);
		  q1.setString(4, profession);
		 /*File f = new File(r);
		 FileInputStream fis = new FileInputStream(f);
		 q1.setBinaryStream(5, fis, (int)(f.length()));*/
		  try
		  {
		 File pdfFile = new File(r);
		 byte[] pdfData = new byte[(int) pdfFile.length()];
		 DataInputStream dis = new DataInputStream(new FileInputStream(pdfFile));
		 dis.readFully(pdfData);  // read from file into byte[] array
		 dis.close();
		 q1.setBytes(5, pdfData);
		  }
		  catch(IOException e44)
		  {
			  Alert alerts=new Alert(AlertType.WARNING);
		      alerts.setTitle("Warning Dialog");
		      alerts.setHeaderText(null);
		      alerts.setContentText("File not found!");
		      alerts.showAndWait();
		      return;
		  }
	
			 int Status=q1.executeUpdate();
			 
			 Alert alerts=new Alert(AlertType.INFORMATION);
		      alerts.setTitle("Information Dialog");
		      alerts.setHeaderText(null);
		      alerts.setContentText("User signed in successfully!");
		      alerts.showAndWait();

	        Stage primstage = (Stage) con.getScene().getWindow();
	   		primstage.close();
		  
		}

}
}
