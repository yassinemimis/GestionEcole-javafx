package application;

public class student_classes {
	public student_classes(int classID, int studentID) {
		super();
		ClassID = classID;
		StudentID = studentID;
	}
	private int  ClassID;
	private int  StudentID;
	public int getClassID() {
		return ClassID;
	}
	public void setClassID(int classID) {
		ClassID = classID;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
}
