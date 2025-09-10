package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class supprimiclasscontroller {
	@FXML
	private TextField ClassID;
	private int updateValue;
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclass.fxml"));
	     Parent root = loader.load();	
	     classcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws IOException, SQLException {
		String id = ClassID.getText();
	    String query = "DELETE FROM example.class WHERE ClassID = " + id;
	    Main.state.executeUpdate(query);
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclass.fxml"));
	     Parent root = loader.load();
	     classcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void setUpdateValue(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue = updateValue;
	}
}
