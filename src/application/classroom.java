package application;

public class classroom {
	private int  ClassroomID;
    private String Facilities;
    private String Room_Type;
    private int Capacity;
	public classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public classroom(int classroomID, int capacity, String room_Type, String facilities) {
		super();
		ClassroomID=classroomID;
		Facilities=facilities;
		Room_Type=room_Type;
		Capacity=capacity;
	}
	public int getClassroomID() {
		return ClassroomID;
	}
	public void setClassroomID(int classroomID) {
		ClassroomID = classroomID;
	}
	public String getFacilities() {
		return Facilities;
	}
	public void setFacilities(String facilities) {
		Facilities = facilities;
	}
	public String getRoom_Type() {
		return Room_Type;
	}
	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	
}
