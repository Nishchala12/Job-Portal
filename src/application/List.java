package application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class List {
	@FXML
	VBox  vb = new VBox();
	DropShadow shadow = new DropShadow();
	
	static Connection connect=null;
	static String DatabaseName="student";
	static String url = "jdbc:mysql://localhost:3306/" + DatabaseName;
	static String user="root";
	static String pass="Nishchala123";
	
	
	public void initialize() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  connect=DriverManager.getConnection(url,user,pass);
		  String ar[] = {"rtyy","yyy","uuu","iii"};
		  for(int i=0;i<ar.length;i++)
		  {	
			  Label des= new Label();
			  Label a=new Label();
			  Button b = new Button("APPLY");
			  BorderPane t = new BorderPane();
			  des.setText("\r\n************************************************************************************************\r\n");
			  a.setText(ar[i]);
			  a.setStyle("-fx-font-weight: bold");
			  //a.setGraphic(b);
			  a.setAlignment(Pos.CENTER);
			  b.setAlignment(Pos.CENTER);
			  b.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 70; -fx-font-weight: bold; ");
			  b.setFocusTraversable(false);
			  //HBox hb = new HBox();
			 
			  b.addEventHandler(MouseEvent.MOUSE_ENTERED,
				        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				            b.setStyle("-fx-background-color: #ff8c00; -fx-background-radius: 70;-fx-font-weight: bold; ");
				          }
				        });

				    b.addEventHandler(MouseEvent.MOUSE_EXITED,
				        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				            b.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 70;-fx-font-weight: bold;");
				          }
				        });
			  b.addEventHandler(MouseEvent.MOUSE_CLICKED, 
					    new EventHandler<MouseEvent>() {
					        @Override 
					        public void handle(MouseEvent e) 
					        {
					        	
					        	Alert alert = new Alert(AlertType.CONFIRMATION);
					        	alert.setTitle("Confirmation Dialog");
					        	alert.setHeaderText(null);
					        	alert.setContentText("Confirm your action:");

					        	Optional<ButtonType> result = alert.showAndWait();
					        	if (result.get() == ButtonType.OK)
					        	{
					        		Alert alerts=new Alert(AlertType.INFORMATION);
						            alerts.setTitle("Information Dialog");
						            alerts.setHeaderText(null);
						            alerts.setContentText("You have applied for this particular job opportunity! Company officials will contact you at the earliest!");
						            alerts.showAndWait();
					        	   
					        	 
					        	
					        	String s=a.getText();
					        	System.out.println(s);
					        	}
					        	else {
					        	   return;
					        	}
					        	
					            
					        }});
			 
			  
			  t.setLeft(a);
			  t.setRight(b);
			  vb.getChildren().addAll(des,t);
			  
			  
			  
		  }
		  
		  
	}

	
	

}
