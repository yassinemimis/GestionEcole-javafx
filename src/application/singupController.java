package application;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class singupController {
	@FXML
	private TextField NAME;
	@FXML
	private PasswordField PASS;
	@FXML
	private TextField PHONE;
	@FXML
	private TextField EMAIL;
	@FXML
	private Label ERURR2;
	@FXML
	private Label ERURR211;
	@FXML
	private Label ERURR22;
	@FXML
	private Label ERURR21;
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
	   Parent root = loader.load();	        
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
public void	btnsingup(ActionEvent event) throws SQLException, IOException {
	 String url = "jdbc:mysql://" + "localhost" + ":"+ "3306" +"/" + "example";
	  application.Main.conect = DriverManager.getConnection(url, "root", "123456789");
      application.Main.state =  Main.conect.createStatement();
	if(NAME.getText()=="" || PHONE.getText()==""|| EMAIL.getText()==""|| PASS.getText()=="") {
		if(NAME.getText()=="") {
			ERURR2.setText("name vide");
		}
		else ERURR2.setText("");
		if(PHONE.getText()=="") {
			ERURR211.setText("PHONE vide");
		}else ERURR211.setText("");
		if(EMAIL.getText()=="") {
			ERURR22.setText("EMAIL vide");
		}else ERURR22.setText("");
		if(PASS.getText()=="") {
			ERURR21.setText("Password vide");
		}else ERURR21.setText("");
		
	}
	
	else{
		ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.user WHERE email='" + EMAIL.getText() + "' AND password='" + PASS.getText() + "' AND nom='"+NAME.getText()+"' AND phone='"+PHONE.getText()+ "'");
	
	if (resultSet.next()) { 
		ERURR21.setText("cette compte il existe déja");
 }
	else{
	String	query = "INSERT INTO example.user (nom, phone, email, password) VALUES ( ?, ?, ?, ?)";
		 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {
		        statement.setString(1, NAME.getText());
		        statement.setString(2, PHONE.getText());	       
		        statement.setString(3, EMAIL.getText());
		        statement.setString(4, PASS.getText());	       
		        statement.executeUpdate();		        		     
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmed.fxml"));
	        Parent root = loader.load();	        
	        Scene scene = new Scene(root);
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	   }}
}}
