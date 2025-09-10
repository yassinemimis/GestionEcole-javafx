package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class usercontroller implements Initializable {
    private int updateValue;
    @FXML
    private Label email;
    @FXML
    private Label phone;
    @FXML
    private Label nom;
    @FXML
    private Label pass;

    public void add(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adduser.fxml"));
        Parent root = loader.load();
        adduserconteoller controller = loader.getController();
        controller.setUpdateValue1(updateValue);
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

    public void change(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changeuser.fxml"));
        Parent root = loader.load();
        changeusercontroller controller = loader.getController();
        controller.setUpdateValue1(updateValue);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void edit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edituser.fxml"));
        Parent root = loader.load();
        edituserconteoller controller = loader.getController();
        controller.setUpdateValue1(updateValue);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void supprimi(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimiuser.fxml"));
        Parent root = loader.load();
        supprimiuserconteoller controller = loader.getController();
        controller.setUpdateValue1(updateValue);
        //controller.yes2(event);
        Scene scene = new Scene(root);

        // Retrieve the Stage instance from FXMLLoader
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }


    public void setUpdateValue1(int result) {
        this.updateValue = result;
    }
    public void test(){
    	
    	 try {
             ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.user where id=" + updateValue);
             while (resultSet.next()) {
                 String nom1 = resultSet.getString("nom");
                 System.out.println(updateValue);
                 nom.setText(nom1);
                 String  email1 =resultSet.getString("email");
                 email.setText(email1);
                 String   phone1 =resultSet.getString("phone");
                 phone.setText(phone1);
                 String pass1 =resultSet.getString("password"); 
                 pass.setText(pass1);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       test();
       System.out.println(updateValue);
}
}