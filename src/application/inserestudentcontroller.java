package application;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
public class inserestudentcontroller {
	@FXML
	private TextField StudentId;
	@FXML
	private TextField First_Name;
	@FXML
	private TextField Last_Name;
	@FXML
	private TextField School_Team;
	@FXML
	private TextField Student_Image;
	@FXML
	private TextField Date_Of_Brith;
	@FXML
	private TextField Year_Group;
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
	@SuppressWarnings({ "null", "unused" })
	public void confrmie (ActionEvent event) throws IOException {
		String nom=null,prenom=null,email=null,specialite=null;
		int niveau=0;
		File imageFile=null;
		 byte[] imageBytes=null; 
		 String query=null;
		 if(imageFile!=null) {
		 imageFile = new File(selectedFile.getAbsolutePath());
		 imageBytes = Files.readAllBytes(imageFile.toPath());}
		    int id = Integer.parseInt(StudentId.getText());
		    System.out.println(id);
		    if(First_Name.getText()!="")
		    nom = First_Name.getText();
		    if(Last_Name.getText()!="")
		    prenom = Last_Name.getText();	
		    if(School_Team.getText()!="")	        
		     email = School_Team.getText();
		    if(Date_Of_Brith.getText()!="")
		    specialite = Date_Of_Brith.getText();
		    if((Year_Group.getText())!=(""))
		    niveau = Integer.parseInt(Year_Group.getText());
		    if(niveau==0) {
		    	query = "INSERT INTO example.student (StudentID, First_Name, Last_Name, date_of_birth, Student_image, School_Team) VALUES ( ?, ?, ?, ?, ?, ?)";
		    	 try (PreparedStatement statement = Main.conect.prepareStatement(query)) {
				        statement.setInt(1, id);
				        statement.setString(2, nom);
				        statement.setString(3, prenom);	       
				        statement.setString(6, email);
				        statement.setBytes(5, imageBytes);
				        statement.setString(4, specialite);		       
				        statement.executeUpdate();		        		     
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }}
		    else { query = "INSERT INTO example.student (StudentID, First_Name, Last_Name, Year_Group, date_of_birth, Student_image, School_Team) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    try (PreparedStatement statement = Main.conect.prepareStatement(query)) {
		        statement.setInt(1, id);
		        statement.setString(2, nom);
		        statement.setString(3, prenom);	       
		        statement.setString(7, email);
		        statement.setBytes(6, imageBytes);
		        statement.setString(5, specialite);		       
		        statement.setInt(4, niveau);
		        statement.executeUpdate();		        		     
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }}
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
