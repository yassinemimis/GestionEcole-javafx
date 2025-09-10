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

public class edituserconteoller {
	@FXML
	private TextField nom;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;
	@FXML
	private TextField pass;
	
		 private int updateValue;
		 public void back(ActionEvent event) throws IOException {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceglobel.fxml"));
		        Parent root = loader.load();
		        globelcontroller controller = loader.getController();
		        controller.setUpdateValue(updateValue);
		        Scene scene = new Scene(root);
		        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        stage.setScene(scene);
		    }
			public void user (ActionEvent event) throws IOException {
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
			   Parent root = loader.load();	   
			   usercontroller controller = loader.getController();
			    controller.setUpdateValue1(updateValue);
			    controller.test();
			   Scene scene = new Scene(root);
			   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			   stage.setScene(scene);
			}
	
	public void add (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("adduser.fxml"));
	   Parent root = loader.load();
	   adduserconteoller controller = loader.getController();
	    controller.setUpdateValue1(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	

	public void change (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("changeuser.fxml"));
	   Parent root = loader.load();	 
	   changeusercontroller controller = loader.getController();
	    controller.setUpdateValue1(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void edit (ActionEvent event) throws IOException {
		test();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
	   Parent root = loader.load();	 
	   usercontroller controller = loader.getController();
	    controller.setUpdateValue1(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void supprimi (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimiuser.fxml"));
	   Parent root = loader.load();	 
	   supprimiuserconteoller controller = loader.getController();
	    controller.setUpdateValue1(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void test(){
    	
   	 try { String nom1=null,email1=null,phone1=null,pass1=null;
            ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.user where id=" + updateValue);
            while (resultSet.next()) {
                 nom1 = resultSet.getString("nom");               
                 email1 =resultSet.getString("email");              
                 phone1 =resultSet.getString("phone");               
                 pass1 =resultSet.getString("password"); 
            }
            if(nom.getText()!="") {
        	    nom1 = nom.getText(); }      
              	if(email.getText()!="") {
              		email1 = email.getText();}      	 	 
                if(phone.getText()!="") {
                	phone1 = phone.getText(); }
                if(pass.getText()!="") {
                	pass1 = pass.getText(); }
                String query1 = "update example.user set nom='"+nom1+"',phone='"+phone1+"',email='"+email1+"',password='"+pass1+"' where id ="+updateValue;

                Main.state.executeUpdate(query1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public void setUpdateValue1(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue=updateValue;
	}
	
}
