package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class modifiestudentcontroller {
	@FXML
	private TextField StudentId1;
	@FXML
	private TextField First_Name1;
	@FXML
	private TextField Last_Name1;
	@FXML
	private TextField School_Team1;
	@FXML
	private TextField Student_Image1;
	@FXML
	private TextField Date_Of_Brith1;
	@FXML
	private TextField Year_Group1;
	@FXML
    private Button selectButton;
	File selectedFile ;
	private int updateValue;
	public void back (ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacestudent.fxml"));
	     Parent root = loader.load();
	     studentcontroller controller = loader.getController();
		    controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void confrmie (ActionEvent event) throws IOException, SQLException {
		int id = Integer.parseInt(StudentId1.getText());
		System.out.print(id);
		ResultSet resultSet = Main.state.executeQuery("SELECT * FROM example.student where StudentID="+id);
		String  prenom = null,email=null,phone=null,niveau=null,groupe=null,nom=null;
		String  age=null;	      
		File imageFile=null;
		 byte[] imageBytes=null;
		 String query=null;
	      while (resultSet.next()) {

              prenom = resultSet.getString("First_Name");
             age =resultSet.getString("Last_Name");
  		      email =resultSet.getString("Year_Group");
  		       phone =resultSet.getString("date_of_birth");
  		     imageBytes =resultSet.getBytes("Student_image");   		
  		    niveau =resultSet.getString("School_Team");  		 
  		  }
		 if(selectedFile!=null) {
			 imageFile = new File(selectedFile.getAbsolutePath());
			 imageBytes = Files.readAllBytes(imageFile.toPath());}	    
		    if(First_Name1.getText()!="")
		    	prenom = First_Name1.getText();
		    if(Last_Name1.getText()!="")
		    	age = Last_Name1.getText();	
		    if(School_Team1.getText()!="")	        
		    	niveau = School_Team1.getText();
		    if(Date_Of_Brith1.getText()!="")
		    	phone = Date_Of_Brith1.getText();
		    if((Year_Group1.getText())!=(""))
		    	email = Year_Group1.getText();
		    String query1 = "update example.student set First_Name='"+prenom+"',Last_Name='"+age+"',Year_Group='"+email+"',date_of_birth='"+phone+"',Student_image='"+imageBytes+"',School_Team='"+niveau+"'where StudentID ="+id;
		    Main.state.executeUpdate(query1);
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("interfacestudent.fxml"));
	     Parent root = loader.load();	
	     studentcontroller controller = loader.getController();
		    controller.setUpdateValue(updateValue);
	     Scene scene = new Scene(root);
	     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     stage.setScene(scene);
	}
	public void selectFilem() {
		   FileChooser fileChooser = new FileChooser();

	       // Set the file extension filter
	       FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.jpg)", "*.jpg");
	       fileChooser.getExtensionFilters().add(extFilter);

	       // Show the file chooser dialog
	       fileChooser.setTitle("Select PDF File");
	       Stage stage = (Stage) selectButton.getScene().getWindow();
	        selectedFile = fileChooser.showOpenDialog(stage);

	       if (selectedFile != null) {
	           // Handle the selected file
	           // You can access the selected file using selectedFile.getAbsolutePath() or other methods
	           System.out.println("Selected file: " + selectedFile.getAbsolutePath());
	       }
	        }
	public void setUpdateValue(int updateValue) {
		// TODO Auto-generated method stub
		this.updateValue = updateValue;
	}
}
