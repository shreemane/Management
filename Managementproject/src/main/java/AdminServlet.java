

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserDao userDao;
	 public void init() {
	      userDao = new UserDao();
	    }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	/**
	 * @param pageidpageid 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                	showNewForm(request, response);
                    break;
                case "/insert":
                    insertTeacher(request, response);
                    break;
                case "/delete":
                   // deleteUser(request, response);
                    break;
                case "/edit":
                    //showEditForm(request, response);
                    break;
                case "/update":
                   // updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (ServletException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
          
        
        
       

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
		String spageid=request.getParameter("page");  
        int pageid=Integer.parseInt(spageid);  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=pageid-1;  
            pageid=pageid*total+1;  
        }  
        
        List<Teacher> list=UserDao.getRecords(pageid,total);  
      
        
        out.print("<h1>Page No: "+spageid+"</h1>");  
        out.print("<table border='1' cellpadding='4' width='60%'>");  
        out.print("<tr><th>Id</th><th>USername</th><th>Password</th><th>Subject</th><th>Standerd</th><th>TeacherId</th>");  
        for(Teacher e:list){  
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getUsername()+"</td><td>"+e.getPassword()+"</td><td>"+e.getSubject()+"</td><td>"+e.getStd()+"</td><td>"+e.getTeacherID()+"</td></tr>");  
        }  
        out.print("</table>");
        request.getRequestDispatcher("AdminHome.jsp").include(request, response);
        
        out.close();
		
	}

	public void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
		// TODO Auto-generated method stu	
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String subject = request.getParameter("subject");
        int std = Integer.parseInt(request.getParameter("std"));
       
        int teacherId = Integer.parseInt(request.getParameter("teacherID"));
		
        Teacher newTeacher = new Teacher(username, password, subject, std, teacherId);
        userDao.InsertTeacher(newTeacher);
        
        response.sendRedirect("Home.jsp");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher-form.jsp");
	        dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
