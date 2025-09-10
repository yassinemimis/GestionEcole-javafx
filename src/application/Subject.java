package application;

public class Subject {
	private int  SubjectID;
    private String Title;
    private int Max_Capacity;
	public Subject(int subjectID, String title, int max_Capacity) {
		super();
		setSubjectID(subjectID);
		setTitle(title);
		setMax_Capacity(max_Capacity);
	}
	public int getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getMax_Capacity() {
		return Max_Capacity;
	}
	public void setMax_Capacity(int max_Capacity) {
		Max_Capacity = max_Capacity;
	}
	
}
