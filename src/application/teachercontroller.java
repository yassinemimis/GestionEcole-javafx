package application;

import java.io.IOException;
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

public class teachercontroller implements Initializable {
	@FXML
	private TextField scherche;
	@FXML
    private TableView<teacher> teacher;
    @FXML
    private TableColumn<teacher, String> TeacherID;
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
    public ObservableList<teacher> data= FXCollections.observableArrayList();
    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    teacher student = null ;
	private int updateValue;
    @FXML
    public void refreshTable() {
        try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.teacher");      
            while (resultSet.next()){
            	data.add(new  teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
            	teacher.setItems(data);               
            }            
            TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
            First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
            Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Subjects_Taught.setCellValueFactory(new PropertyValueFactory<>("Subjects_Taught"));
            Level.setCellValueFactory(new PropertyValueFactory<>("Level"));              
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
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("modiefteacher.fxml"));
	    Parent root = loader.load();	
	    modifiteachercontroller controller = loader.getController();	     
		controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}
	public void supprimi (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimiteacher.fxml"));
	   Parent root = loader.load();	
	   supprimiteachercontroller controller = loader.getController();	     
		controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void insere (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("insereteacher.fxml"));
	   Parent root = loader.load();	
	   insereteachercontroller controller = loader.getController();	     
		controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void sherche(ActionEvent event) throws SQLException {
		try {
			data.clear();
			String sherche =scherche.getText();
			
			resultSet = Main.state.executeQuery("SELECT * FROM example.teacher WHERE TeacherID LIKE '%" + sherche + "%' OR First_Name LIKE '%" + sherche + "%' OR Last_Name LIKE '%" + sherche + "%' OR Title LIKE '%" + sherche + "%' OR Subjects_Taught LIKE '%" + sherche + "%' OR Level LIKE '%" + sherche + "%'");
			 while (resultSet.next()){
	            	data.add(new  teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
	            	teacher.setItems(data);               
	            }            
	            TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
	            First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
	            Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
	            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
	            Subjects_Taught.setCellValueFactory(new PropertyValueFactory<>("Subjects_Taught"));
	            Level.setCellValueFactory(new PropertyValueFactory<>("Level"));              
	            }
	     catch (SQLException ex) {
         System.out.print(ex);
     }
	}
	public void desc(ActionEvent event) throws SQLException {
		try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.teacher ORDER BY TeacherID DESC");      
            while (resultSet.next()){
            	data.add(new  teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
            	teacher.setItems(data);               
            }            
            TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
            First_Name.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
            Last_Name.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Subjects_Taught.setCellValueFactory(new PropertyValueFactory<>("Subjects_Taught"));
            Level.setCellValueFactory(new PropertyValueFactory<>("Level"));              
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
