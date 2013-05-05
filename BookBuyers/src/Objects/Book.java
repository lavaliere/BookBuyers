package Objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DBManager;

public class Book {
	/* Class Variables */
	private int id = 0;
	private String product = "";
	private int quantity = 0;
	private double price = 0.0;

	/* Constructors */
	public Book(){
		
	}
	
	public Book(String product){
		this.product = product;
	}

	public Book(int id, String product, int quantity, double price){
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;		
	}
	
	/* Getters*/
	public int getId() {
		return id;
	}
	
	public String getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	
	/*Setters*/
	public void setId(int id) {
		this.id = id;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*Add Book Method */
		//add new book to DB 
	
	/* Delete Book Method */
		//delete book from DB whose BookID = the argument
	
	/* Book Search Methods */	
	
	//return HTML table of book objects that match the argument	
	public StringBuffer searchBook(String searchTerms){
		DBManager db = new DBManager();
		StringBuffer sbBody = new StringBuffer();
		Connection conn = null;
		PreparedStatement psSearch = null;
		ResultSet lRes = null;
		String sSearch = "SELECT product, image, isbn, author, price, quantity FROM inventory WHERE product LIKE '%" + searchTerms +
				"%' OR isbn LIKE '%" + searchTerms + "%' OR author LIKE '%" + searchTerms + "%' ORDER BY PRODUCT";
		boolean isEmpty = true;
		sbBody.append("<table>");
		
		if(searchTerms.isEmpty() || searchTerms.equalsIgnoreCase("Search by Book Title, Author, or ISBN")){
			sSearch = "SELECT * FROM inventory ORDER BY product";
		}
		
		try{
			conn = db.connect();
			psSearch = conn.prepareStatement(sSearch);
			lRes = psSearch.executeQuery();
			sbBody.append("<thead>");
			sbBody.append("<th>Product Image</th>");
			sbBody.append("<th>Book Title</th>");
			sbBody.append("<th>Author</th>");
			sbBody.append("<th>ISBN</th>");
			sbBody.append("<th>Quantity</th>");
			sbBody.append("<th>Price</th>");
			sbBody.append("</thead>");

			while(lRes.next()){
				sbBody.append("<tr>");
					sbBody.append("<td>");
						sbBody.append("<img src=\"Images/"); sbBody.append(lRes.getString("image")); sbBody.append("\" class=\"preview\">");
					sbBody.append("</td>");
					sbBody.append("<td>");
						sbBody.append(lRes.getString("product"));
					sbBody.append("</td>");
					sbBody.append("<td>");
						sbBody.append(lRes.getString("author"));
					sbBody.append("</td>");
					sbBody.append("<td>");
						sbBody.append(lRes.getString("isbn"));
					sbBody.append("</td>");
					sbBody.append("<td>");
						sbBody.append(lRes.getInt("quantity"));
					sbBody.append("</td>");
					sbBody.append("<td>");
						sbBody.append(lRes.getDouble("price"));
					sbBody.append("</td>");

				sbBody.append("</tr>");
				isEmpty = false;
			}//while		
			
			if(isEmpty){
				sbBody.append("<tr>"); sbBody.append("<td>");
				sbBody.append("No results found!");
				sbBody.append("</td>"); sbBody.append("</tr>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			sbBody.append("<tr><td>");
				sbBody.append("System Error: ");
			sbBody.append("</td></tr>");
			sbBody.append("<tr><td>");
				sbBody.append(e.getMessage());
			sbBody.append("</td></tr>");
			sbBody.append("<tr><td>");
				sbBody.append("\nPlease contact your system administrator.");
			sbBody.append("</td></tr>");
		}finally{
			db.closeAllConn(psSearch, conn);
		}
		
		sbBody.append("</table>");
		sbBody.append("</div>");
		
		return sbBody;
	}
	
	/* Buy Book Method */
		//will decrease number of on-hand books
	
	/* Sell Book Method */
		//will increase on-hand number of books
}
