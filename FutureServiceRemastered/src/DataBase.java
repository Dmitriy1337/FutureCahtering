import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataBase {

	// JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://127.0.0.1:3306/usersdatatable";
    private static final String user = "root";
    private static final String password = "12345";

    // JDBC variables for opening and managing connection
    private  Connection con;
    private  Statement stmt;
    private  ResultSet rs;
    private  Statement stmt2;
    private  ResultSet rs2;
    
    String select = "select userLogin from userdata";
    String selectPass = "select userPassword from userdata";
	 String insert = "INSERT INTO usersdatatable.userdata (idUserData, userLogin, userPassword) \n" +
            " VALUES (1, 'login', '12345');";
	 String clear = " DELETE FROM userdata";
	public static void main(String args[]){
		new DataBase();
	}
	public boolean isMatch(String login,String pass){

		
		 try {
	            
	            con =  (Connection) DriverManager.getConnection(url, user, password);
	            stmt = (Statement) con.createStatement();
	           // stmt.executeUpdate(insert);
	            rs = stmt.executeQuery(select);

	            while (rs.next()) {
	            	
	            	String count = rs.getString(1);
	                if(login.equals(count)){
	                	 stmt2 = (Statement) con.createStatement();
	      	             rs2 = stmt2.executeQuery(selectPass);
	      	          if(rs2.next()){
	      	        	System.out.println(rs2.getString(rs.getRow()) );
	      	        	if(rs2.getString(rs.getRow()).equals(pass)){
	      	        		return true;
	      	        	}
	      	          }
	      	             
	               
	                }
	              
	                System.out.println("Total number of books in the table : " + count);
	                return false;
	            }

	        } catch (SQLException sqlEx) {
	            sqlEx.printStackTrace();
	        } finally {
	            //close connection ,stmt and resultset here
	            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
	            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
	            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
	        }
		return false;
	    
	}
	
	public DataBase(){
		//System.out.println(isMatch("login","12345"));
	}
		
		
	
	
	
	
}
