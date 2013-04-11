package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBManager;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String user = request.getParameter("username");
		  String pass = request.getParameter("password");
		  
		  System.out.println("Connecting with username = " + user + " and password = " + pass);
		  DBManager db = new DBManager();
		  
		  try{
			  db.connect(user, pass);

			  //this is where the User object's login method goes
				  if(user.equalsIgnoreCase("admin")){
					  response.sendRedirect("Admin.jsp");
				  }else{
					  //fix this
					  response.sendRedirect("User.jsp");
				  }
				  	
		  }catch(Exception e){
			  System.out.println("Connection failed...");
			  
		  }
	}

}
