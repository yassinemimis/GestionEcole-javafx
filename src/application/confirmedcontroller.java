package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class confirmedcontroller {
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
	   Parent root = loader.load();	        
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void go (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("singup.fxml"));
	   Parent root = loader.load();	        
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
}
