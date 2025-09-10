package application;



import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class dashbordcontrroler implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
	private Label teacher;
    @FXML
	private Label students;
    @FXML
	private Label classes;
    @FXML
	private Label classroom;
    @FXML
	private Label subjects;
    ResultSet resultSet = null ;
	private int updateValue;
	 public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceglobel.fxml"));
	     Parent root = loader.load();
	     globelcontroller controller = loader.getController();	     
		controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
    public void find1 (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("tablereqeut.fxml"));
	     Parent root = loader.load();
	     tablereqeutcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
    public void find2 (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("classroomreqeut.fxml"));
	     Parent root = loader.load();
	     classroomreqeutcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
    public void find3 (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("classroomreqeut1.fxml"));
	     Parent root = loader.load();
	     classroomreqeutcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
    public void find4 (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("classroomreqeut2.fxml"));
	     Parent root = loader.load();
	     classroomreqeutcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
    public void find5 (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("studentreqeut.fxml"));
	     Parent root = loader.load();	
	     studentreqeutcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
    public void find6 (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherreqeut.fxml"));
	     Parent root = loader.load();	
	     tablereqeutcontroller controller = loader.getController();
	     controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
   
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	int date2003 = 0;
    	int date2002 = 0;
    	int date2001 = 0;
    	int reste=0;
    	try {
			resultSet=  Main.state.executeQuery("SELECT COUNT(*)AS table_count FROM example.class");
			if (resultSet.next()) {
                int tableCount = resultSet.getInt("table_count");
                classes.setText("nombre:" + tableCount);
            } else {
            	classes.setText("Erreurs");
            }
			resultSet=  Main.state.executeQuery("SELECT COUNT(*)AS table_count FROM example.teacher");
			if (resultSet.next()) {
                int tableCount = resultSet.getInt("table_count");
                teacher.setText("nombre:" + tableCount);
            } else {
            	teacher.setText("Erreurs");
            }
			resultSet=  Main.state.executeQuery("SELECT COUNT(*)AS table_count FROM example.student");
			if (resultSet.next()) {
                int tableCount = resultSet.getInt("table_count");
                students.setText("nombre:" + tableCount);
            } else {
            	classes.setText("Erreurs");
            }
			resultSet=  Main.state.executeQuery("SELECT COUNT(*)AS table_count FROM example.classroom");
			if (resultSet.next()) {
                int tableCount = resultSet.getInt("table_count");
                classroom.setText("nombre " + tableCount);
            } else {
            	classes.setText("Erreurs");
            }
			resultSet=  Main.state.executeQuery("SELECT COUNT(*)AS table_count FROM example.subject");
			if (resultSet.next()) {
                int tableCount = resultSet.getInt("table_count");
                subjects.setText("nombre:" + tableCount);
            } else {
            	classes.setText("Erreurs");
            }
		
    	
			resultSet = Main.state.executeQuery("SELECT COUNT(*) AS StudentCount "
			        + "FROM example.student "
			        + "WHERE date_of_birth > '2003-01-01' AND date_of_birth < '2003-12-31'");

		
			if (resultSet.next()) {
			    date2003 = resultSet.getInt("StudentCount");
			    
			}
			resultSet = Main.state.executeQuery("SELECT COUNT(*) AS StudentCount "
			        + "FROM example.student "
			        + "WHERE date_of_birth > '2002-01-01' AND date_of_birth < '2002-12-31'");

		
			if (resultSet.next()) {
			    date2002 = resultSet.getInt("StudentCount");
			    
			}
			resultSet = Main.state.executeQuery("SELECT COUNT(*) AS StudentCount "
			        + "FROM example.student "
			        + "WHERE date_of_birth > '2001-01-01' AND date_of_birth < '2001-12-31'");

		
			if (resultSet.next()) {
			    date2001 = resultSet.getInt("StudentCount");
			    
			}
			resultSet = Main.state.executeQuery("SELECT COUNT(*) AS StudentCount FROM example.student WHERE date_of_birth NOT BETWEEN '2001-01-01' AND '2003-12-31'");


		
			if (resultSet.next()) {
			    reste = resultSet.getInt("StudentCount");
			    
			}}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("22 ans", date2001),
                        new PieChart.Data("21 ans", date2002),
                        new PieChart.Data("20 ans", date2003),
                        new PieChart.Data("le reste", reste));


        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " pourcentage: ", data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll(pieChartData);
    }
    public void setUpdateValue(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue = updateValue;
	}
}