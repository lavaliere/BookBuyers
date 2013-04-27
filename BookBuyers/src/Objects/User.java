package Objects;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import utils.DBManager;

public class User {
	/* Class Variables */
	private String username = "";
	private String password = "";
	private int ID;
	
	/* Constructors */
	public User(){
		
	}
	
	public User(String user, String pass){
		this.username = user;
		this.password = pass;
	}
	
	public User(String user, String pass, int num){
		this.username = user;
		this.password = pass;
		this.ID = num;
	}
	
	/* Getters*/
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public int getID() {
		return ID;
	}
	
	/*Setters*/
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	/* Login method */
	public boolean isValid(){
		DBManager db = new DBManager();
		java.sql.Connection conn = db.connect(getUsername(), getPassword());
		
		try {
			if(conn.isClosed()){
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	/*Add User Method */
		//add new User to DB 
	
	/* Delete User Method */
		//delete User from DB whose UserID = the argument
	
}
