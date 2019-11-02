package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Choice {
	@FXML
	Button ad, wd, sd, ml;
	
	static Connection connect=null;
	static String DatabaseName="student";
	static String url = "jdbc:mysql://localhost:3306/" + DatabaseName;
	static String user="root";
	static String pass="Nishchala123";
	static String u1;
	
	
	
	public void initialize() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  connect=DriverManager.getConnection(url,user,pass);

		
	}
	
	public void setStr(String s) throws SQLException {
		System.out.println(s);

		String sql="select * from table1 where Username =?";
		PreparedStatement q1= connect.prepareStatement(sql);
		q1.setString(1,s);
		final ResultSet result = q1.executeQuery();
		if(result.next())
		{String columnValue = result.getString(4).trim();
		u1=columnValue;
		System.out.println(u1);

		}

	}
	
	
	public void selectad(ActionEvent e1) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{	
		AD ad = new AD();
	
		ResultSet result1;
		String str=new String("Student");
		System.out.println("App Development Jobs");
		System.out.println(u1);

		 
		       if(u1.equals(str)){

		 String sq2 = "select * from internship where category='App Development'";
		 PreparedStatement p0 = connect.prepareStatement(sq2);
		 result1 = p0.executeQuery();  
		 System.out.println("2623t673");
		 
		 }
		 
		 else
		 { String sq1 = "select * from job where category='App Development'";
		 PreparedStatement p1 = connect.prepareStatement(sq1);
		 result1 = p1.executeQuery();
		 System.out.println("jkjdf");
		 }

		 String demo="";
		 int c=0, rc=0;
		 
		 ResultSetMetaData rsmd = result1.getMetaData();
		 int columnsNumber = rsmd.getColumnCount();
		 System.out.println(columnsNumber);
		 System.out.println(result1.getRow());
		 result1.last();
		 rc = result1.getRow();
		 result1.beforeFirst();
		 String a[] = new  String[rc];
		 while (result1.next()) {
		    /* for (int i = 1; i <= columnsNumber; i++) {
		         if (i > 1) System.out.print(",  ");
		         String columnValue = result1.getString(i);
		         System.out.println(rsmd.getColumnName(i) +": "+ columnValue );
		     }*/
		    	 demo="Job Description: "+result1.getString(2)+"\n Pay: "+result1.getString(3)+"/-\n Company Name: "+result1.getString(6)+"\n Location: "+result1.getString(7);
			     System.out.println(demo);
			     a[c] = demo;
			    
			     c++;    

		 }
		 
		
		System.out.println("\n\n"+Arrays.toString(a));

		ad.getInt(rc);
		ad.getStr(Arrays.toString(a));
		
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("AD.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	     
		
	}
	
	public void selectwd(ActionEvent e2) throws IOException, SQLException
	{
		WD wd = new WD();
		
		ResultSet result1;
		String str=new String("Student");
		System.out.println("Web Development Jobs");
		System.out.println(u1);

		 
		       if(u1.equals(str)){

		 String sq2 = "select * from internship where category='Web Development'";
		 PreparedStatement p0 = connect.prepareStatement(sq2);
		 result1 = p0.executeQuery();  
		 System.out.println("2623t673");
		 
		 }
		 
		 else
		 { String sq1 = "select * from job where category='Web Development'";
		 PreparedStatement p1 = connect.prepareStatement(sq1);
		 result1 = p1.executeQuery();
		 System.out.println("jkjdf");
		 }

		 String demo="";
		 int c=0, rc=0;
		 
		 ResultSetMetaData rsmd = result1.getMetaData();
		 int columnsNumber = rsmd.getColumnCount();
		 System.out.println(columnsNumber);
		 System.out.println(result1.getRow());
		 result1.last();
		 rc = result1.getRow();
		 result1.beforeFirst();
		 String a[] = new  String[rc];
		 while (result1.next()) {
		    /* for (int i = 1; i <= columnsNumber; i++) {
		         if (i > 1) System.out.print(",  ");
		         String columnValue = result1.getString(i);
		         System.out.println(rsmd.getColumnName(i) +": "+ columnValue );
		     }*/
		    	 demo="Job Description: "+result1.getString(2)+"\n Pay: "+result1.getString(3)+"/-\n Company Name: "+result1.getString(6)+"\n Location: "+result1.getString(7);
			     System.out.println(demo);
			     a[c] = demo;
			    
			     c++;    

		 }
		 
		
		System.out.println("\n\n"+Arrays.toString(a));

		wd.getInt(rc);
		wd.getStr(Arrays.toString(a));
		
		 
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("WD.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void selectsd(ActionEvent e3) throws IOException, SQLException
	{
		
		SD sd = new SD();
		
		ResultSet result1;
		String str=new String("Student");
		System.out.println("Software Development Jobs");
		System.out.println(u1);

		 
		       if(u1.equals(str)){

		 String sq2 = "select * from internship where category='Software Development'";
		 PreparedStatement p0 = connect.prepareStatement(sq2);
		 result1 = p0.executeQuery();  
		 System.out.println("2623t673");
		 
		 }
		 
		 else
		 { String sq1 = "select * from job where category='Software Development'";
		 PreparedStatement p1 = connect.prepareStatement(sq1);
		 result1 = p1.executeQuery();
		 System.out.println("jkjdf");
		 }

		 String demo="";
		 int c=0, rc=0;
		 
		 ResultSetMetaData rsmd = result1.getMetaData();
		 int columnsNumber = rsmd.getColumnCount();
		 System.out.println(columnsNumber);
		 System.out.println(result1.getRow());
		 result1.last();
		 rc = result1.getRow();
		 result1.beforeFirst();
		 String a[] = new  String[rc];
		 while (result1.next()) {
		    /* for (int i = 1; i <= columnsNumber; i++) {
		         if (i > 1) System.out.print(",  ");
		         String columnValue = result1.getString(i);
		         System.out.println(rsmd.getColumnName(i) +": "+ columnValue );
		     }*/
		    	 demo="Job Description: "+result1.getString(2)+"\n Pay: "+result1.getString(3)+"/-\n Company Name: "+result1.getString(6)+"\n Location: "+result1.getString(7);
			     System.out.println(demo);
			     a[c] = demo;
			    
			     c++;    

		 }
		 
		
		System.out.println("\n\n"+Arrays.toString(a));

		sd.getInt(rc);
		sd.getStr(Arrays.toString(a));
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("SD.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void selectai(ActionEvent e4) throws IOException, SQLException
	{
		
		AI ai = new AI();
		
		ResultSet result1;
		String str=new String("Student");
		System.out.println("Artificial Intelligence Jobs");
		System.out.println(u1);

		 
		       if(u1.equals(str)){

		 String sq2 = "select * from internship where category='Artificial Intelligence'";
		 PreparedStatement p0 = connect.prepareStatement(sq2);
		 result1 = p0.executeQuery();  
		 System.out.println("2623t673");
		 
		 }
		 
		 else
		 { String sq1 = "select * from job where category='Artificial Intelligence'";
		 PreparedStatement p1 = connect.prepareStatement(sq1);
		 result1 = p1.executeQuery();
		 System.out.println("jkjdf");
		 }

		 String demo="";
		 int c=0, rc=0;
		 
		 ResultSetMetaData rsmd = result1.getMetaData();
		 int columnsNumber = rsmd.getColumnCount();
		 System.out.println(columnsNumber);
		 System.out.println(result1.getRow());
		 result1.last();
		 rc = result1.getRow();
		 result1.beforeFirst();
		 String a[] = new  String[rc];
		 while (result1.next()) {
		    /* for (int i = 1; i <= columnsNumber; i++) {
		         if (i > 1) System.out.print(",  ");
		         String columnValue = result1.getString(i);
		         System.out.println(rsmd.getColumnName(i) +": "+ columnValue );
		     }*/
		    	 demo="Job Description: "+result1.getString(2)+"\n Pay: "+result1.getString(3)+"/-\n Company Name: "+result1.getString(6)+"\n Location: "+result1.getString(7);
			     System.out.println(demo);
			     a[c] = demo;
			    
			     c++;    

		 }
		 
		
		System.out.println("\n\n"+Arrays.toString(a));

		ai.getInt(rc);
		ai.getStr(Arrays.toString(a));
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("AI.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
	


