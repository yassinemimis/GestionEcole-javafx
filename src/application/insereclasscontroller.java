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

public class insereclasscontroller {
	@FXML
	private TextField ClassID;
	@FXML
	private TextField Time;
	@FXML
	private TextField Period;
	@FXML
	private TextField TeacherID;
	@FXML
	private TextField SubjectID;
	@FXML
	private TextField ClassroomID;
	private int updateValue;

	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclass.fxml"));
	     Parent root = loader.load();
	     classcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws IOException {
		String classid=null,time=null,period=null,teacherid=null,subjectid=null,classroomid=null;
		     if(ClassID.getText()!="")
		     classid = ClassID.getText();
		     if(Time.getText()!="")
		     time = Time.getText();
		     if(Period.getText()!="")
		     period = Period.getText();
		     if(TeacherID.getText()!="")
		     teacherid = TeacherID.getText();
		     if(SubjectID.getText()!="")
		     subjectid = SubjectID.getText();
		     if(ClassroomID.getText()!="")
		     classroomid = ClassroomID.getText();		    
		    String query = "INSERT INTO example.class (ClassID, ClassroomID, SubjectID, TeacherID, Time, Period) VALUES (?, ?, ?, ?, ?, ?)";
		    try (PreparedStatement statement = Main.conect.prepareStatement(query)) {
		        statement.setString(1, classid);
		        statement.setString(2, classroomid);
		        statement.setString(3, subjectid);
		        statement.setString(4, teacherid);
		        statement.setString(5, time);
		        statement.setString(6, period);
		        statement.executeUpdate();   
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceclass.fxml"));
			 Parent root = loader.load();
			 classcontroller controller = loader.getController();
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

