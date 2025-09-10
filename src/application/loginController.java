package application;



import java.io.IOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class loginController {
    
	private Scene scene2;
	@FXML
	private TextField email;
	@FXML
	private PasswordField pass;
	@FXML
	private Label ERRUR;
	public void handleButtonAction(ActionEvent event) throws IOException {
	    String url = "jdbc:mysql://localhost:3306/example";

	    try {
	        application.Main.conect = DriverManager.getConnection(url, "root", "123456789");
	        application.Main.state = Main.conect.createStatement();
	        ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.user WHERE email='" + email.getText() + "' AND password='" + pass.getText() + "'");
	        
	        if (resultSet.next()) {
	            int result;
	            ResultSet resultSet1 = Main.state.executeQuery("SELECT id FROM example.user WHERE email='" + email.getText() + "' AND password='" + pass.getText() + "'");
	            if (resultSet1.next()) {
	                result = resultSet1.getInt("id");

	                FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceglobel.fxml"));
	                Parent root = loader.load();
	                globelcontroller controller = loader.getController();
	                controller.setUpdateValue(result);
	                Scene scene = new Scene(root);
	                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                stage.setScene(scene);
	            } else {
	                ERRUR.setText("Invalid email or password");
	            }
	        } else {
	            ERRUR.setText("Invalid email or password");
	        }
	    } catch (SQLException e) {
	        System.out.println(e);
	    }
	}

	public void btnlogin(ActionEvent event) {
	
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("singup.fxml"));
		        Parent root = loader.load();	        
		        Scene scene = new Scene(root);
		        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        stage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

