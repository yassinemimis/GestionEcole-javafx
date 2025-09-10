package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class globelcontroller {
	studentcontroller a=new studentcontroller();
	private int updateValue;
public void back (ActionEvent event) throws IOException {
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
   Parent root = loader.load();	        
   Scene scene = new Scene(root);
   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   stage.setScene(scene);
}
public void btnclass(ActionEvent event) throws IOException {
	 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclass.fxml"));
    Parent root = loader.load();	
    classcontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void btnclassroom(ActionEvent event) throws IOException {
	 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclassroom.fxml"));
    Parent root = loader.load();
    classroomcontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void btnstudent(ActionEvent event) throws IOException, SQLException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacestudent.fxml"));
    Parent root = loader.load();
    studentcontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void btnteacher(ActionEvent event) throws IOException {
	 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceteacher.fxml"));
    Parent root = loader.load();
    teachercontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void btnsubject(ActionEvent event) throws IOException {
	 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceSubject.fxml"));
    Parent root = loader.load();	
    subjectcontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void btnclassstudent_classes(ActionEvent event) throws IOException {
	 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacestudent_classes.fxml"));
    Parent root = loader.load();
    student_classescontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);

    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void Settings(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
    Parent root = loader.load();
    usercontroller controller = loader.getController();
    controller.setUpdateValue1(updateValue);
    controller.test();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}




public void initialize(ActionEvent event) throws IOException {
	 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("dachpordstudent.fxml"));
    Parent root = loader.load();
    dashbordcontrroler controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void setUpdateValue(int result) {
	// TODO Auto-generated method stub
	this.updateValue = result;
}



}
