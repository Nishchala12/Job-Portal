package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Choice {
	@FXML
	Button ad, wd, sd, ml;
	
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
	

}
