package application;

import java.sql.Date;

import javafx.collections.ObservableList;

public class Student {
    public Student(int i, String string, Date date, int j, Date date2, String string2, String string3) {
		super();
		// TODO Auto-generated constructor stub
	}
   
	private int  StudentId;
    private String First_Name;
    private String Last_Name;
    private int Year_Group;
    private Date Date_Of_Brith;
    private String Student_Image;
    private String School_Team;

    public Student(int id, String nom, String date,int string,Date email,String phone,String specialite) {
       super();
       StudentId = id;
       First_Name = nom;
       Last_Name = date;
       Year_Group= string;
       Date_Of_Brith= email;
       Student_Image= phone;
       School_Team= specialite;
     }
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public int getYear_Group() {
		return Year_Group;
	}
	public void setYear_Group(int year_Group) {
		Year_Group = year_Group;
	}
	public Date getDate_Of_Brith() {
		return Date_Of_Brith;
	}
	public void setDate_Of_Brith(Date date_Of_Brith) {
		Date_Of_Brith = date_Of_Brith;
	}
	public String getStudent_Image() {
		return Student_Image;
	}
	public void setStudent_Image(String student_Image) {
		Student_Image = student_Image;
	}
	public String getSchool_Team() {
		return School_Team;
	}
	public void setSchool_Team(String school_Team) {
		School_Team = school_Team;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public static void setItems(ObservableList<classroom> data) {
		// TODO Auto-generated method stub
		
	}
 
    
}
