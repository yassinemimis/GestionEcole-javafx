package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class modiefistudentclassescontroller {
	@FXML
	private TextField ClassID;
	@FXML
	private TextField StudentID;
	@FXML
	private TextField ClassID1;
	@FXML
	private TextField StudentID1;
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
		int id = Integer.parseInt(ClassID.getText());
		int nom=Integer.parseInt(StudentID.getText());
		int id1 = Integer.parseInt(ClassID1.getText());
		int nom1=Integer.parseInt(StudentID1.getText());
			    
	   String query1 = "update example.student_classes set ClassID='"+id1+"',StudentID='"+nom1+"'where ClassID ="+id+" and StudentID ="+nom;
		    Main.state.executeUpdate(query1);
		
		
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
