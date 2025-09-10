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

public class supprimistudentclassescontroller {
	@FXML
	private TextField ClassID;
	@FXML
	private TextField StudentID;
	private int updateValue;
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacestudent_classes.fxml"));
	     Parent root = loader.load();	
	     student_classescontroller controller = loader.getController();
		    controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws IOException, SQLException {
		String id = ClassID.getText();
		String nom=StudentID.getText();
	    String query = "DELETE FROM example.student_classes WHERE ClassID = " + id+" AND StudentID ="+nom;
	    Main.state.executeUpdate(query);
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacestudent_classes.fxml"));
	     Parent root = loader.load();	
	     student_classescontroller controller = loader.getController();
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
