package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceBroker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, String> hmServices = new HashMap<String, String>();
       
    public ServiceBroker() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hmServices.put("00","BuyBack"); //BuyBack
		hmServices.put("01","Checkout"); //Checkout
		hmServices.put("02","Login"); //Login
		hmServices.put("03","Search"); //Search.java
		hmServices.put("04", "ReportExport"); //ReportExport
		hmServices.put("05", "PricePull"); //ReportExport
		hmServices.put("06", "UserDel"); //User Delete
		
		String service = request.getParameter("Service");
		System.out.println("Service called: " + service);
		
		if(hmServices.containsKey(service)){
			response.sendRedirect("/" + hmServices.get(service));
			System.out.println("Service found. Redirecting to: /" + service);
			return;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.println("<h1> Error: Servlet not found!</h1>");
			out.println("Please go back to the home page.");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hmServices.put("00","BuyBack"); //BuyBack
		hmServices.put("01","Checkout"); //Checkout
		hmServices.put("02","Login"); //Login
		hmServices.put("03","Search"); //Search.java
		hmServices.put("04", "ReportExport"); //ReportExport
		hmServices.put("05", "PricePull"); //ReportExport
		hmServices.put("06", "UserDel"); //User Delete
		
		String service = request.getParameter("Service");
		System.out.println("Service called: " + service);
		
		if(hmServices.containsKey(service)){
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/" + hmServices.get(service));
		    dispatcher.forward(request, response);
			return;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.println("<h1> Error: Servlet not found!</h1>");
			out.println("Please go back to the home page.");
			return;
		}
	}

}
