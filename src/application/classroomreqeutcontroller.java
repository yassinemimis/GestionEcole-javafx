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

public class classroomreqeutcontroller {

	
	@FXML
	private TextField scherche;
	@FXML
	private TextField scherche2;
	@FXML
	private TextField scherche1;
	@FXML
    private TableView<classroom> classroom;
    @FXML
    private TableColumn<classroom, String> ClassroomID;
    @FXML
    private TableColumn<classroom, String> Capacity;
    @FXML
    private TableColumn<classroom, String> Room_Type;
    @FXML
    private TableColumn<classroom, String> Facilities;
    public ObservableList<classroom> data= FXCollections.observableArrayList();
    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    classroom student = null ;
	private int updateValue;
    public void initialize() {
    	  ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
          Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
          Room_Type.setCellValueFactory(new PropertyValueFactory<>("Room_Type"));
          Facilities.setCellValueFactory(new PropertyValueFactory<>("Facilities"));  
    }

    public void refreshTable() {
        try {
        	String id=scherche.getText();
            String sqlQuery = "SELECT Classroom.ClassroomID, Classroom.Capacity, Classroom.Room_Type, Classroom.Facilities " +
                              "FROM Classroom " +
                              "JOIN Class ON Classroom.ClassroomID = Class.ClassroomID " +
                              "JOIN Teacher ON Class.TeacherID = Teacher.TeacherID " +
                              "WHERE Teacher.TeacherID = "+id;

            ResultSet resultSet = Main.state.executeQuery(sqlQuery);

            data.clear();

            while (resultSet.next()) {
                int classroomID = resultSet.getInt("ClassroomID");
                int capacity = resultSet.getInt("Capacity");
                String roomType = resultSet.getString("Room_Type");
                String facilities = resultSet.getString("Facilities");

                data.add(new classroom(classroomID, capacity, roomType, facilities));
            }

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        classroom.setItems(data);
    }
    public void refreshTable1() {
        try {
        	String id=scherche1.getText();
        	String sqlQuery = "SELECT * " +
                    "FROM Classroom " +
                    "JOIN Class ON Classroom.ClassroomID = Class.ClassroomID " +
                    "JOIN Subject ON Class.SubjectID = Subject.SubjectID "+
                    "WHERE Subject.SubjectID = "+id;

            ResultSet resultSet = Main.state.executeQuery(sqlQuery);

            data.clear();


            while (resultSet.next()) {
                int classroomID = resultSet.getInt("ClassroomID");
                int capacity = resultSet.getInt("Capacity");
                String roomType = resultSet.getString("Room_Type");
                String facilities = resultSet.getString("Facilities");

                data.add(new classroom(classroomID, capacity, roomType, facilities));
            }

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        classroom.setItems(data);
    }
    public void refreshTable2() {
        try {
        	String id=scherche2.getText();
        	String sqlQuery = "SELECT DISTINCT * " +
                    "FROM Classroom " +
                    "JOIN Class ON Classroom.ClassroomID = Class.ClassroomID " +
                    "JOIN Student_Classes ON Class.ClassID = Student_Classes.ClassID " +
                    "WHERE Student_Classes.ClassID = "+id;



            ResultSet resultSet = Main.state.executeQuery(sqlQuery);

            data.clear();


            while (resultSet.next()) {           	
                int classroomID = resultSet.getInt("ClassroomID");
                int capacity = resultSet.getInt("Capacity");
                String roomType = resultSet.getString("Room_Type");
                String facilities = resultSet.getString("Facilities");

                data.add(new classroom(classroomID, capacity, roomType, facilities));
            }

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        classroom.setItems(data);
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
