package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class studentcontroller implements Initializable {
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
    @FXML
    public void refreshTable() {
        try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.student");
      
            while (resultSet.next()){
            	data.add(new  Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7)));
            	Student.setItems(data);
                
            }
            
            StudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
            First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
            Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
            Year_Group.setCellValueFactory(new PropertyValueFactory<>("Year_Group"));
            Date_Of_Brith.setCellValueFactory(new PropertyValueFactory<>("Date_Of_Brith"));
            Student_Image.setCellValueFactory(new PropertyValueFactory<>("Student_Image"));
            School_Team.setCellValueFactory(new PropertyValueFactory<>("School_Team"));    
            }
   	     catch (SQLException ex) {
            System.out.print(ex);
        }}
 
    public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceglobel.fxml"));
	     Parent root = loader.load();
	     globelcontroller controller = loader.getController();	     
		controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
   
	public void modifie (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("modiefstudent.fxml"));
	    Parent root = loader.load();
	    modifiestudentcontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}
	public void supprimi (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimistudent.fxml"));
	   Parent root = loader.load();	  
	   supprimistydentcontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void insere (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("inserestudent.fxml"));
	   Parent root = loader.load();	
	   inserestudentcontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void sherche(ActionEvent event) throws SQLException {
		try {
			data.clear();
			String sherche =scherche.getText();
			resultSet = Main.state.executeQuery("SELECT * FROM example.student WHERE StudentID LIKE '%" + sherche + "%' OR First_Name LIKE '%" + sherche + "%' OR Last_Name LIKE '%" + sherche + "%' OR Year_Group LIKE '%" + sherche + "%' OR date_of_birth LIKE '%" + sherche + "%' OR Student_Image LIKE '%" + sherche + "%' OR School_Team LIKE '%" + sherche + "%'");
		 while (resultSet.next()){
         	data.add(new  Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7)));
         	Student.setItems(data);
             
         }
         StudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
         First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
         Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
         Year_Group.setCellValueFactory(new PropertyValueFactory<>("Year_Group"));
         Date_Of_Brith.setCellValueFactory(new PropertyValueFactory<>("Date_Of_Brith"));
         Student_Image.setCellValueFactory(new PropertyValueFactory<>("Student_Image"));
         School_Team.setCellValueFactory(new PropertyValueFactory<>("School_Team"));    
         }
	     catch (SQLException ex) {
         System.out.print(ex);
     }
	}
	public void desc(ActionEvent event) throws SQLException {
		 
		try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.student ORDER BY StudentID DESC");
      
            while (resultSet.next()){
            	data.add(new  Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7)));
            	Student.setItems(data);
                
            }
            
            StudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
            First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
            Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
            Year_Group.setCellValueFactory(new PropertyValueFactory<>("Year_Group"));
            Date_Of_Brith.setCellValueFactory(new PropertyValueFactory<>("Date_Of_Brith"));
            Student_Image.setCellValueFactory(new PropertyValueFactory<>("Student_Image"));
            School_Team.setCellValueFactory(new PropertyValueFactory<>("School_Team"));    
            }
   	     catch (SQLException ex) {
            System.out.print(ex);
        }}

public void asc(ActionEvent event) {
	refreshTable();
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		refreshTable();
		
	}
	public void setUpdateValue(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue = updateValue;
	}
}
