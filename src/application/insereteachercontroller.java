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

public class insereteachercontroller {
	@FXML
	private TextField TeacherID;
	@FXML
	private TextField First_Name;
	@FXML
	private TextField Last_Name;
	@FXML
	private TextField Level;
	@FXML
	private TextField Title;
	@FXML
	private TextField Subject_Taught;
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
	public void confrmie (ActionEvent event) throws IOException {
		String nom=null,prenom=null,email=null,specialite=null,niveau=null;
		int id = Integer.parseInt(TeacherID.getText());
		        if(First_Name.getText()!="")
			    nom = First_Name.getText();
			    if(Last_Name.getText()!="")
			    prenom = Last_Name.getText();	
			    if(Level.getText()!="")	        
			     email = Level.getText();
			    if(Title.getText()!="")
			    specialite = Title.getText();
			    if((Subject_Taught.getText())!=(""))
			    niveau =Subject_Taught.getText();
			    String query = "INSERT INTO example.teacher (TeacherID, First_Name, Last_Name, Title, Subjects_Taught, Level) VALUES ( ?, ?, ?, ?, ?, ?)";
		    	 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {
				        statement.setInt(1, id);
				        statement.setString(2, nom);
				        statement.setString(3, prenom);	       
				        statement.setString(4, specialite);
				        statement.setString(5, niveau);
				        statement.setString(6, email);		       
				        statement.executeUpdate();
				        } catch (SQLException e) {
					        e.printStackTrace();
					    }
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
