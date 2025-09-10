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

public class student_classescontroller implements Initializable {
	@FXML
	private TextField scherche;
	@FXML
    private TableView<student_classes> student_classes;
    @FXML
    private TableColumn<student_classes, String> ClassID;
    @FXML
    private TableColumn<student_classes, String> StudentID;
    public ObservableList<student_classes> data= FXCollections.observableArrayList();
    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
	private int updateValue;
    public void refreshTable() {
        try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.student_classes");      
            while (resultSet.next()){
            	data.add(new  student_classes(resultSet.getInt(1),resultSet.getInt(2)));
            	student_classes.setItems(data);               
            }            
            ClassID.setCellValueFactory(new PropertyValueFactory<>("ClassID"));
            StudentID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
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
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("modiefistudent_classes.fxml"));
	    Parent root = loader.load();
	    modiefistudentclassescontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}
	public void supprimi (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimistudent_classes.fxml"));
	   Parent root = loader.load();
	   supprimistudentclassescontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void insere (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("inserestudent_classes.fxml"));
	   Parent root = loader.load();
	  inserestudentclassescontroller controller = loader.getController();
	    controller.setUpdateValue(updateValue);
	   Scene scene = new Scene(root);
	   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   stage.setScene(scene);
	}
	public void sherche(ActionEvent event) throws SQLException {
		try {
			data.clear();
			String sherche =scherche.getText();		
			resultSet = Main.state.executeQuery("SELECT * FROM example.student_classes WHERE ClassID LIKE '%" + sherche + "%' OR StudentID LIKE '%" + sherche + "%'");
			while (resultSet.next()){
            	data.add(new  student_classes(resultSet.getInt(1),resultSet.getInt(2)));
            	student_classes.setItems(data);               
            }            
            ClassID.setCellValueFactory(new PropertyValueFactory<>("ClassID"));
            StudentID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
            }
   	     catch (SQLException ex) {
            System.out.print(ex);
        }
	}
	public void desc(ActionEvent event) throws SQLException {
		 
			  try {
		        	data.clear();        
		            resultSet = Main.state.executeQuery("SELECT * FROM example.student_classes  ORDER BY ClassID  DESC");      
		            while (resultSet.next()){
		            	data.add(new  student_classes(resultSet.getInt(1),resultSet.getInt(2)));
		            	student_classes.setItems(data);               
		            }            
		            ClassID.setCellValueFactory(new PropertyValueFactory<>("ClassID"));
		            StudentID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
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
