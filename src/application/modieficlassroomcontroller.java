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

public class modieficlassroomcontroller {
	@FXML
	private TextField ClassroomID1;
	@FXML
	private TextField Capaciy1;
	@FXML
	private TextField Room_Type1;
	@FXML
	private TextField Facilities1;
	private int updateValue;
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclassroom.fxml"));
	     Parent root = loader.load();
	     classroomcontroller controller = loader.getController();
		    controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws IOException, SQLException {
		int id = Integer.parseInt(ClassroomID1.getText());
		ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.classroom where ClassroomID="+id);
		String  email=null,phone=null;
		String  age=null;	      
		while (resultSet.next()) {
              age =resultSet.getString("Capacity");		    
		       phone =resultSet.getString("Room_Type");
		       email =resultSet.getString("Facilities");   				    		 
		  }
		    if(Capaciy1.getText()!="")
		    	age = Capaciy1.getText();	
		    if(Room_Type1.getText()!="")	        
		    	phone = Room_Type1.getText();
		    if(Facilities1.getText()!="")
		    	email = Facilities1.getText();		
		    String query1 = "update example.classroom set Capacity='"+age+"',Room_Type='"+phone+"',Facilities='"+email+"'where ClassroomID ="+id;
		    Main.state.executeUpdate(query1);
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclassroom.fxml"));
	     Parent root = loader.load();
	     classroomcontroller controller = loader.getController();
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
