import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

public class UserDao {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/StudentteacherData","root","root");
			if(con!=null) {
			System.out.println("Database connected");
			} 
		}
		catch(Exception ex){ 
			System.out.println(ex);
			ex.printStackTrace();
			}  
	}
	 public static List<Teacher> getRecords(int start,int total){  
	        List<Teacher> list=new ArrayList<Teacher>();  
	        try{  
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        
	            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/StudentteacherData","root","root");  
	            PreparedStatement ps=con.prepareStatement("select * from TeacherData limit "+(start-1)+","+total);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Teacher e=new Teacher(total, null, null, null, start, total);
	                		
	                e.setId(rs.getInt(1));  
	                e.setUsername(rs.getString(2));  
	                e.setPassword(rs.getString(3));
	                e.setSubject(rs.getString(4)); 
	                e.setStd(rs.getInt(5));
	                e.setTeacherID(rs.getInt(6));
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){System.out.println(e);}  
	        return list;  
}
	public void InsertTeacher(Teacher teacher) throws ClassNotFoundException, ServletException{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		      
	         Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/StudentteacherData","root","root"); 
	         PreparedStatement ps =con.prepareStatement("insert into TeacherData(Username, Password, Subject, Std, TeacherID) VALUES (?, ?, ?, ?, ?);");
	         ps.setString(1, teacher.getUsername());
	         ps.setString(2, teacher.getPassword());
	         ps.setString(3, teacher.getSubject());
	         ps.setInt(4, teacher.getStd());
	         ps.setInt(5, teacher.getTeacherID());
	         
	         System.out.println(ps);

	         ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			 throw new ServletException(e);
		
		}
		
	}
}
