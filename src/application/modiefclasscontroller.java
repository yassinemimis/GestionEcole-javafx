package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

public class modiefclasscontroller {
	@FXML
	private TextField ClassID;
	@FXML
	private TextField Time;
	@FXML
	private TextField Period;
	@FXML
	private TextField TeacherID;
	@FXML
	private TextField SubjectID;
	@FXML
	private TextField ClassroomID;
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
		int id = Integer.parseInt(ClassID.getText());
		ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.class where ClassID="+id);
		String  prenom = null,email=null,phone=null,niveau=null,nom=null;
		 String query=null;
	      while (resultSet.next()) {

              prenom = resultSet.getString("ClassroomID");
              nom =resultSet.getString("SubjectID");
  		      email =resultSet.getString("TeacherID");
  		       phone =resultSet.getString("Time");
  		     niveau =resultSet.getString("Period");   		
  		   	 
  		  }	    
		    if(ClassroomID.getText()!="")
		    	prenom = ClassroomID.getText();
		    if(SubjectID.getText()!="")
		    	nom = SubjectID.getText();	
		    if(TeacherID.getText()!="")	        
		    	email = TeacherID.getText();
		    if(Time.getText()!="")
		    	phone = Time.getText();
		    if((Period.getText())!=(""))
		    	niveau = Period.getText();		    
		    String query1 = "update example.class set ClassroomID='"+prenom+"',SubjectID='"+nom+"',TeacherID='"+email+"',Time='"+phone+"',Period='"+niveau+"'where ClassID ="+id;
		    Main.state.executeUpdate(query1);
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
