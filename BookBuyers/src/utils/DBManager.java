package utils;
 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.corba.se.impl.util.Version;
 
public class DBManager {
	public static final String URL = "jdbc:mysql://216.22.34.233/Bookstore";
	public static final String user_name = "";
	public static final String user_password = "";
	public static boolean connected = false;

	public Connection connect(String url, String username, String password){
		Connection c = null;
		Statement st = null;
		ResultSet rs = null;
		com.mysql.jdbc.Driver d = null;
		Boolean valid = false;

        try {
        	d = new com.mysql.jdbc.Driver();
        	Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(URL, user_name, user_password);
            st = c.createStatement();
            String query = "SELECT username, password FROM login ORDER BY username;";
            rs = st.executeQuery(query);
            System.out.println("QUERY: " + query);
           
            while(rs.next()) {
            	String db_name = rs.getString("username");
            	String db_pass = rs.getString("password");
            	//compare user's attempted login info with stored login info
            	if(db_name.equalsIgnoreCase(username)){
            		if(db_pass.equals(password)){
            			valid = true;
            			break;
            		}
            	}
            }
        } catch (SQLException ex) {
        //	ex.printStackTrace();
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (ClassNotFoundException ex) {
        // 	ex.printStackTrace();
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
        	if(valid){
	        	//close Statement, return connection
				endSearch(st);
				connected = true;
        	}else{
        		//close all and return null
				connected = false;
				closeAllConn(st, c);
        	}
        }//finally
		return c;
    }
	
	public void logout(Connection userSession){
		try {
			if(!userSession.isClosed()){
				connected = false;
				userSession.close();
			}
		} catch (SQLException ex) {
	//		ex.printStackTrace();
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	public boolean validateConn(){
		return connected;
	}
	
	//@To DO: flesh this out.
	public boolean update(){
		return false;
	}
	
	//@To DO: flesh this out.
	public ResultSet query(){
		return null;
		
	}
	
	public void closeAllConn(java.sql.Statement st, Connection c){
         if (st != null) {
             try {
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
         }
         if(c != null){
        	 try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
         }

	}
	
	public void endSearch(java.sql.Statement st){
         if (st != null) {
             try {
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
         }
	}
}