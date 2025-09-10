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

public class classroomcontroller implements Initializable {
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
	private int updateValue;
	public void refreshTable() {
        try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.classroom");
      
            while (resultSet.next()){
            	data.add(new  classroom(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4)));
            	classroom.setItems(data);
                
            }     
            ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
            Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
            Room_Type.setCellValueFactory(new PropertyValueFactory<>("Room_Type"));
            Facilities.setCellValueFactory(new PropertyValueFactory<>("Facilities"));    
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
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("modfieclassroom.fxml"));
	    Parent root = loader.load();
	    modieficlassroomcontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}
	public void supprimi (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimiclassroom.fxml"));
	   Parent root = loader.load();	
	   supprimiclassroomcontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void insere (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("insereclassroom.fxml"));
	   Parent root = loader.load();	
	   insereclassroomcontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void sherche(ActionEvent event) throws SQLException {
		try {
			data.clear();
			String sherche =scherche.getText();		
			resultSet = Main.state.executeQuery("SELECT * FROM example.classroom WHERE ClassroomID LIKE '%" + sherche + "%' OR Capacity LIKE '%" + sherche + "%' OR Room_Type LIKE '%" + sherche + "%' OR Facilities LIKE '%" + sherche + "%'");
			 while (resultSet.next()){
	            	data.add(new  classroom(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4)));
	            	classroom.setItems(data);
	                
	            }     
	            ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
	            Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
	            Room_Type.setCellValueFactory(new PropertyValueFactory<>("Room_Type"));
	            Facilities.setCellValueFactory(new PropertyValueFactory<>("Facilities"));    
	            }
	   	     catch (SQLException ex) {
	            System.out.print(ex);
	        }
	}
	public void desc(ActionEvent event) throws SQLException {
		 try {
	        	data.clear();        
	            resultSet = Main.state.executeQuery("SELECT * FROM example.classroom ORDER BY ClassroomID DESC");
	      
	            while (resultSet.next()){
	            	data.add(new  classroom(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4)));
	            	classroom.setItems(data);
	                
	            }     
	            ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
	            Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
	            Room_Type.setCellValueFactory(new PropertyValueFactory<>("Room_Type"));
	            Facilities.setCellValueFactory(new PropertyValueFactory<>("Facilities"));    
	            }
	   	     catch (SQLException ex) {
	            System.out.print(ex);
	        }
	}
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
