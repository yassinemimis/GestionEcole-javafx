package application;

import java.io.IOException;
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

public class tablereqeutcontroller {
	@FXML
	private TextField StudentID;
	@FXML
	private TextField scherche;
	
    @FXML
    private TableView<teacher> teacher;
    @FXML
    private TableColumn<teacher, Integer> TeacherID;
    @FXML
    private TableColumn<teacher, String> First_Name;
    @FXML
    private TableColumn<teacher, String> Last_Name;
    @FXML
    private TableColumn<teacher, String> Title;
    @FXML
    private TableColumn<teacher, String> Subjects_Taught;
    @FXML
    private TableColumn<teacher, String> Level;

    private ObservableList<teacher> data = FXCollections.observableArrayList();
	private int updateValue;

    @FXML
    public void initialize() {
        TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
        First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        Subjects_Taught.setCellValueFactory(new PropertyValueFactory<>("Subjects_Taught"));
        Level.setCellValueFactory(new PropertyValueFactory<>("Level"));
    }

    public void reqeut1(ActionEvent event) {
        try {
        	String id= StudentID.getText();
            // Créer la requête SQL
            String sqlQuery = "SELECT Teacher.TeacherID, Teacher.First_Name, Teacher.Last_Name,Teacher.Title,Teacher.Subjects_Taught,Teacher.Level " +
                    "FROM Teacher " +
                    "JOIN Class ON Teacher.TeacherID = Class.TeacherID " +
                    "JOIN Student_Classes ON Class.ClassID = Student_Classes.ClassID " +
                    "WHERE Student_Classes.StudentID = "+id;

            ResultSet resultSet = Main.state.executeQuery(sqlQuery);

            data.clear();
            while (resultSet.next()) {
               
                	int TeacherID = resultSet.getInt("TeacherID");
                	String First_Name = resultSet.getString("First_Name");
                    String Last_Name = resultSet.getString("Last_Name");
                    String Title = resultSet.getString("Title");
                    String Subjects_Taught = resultSet.getString("Subjects_Taught");
                    String Level = resultSet.getString("Level");
                    data.add(new teacher(TeacherID, First_Name, Last_Name, Title,Subjects_Taught,Level));
                }

                resultSet.close();
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        teacher.setItems(data);
    }
    public void reqeut2(ActionEvent event) {
        try {
        	String id=scherche.getText();
            // Créer la requête SQL
        	String sqlQuery = "SELECT DISTINCT * " +
                    "FROM Teacher " +
                    "JOIN Class ON Teacher.TeacherID = Class.TeacherID " +
                    "JOIN Subject ON Class.SubjectID = Subject.SubjectID " +
                    "WHERE Subject.SubjectID = "+id;


            ResultSet resultSet = Main.state.executeQuery(sqlQuery);

            data.clear();
            while (resultSet.next()) {
               
                	int TeacherID = resultSet.getInt("TeacherID");
                	String First_Name = resultSet.getString("First_Name");
                    String Last_Name = resultSet.getString("Last_Name");
                    String Title = resultSet.getString("Title");
                    String Subjects_Taught = resultSet.getString("Subjects_Taught");
                    String Level = resultSet.getString("Level");
                    data.add(new teacher(TeacherID, First_Name, Last_Name, Title,Subjects_Taught,Level));
                }

                resultSet.close();
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        teacher.setItems(data);
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
