package application;

import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class studentreqeutcontroller {
	@FXML
	private TextField scherche;
	@FXML
    private TableView<Student> Student;
    @FXML
    private TableColumn<Student, String> StudentId;
    @FXML
    private TableColumn<Student, String> First_Name;
    @FXML
    private TableColumn<Student, String> Last_Name;
    @FXML
    private TableColumn<Student, String> Year_Group;
    @FXML
    private TableColumn<Student, String> Date_Of_Brith;
    @FXML
    private TableColumn<Student, String> Student_Image;
    @FXML
    private TableColumn<Student, String> School_Team;
    public ObservableList<Student> data= FXCollections.observableArrayList();
    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Student student = null ;
	private int updateValue;
    public void initialize() {
        StudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        Year_Group.setCellValueFactory(new PropertyValueFactory<>("Year_Group"));
        Date_Of_Brith.setCellValueFactory(new PropertyValueFactory<>("Date_Of_Brith"));
        Student_Image.setCellValueFactory(new PropertyValueFactory<>("Student_Image"));
        School_Team.setCellValueFactory(new PropertyValueFactory<>("School_Team"));    
  }
    public void refreshTable() {
        try {
        	String id=scherche.getText();
        	String sqlQuery = "SELECT DISTINCT * " +
                    "FROM Student " +
                    "JOIN Student_Classes ON Student.StudentID = Student_Classes.StudentID " +
                    "JOIN Class ON Student_Classes.ClassID = Class.ClassID " +
                    "WHERE Class.ClassID = "+id;


            ResultSet resultSet = Main.state.executeQuery(sqlQuery);

            data.clear();

            while (resultSet.next()) {
            	 int StudentId = resultSet.getInt("StudentId");
            	String First_Name = resultSet.getString("First_Name");
                String Last_Name = resultSet.getString("Last_Name");           
                int Year_Group = resultSet.getInt("Year_Group");
                Date Date_Of_Brith = resultSet.getDate("Date_Of_Brith");
                String Student_Image = resultSet.getString("Student_Image");
                String School_Team = resultSet.getString("School_Team");
               

                data.add(new Student(StudentId, First_Name, Last_Name, Year_Group,Date_Of_Brith,Student_Image,School_Team));
            }

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Student.setItems(data);
    }
    public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("dachpordstudent.fxml"));
	     Parent root = loader.load();
	     dashbordcontrroler controller = loader.getController();
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
