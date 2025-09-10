package application;

import javafx.collections.ObservableList;

public class teacher {
    private int TeacherID;
    private String First_Name;
    private String Last_Name;
    private String Title;
    private String Subjects_Taught;
    private String Level;

    public teacher(int teacherID, String first_Name, String last_Name, String title, String subjects_Taught,
                   String level) {
        TeacherID = teacherID;
        First_Name = first_Name;
        Last_Name = last_Name;
        Title = title;
        Subjects_Taught = subjects_Taught;
        Level = level;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubjects_Taught() {
        return Subjects_Taught;
    }

    public void setSubjects_Taught(String subjects_Taught) {
        Subjects_Taught = subjects_Taught;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    
}
