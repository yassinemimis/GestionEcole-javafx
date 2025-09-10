package application;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class ImageLoader {
	    public static byte[] loadImageData(int studentId) throws SQLException {
	        byte[] imageData = null;
	        String sql = "SELECT Student_image FROM Student WHERE StudentID = ?";
	        try (
	        		PreparedStatement statement = Main.conect.prepareStatement(sql)) {
	        	statement.setInt(1, studentId);
	            try (ResultSet rs = statement.executeQuery()) {
	                if (rs.next()) {
	                    imageData = rs.getBytes("Student_image");
	                }
	            }
	        }
	        return imageData;
	    }
	}


