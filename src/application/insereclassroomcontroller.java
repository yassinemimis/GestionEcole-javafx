package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

public class insereclassroomcontroller {
	@FXML
	private TextField ClassroomID;
	@FXML
	private TextField Capaciy;
	@FXML
	private TextField Room_Type;
	@FXML
	private TextField Facilities;
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
	public void confrmie (ActionEvent event) throws IOException {
		String nom=null,email=null,specialite=null;
		  int niveau=0;
		 String query=null;
		    if(ClassroomID.getText()!="")
		    nom = ClassroomID.getText();
		    if(Capaciy.getText()!="")
		    	niveau =  Integer.parseInt(Capaciy.getText());	
		    if(Room_Type.getText()!="")	        
		     email = Room_Type.getText();
		    if(Facilities.getText()!="")
		    specialite = Facilities.getText();
		    if(niveau==0) {
		    	query = "INSERT INTO example.classroom (ClassroomID, Room_Type, Facilities) VALUES ( ?, ?, ?)";
		    	 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {				       
				        statement.setString(1, nom);      
				        statement.setString(3, email);				    
				        statement.setString(4, specialite);		       
				        statement.executeUpdate();		        		     
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }}
		    else {
		    	query = "INSERT INTO example.classroom (ClassroomID, Capacity, Room_Type, Facilities) VALUES ( ?, ?, ?, ?)";
		    	 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {				       
				        statement.setString(1, nom);
				        statement.setInt(2, niveau);	       
				        statement.setString(3, email);				    
				        statement.setString(4, specialite);		       
				        statement.executeUpdate();		        		     
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
		    }
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

