package application;

public class classe {
	private int  ClassID;
	private int  ClassroomID;
	private int  SubjectID;
    private int TeacherID;
    private String Time;
    private String Period;
	public classe(int classID, int classroomID, int subjectID, int teacherID, String time, String period) {
		super();
		ClassID = classID;
		ClassroomID = classroomID;
		SubjectID = subjectID;
		TeacherID = teacherID;
		Time = time;
		Period = period;
	}

	public int getClassID() {
		return ClassID;
	}
	public void setClassID(int classID) {
		ClassID = classID;
	}
	public int getClassroomID() {
		return ClassroomID;
	}
	public void setClassroomID(int classroomID) {
		ClassroomID = classroomID;
	}
	public int getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getPeriod() {
		return Period;
	}
	public void setPeriod(String period) {
		Period = period;
	}
    
}
