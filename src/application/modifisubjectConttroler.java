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

public class modifisubjectConttroler {
	@FXML
	private TextField SubjectID1;
	@FXML
	private TextField Title1;
	@FXML
	private TextField Max_capacity1;
	private int updateValue;
	public void back (ActionEvent event) throws IOException {

	
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacesubject.fxml"));
	     Parent root = loader.load();
	     subjectcontroller controller = loader.getController();
		    controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws IOException, SQLException {
		
		
		int id = Integer.parseInt(SubjectID1.getText());
		ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.subject where SubjectID="+id);
		String  email=null,phone=null;
		String  age=null;	      
		while (resultSet.next()) {
              age =resultSet.getString("Max_capacity");		    
		       phone =resultSet.getString("Title");				    		 
		  }
		if(Max_capacity1.getText()!="")
	    	age = Max_capacity1.getText();	
	    if(Title1.getText()!="")	        
	    	phone = Title1.getText();
	    String query1 = "update example.subject set Title='"+phone+"',Max_capacity='"+age+"'where SubjectID ="+id;
	    Main.state.executeUpdate(query1);
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacesubject.fxml"));
	     Parent root = loader.load();
	     subjectcontroller controller = loader.getController();
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
