
public class Teacher {

	public int Id;
	public String Username;
	public String Password;
	public String Subject;
	public int Std;
	public int TeacherID;
	
	
	public Teacher(String username, String password, String subject, int std, int teacherID) {
		super();
		Username = username;
		Password = password;
		Subject = subject;
		Std = std;
		TeacherID = teacherID;
	}
	public Teacher(int id, String username, String password, String subject, int std, int teacherID) {
		super();
		Id = id;
		Username = username;
		Password = password;
		Subject = subject;
		Std = std;
		TeacherID = teacherID;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {	
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public int getStd() {
		return Std;
	}
	public void setStd(int std) {
		Std = std;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
}
