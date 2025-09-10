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

public class inseresubjectController {
	@FXML
	private TextField SubjectID;
	@FXML
	private TextField Titre;
	@FXML
	private TextField Max_capacity;
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
	public void confrmie (ActionEvent event) throws IOException {
		String nom=null,prenom=null;
		int niveau=0;
		 String query=null;
		 if(SubjectID.getText()!="")
			    nom = SubjectID.getText();
			    if(Max_capacity.getText()!="")
			    	niveau =  Integer.parseInt(Max_capacity.getText());	
			    if(Titre.getText()!="")	        
			     prenom = Titre.getText();
			    if(niveau==0) {
			    	query = "INSERT INTO example.subject (SubjectID, Title) VALUES ( ?, ?)";
			    	 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {				       
					        statement.setString(1, nom);      
					        statement.setString(2, prenom);				    		       
					        statement.executeUpdate();		        		     
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }}
			    else {
			    	query = "INSERT INTO example.subject (SubjectID, Title, Max_capacity) VALUES ( ?, ?, ?)";
			    	 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {				       
			    		 statement.setString(1, nom);      
					        statement.setString(2, prenom);				    
					        statement.setInt(3, niveau);		       
					        statement.executeUpdate();		        		     
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
			    }
		
		
		
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacesubject.fxml"));
	     Parent root = loader.load();	        
	     Scene scene = new Scene(root);
	     subjectcontroller controller = loader.getController();
		    controller.setUpdateValue(updateValue);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void setUpdateValue(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue = updateValue;
	}
         }
