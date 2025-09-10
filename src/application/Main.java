package application;
	


import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
 

public class Main<Parent, Button> extends Application {
	public static Connection conect;
	public static Statement state ;
	public static Connection connection;
	@Override
	public void start(Stage primaryStage) {
		try {
		    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene((javafx.scene.Parent) root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    Image icon = new Image(getClass().getResourceAsStream("Subject.jpg"));
		    primaryStage.getIcons().add(icon);		    
			primaryStage.setTitle("App School");						 
		        // Paramétrage de la scène et affichage de la fenêtre
		        primaryStage.setScene(scene);
		        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	  
	           
	    
	public static void main(String[] args) {
		launch(args);
	}
}