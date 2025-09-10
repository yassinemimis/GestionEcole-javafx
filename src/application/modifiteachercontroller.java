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

public class modifiteachercontroller {
	@FXML
	private TextField TeacherID1;
	@FXML
	private TextField First_Name1;
	@FXML
	private TextField Last_Name1;
	@FXML
	private TextField Level1;
	@FXML
	private TextField Subject_Taught1;
	@FXML
	private TextField Title1;
	private int updateValue;
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceteacher.fxml"));
	     Parent root = loader.load();
	     teachercontroller controller = loader.getController();	     
			controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws SQLException, IOException  {
		int id = Integer.parseInt(TeacherID1.getText());
		ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.teacher where TeacherID="+id);
		String  email=null,phone=null,prenom=null,nom=null;
		String  age=null;	      
		while (resultSet.next()) {
              age =resultSet.getString("First_Name");		    
		       phone =resultSet.getString("Last_Name");
		       email =resultSet.getString("Level");
		       prenom =resultSet.getString("Subjects_Taught");
		       nom =resultSet.getString("Title");   
		  }
		    if(First_Name1.getText()!="")
		    	age = First_Name1.getText();	
		    if(Last_Name1.getText()!="")	        
		    	phone = Last_Name1.getText();
		    if(Level1.getText()!="")
		    	email = Level1.getText();
		    if(Title1.getText()!="")	        
		    	nom = Title1.getText();
		    if(Subject_Taught1.getText()!="")
		    	prenom = Subject_Taught1.getText();
		    String query1 = "UPDATE example.teacher SET First_Name='" + age + "', Last_Name='" + phone + "', Title='" + nom + "', Subjects_Taught='" + prenom + "', Level='" + email + "' WHERE TeacherID=" + id;
		    Main.state.executeUpdate(query1);
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceteacher.fxml"));
	     Parent root = loader.load();	
	     teachercontroller controller = loader.getController();	     
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
