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

public class subjectcontroller implements Initializable {
	@FXML
	private TextField scherche;
	@FXML
    private TableView<Subject> Subject;
    @FXML
    private TableColumn<Subject, String> SubjectID;
    @FXML
    private TableColumn<Subject, String> Title;
    @FXML
    private TableColumn<Subject, String> Max_Capacity;
    public ObservableList<Subject> data= FXCollections.observableArrayList();
    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
	private int updateValue;
    public void refreshTable() {
        try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.subject");      
            while (resultSet.next()){
            	data.add(new  Subject(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
            	Subject.setItems(data);               
            }            
            SubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Max_Capacity.setCellValueFactory(new PropertyValueFactory<>("Max_Capacity"));            
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
	public void modifie(ActionEvent event) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("modiefsubject.fxml"));
	    Parent root = loader.load();
	    modifisubjectConttroler controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}

	public void supprimi(ActionEvent event) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimisubject.fxml"));
	    Parent root = loader.load();
	    supprimisubjectController controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}

	public void insere(ActionEvent event) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("inseresubject.fxml"));
	    Parent root = loader.load();
	    inseresubjectController controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}
	public void sherche(ActionEvent event) throws SQLException {
		try {
			data.clear();
			String sherche =scherche.getText();		
			resultSet = Main.state.executeQuery("SELECT * FROM example.subject WHERE SubjectID LIKE '%" + sherche + "%' OR Title LIKE '%" + sherche + "%' OR Max_Capacity LIKE '%" + sherche + "%'");
			  while (resultSet.next()){
	            	data.add(new  Subject(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
	            	Subject.setItems(data);               
	            }            
	            SubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
	            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
	            Max_Capacity.setCellValueFactory(new PropertyValueFactory<>("Max_Capacity"));            
	            }
	   	     catch (SQLException ex) {
	            System.out.print(ex);
	        }
	}
	public void desc(ActionEvent event) throws SQLException {
		 
		try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.subject ORDER BY SubjectID DESC");      
            while (resultSet.next()){
            	data.add(new  Subject(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
            	Subject.setItems(data);               
            }            
            SubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Max_Capacity.setCellValueFactory(new PropertyValueFactory<>("Max_Capacity"));            
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
