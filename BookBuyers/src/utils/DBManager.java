package utils;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.*;
import javax.sql.*;

 
public class DBManager {
	public static boolean connected = false;
	String dataSource = "java:comp/env/jdbc/bookbuyers";
	Connection res = null;
	
	public Connection connect(){
		try {
			Context initialContext = new InitialContext();
			//If can't get context
			if(initialContext != null){
				DataSource ds = (DataSource)initialContext.lookup(dataSource);
				if(ds != null){
					res = ds.getConnection();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
		}
		return res;
	}
	
	
	public Connection connect(String user, String pass){
		Statement st = null;
		ResultSet rs = null;
		boolean valid = false;
		System.out.println("[DBManager] Attempting to log in: " + user + " and " + pass);
		try {
			Context initialContext = new InitialContext();
			//If can't get context
			if(initialContext != null){
				DataSource ds = (DataSource)initialContext.lookup(dataSource);
				if(ds != null){
					res = ds.getConnection();
					st = res.createStatement();
					String query = "SELECT Username, Password FROM login ORDER BY Username;";
			        rs = st.executeQuery(query);
					while(rs.next()){
						String db_name = rs.getString("Username");
		            	String db_pass = rs.getString("Password");
		            	//compare user's attempted login info with stored login info
		            	if(db_name.equalsIgnoreCase(user)){
		            		if(db_pass.equals(pass)){
		            			valid = true;
		            			break;
		            		}
		            	}
					}
					
				}
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        	if(valid){
        		System.out.println("Connection is valid. Returning...");

	        	//close Statement, return connection
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connected = true;
        	}else{
        		System.out.println("Connection is not valid. Closing...");
        		//close all and return null
				connected = false;
				try {
					st.close();
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch(NullPointerException e){
					e.printStackTrace();
				}
        	}
        }//finally
		
		
		return res;
	}


}