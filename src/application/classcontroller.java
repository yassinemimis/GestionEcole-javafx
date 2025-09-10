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

public class classcontroller implements Initializable {
	@FXML
	private TextField scherche;
	@FXML
    private TableView<classe> Class;
    @FXML
    private TableColumn<classe, String> ClassID;
    @FXML
    private TableColumn<classe, String> ClassroomID;
    @FXML
    private TableColumn<classe, String> SubjectID;
    @FXML
    private TableColumn<classe, String> TeacherID;
    @FXML
    private TableColumn<classe, String> Period;
    @FXML
    private TableColumn<classe, String> Time;
    public ObservableList<classe> data= FXCollections.observableArrayList();
    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
	private int updateValue;
    public void refreshTable() {
        try {
        	data.clear();        
            resultSet = Main.state.executeQuery("SELECT * FROM example.class");      
            while (resultSet.next()){
            	data.add(new  classe(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
            	Class.setItems(data);               
            }            
            ClassID.setCellValueFactory(new PropertyValueFactory<>("ClassID"));
            ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
            SubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
            TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
            Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
            Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
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
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("modiefclass.fxml"));
    Parent root = loader.load();
    modiefclasscontroller controller = loader.getController();
    controller.setUpdateValue(updateValue);
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
}
public void supprimi (ActionEvent event) throws IOException {
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimiclass.fxml"));
   Parent root = loader.load();	
   supprimiclasscontroller controller = loader.getController();
   controller.setUpdateValue(updateValue);
   Scene scene = new Scene(root);
   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   stage.setScene(scene);
}
public void insere (ActionEvent event) throws IOException {
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("insereclass.fxml"));
   Parent root = loader.load();
   insereclasscontroller controller = loader.getController();
   controller.setUpdateValue(updateValue);
   Scene scene = new Scene(root);
   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   stage.setScene(scene);
}
public void sherche(ActionEvent event) throws SQLException {
	try {
		data.clear();
		String sherche =scherche.getText();		
		resultSet = Main.state.executeQuery("SELECT * FROM example.class WHERE ClassID LIKE '%" + sherche + "%' OR ClassroomID LIKE '%" + sherche + "%' OR SubjectID LIKE '%" + sherche + "%' OR TeacherID LIKE '%" + sherche + "%' OR Period LIKE '%" + sherche + "%' OR Time LIKE '%" + sherche + "%'");
		 while (resultSet.next()){
         	data.add(new  classe(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
         	Class.setItems(data);               
         }            
         ClassID.setCellValueFactory(new PropertyValueFactory<>("ClassID"));
         ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
         SubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
         TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
         Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
         Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
         }
	     catch (SQLException ex) {
         System.out.print(ex);
     }
}
public void desc(ActionEvent event) throws SQLException {
	 try {
     	data.clear();        
         resultSet = Main.state.executeQuery("SELECT * FROM example.class ORDER BY ClassID DESC");      
         while (resultSet.next()){
         	data.add(new  classe(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
         	Class.setItems(data);               
         }            
         ClassID.setCellValueFactory(new PropertyValueFactory<>("ClassID"));
         ClassroomID.setCellValueFactory(new PropertyValueFactory<>("ClassroomID"));
         SubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
         TeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
         Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
         Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
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
}}
