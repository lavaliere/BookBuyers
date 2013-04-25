package Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceBroker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, String> hmServices = new HashMap<String, String>(){{
		hmServices.put("00","BuyBack"); //BuyBack
		hmServices.put("01","Checkout"); //Checkout
		hmServices.put("02","Login"); //Login
		hmServices.put("03","Search"); //Search.java
		hmServices.put("04", "ReportExport"); //ReportExport
		hmServices.put("05", "PricePull"); //ReportExport
		hmServices.put("06", "UserDel"); //User Delete
		
	}};
       
    public ServiceBroker() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String service = request.getParameter("Service");
		
		if(hmServices.containsKey(service)){
			response.sendRedirect("/" + hmServices.get(service));
		}else{
			response.sendError(0);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
