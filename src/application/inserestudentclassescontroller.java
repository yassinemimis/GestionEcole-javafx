package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class inserestudentclassescontroller {
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
	public void confrmie (ActionEvent event) throws IOException {
		String classid=null,time=null;
		if(ClassID.getText()!="")
		     classid = ClassID.getText();
	    if(StudentID.getText()!="")
		     time = StudentID.getText();
	    String query = "INSERT INTO example.student_classes (ClassID, StudentID) VALUES (?, ?)";
	    try (PreparedStatement statement = Main.conect.prepareStatement(query)) {
	        statement.setString(1, classid);
	        statement.setString(2, time);
	        statement.executeUpdate();   
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
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
