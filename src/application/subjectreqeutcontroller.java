package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class subjectreqeutcontroller {
	@FXML
	private TextField scherche;
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
    public void initialize() {
    	  ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
          Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
          Room_Type.setCellValueFactory(new PropertyValueFactory<>("Room_Type"));
          Facilities.setCellValueFactory(new PropertyValueFactory<>("Facilities")); 
  }

    public void refreshTable() {
        try {
        	String sqlQuery = "SELECT * " +
                    "FROM Classroom " +
                    "JOIN Class ON Classroom.ClassroomID = Class.ClassroomID " +
                    "JOIN Subject ON Class.SubjectID = Subject.SubjectID"+
                    "WHERE Subject.SubjectID = 4";

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
	
}

