package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class adduserconteoller {
	private int updateValue;
	public void yes (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("singup.fxml"));
	   Parent root = loader.load();	        
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	 public void back(ActionEvent event) throws IOException {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceglobel.fxml"));
	        Parent root = loader.load();
	        globelcontroller controller = loader.getController();
	        controller.setUpdateValue(updateValue);
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
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("edituser.fxml"));
	   Parent root = loader.load();	
	   edituserconteoller controller = loader.getController();
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
	public void setUpdateValue1(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue=updateValue;
	}
	
}
