package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_LOAD=10;

	

public static String getTokenFrmDb(String investorEmailAddress) throws SQLException, ClassNotFoundException
{
	String token="";
	String Url = "jdbc:postgresql://dev-staging-rds.culhoehta5zf.ap-south-1.rds.amazonaws.com:5432/ecs_kredx_harry";
    String user="vinay";
    String password="vinay";	
   	String query = "select verification->'email_verification'->>'token' \r\n" + 
   			"from kredx.financiers \r\n" + 
   			"where verification->'email_verification'->>'email'='"+investorEmailAddress+"'";	//Query to Execute	
   	Connection con =null;
   	
 	try {
        Class.forName("org.postgresql.Driver");
    }
    catch (java.lang.ClassNotFoundException e) {
        System.out.println(e.getMessage());
    }	 	

	    try {
	    con = DriverManager.getConnection(Url,user,password); //Create Connection to DB	
	    System.out.println("Connected to the PostgreSQL server successfully.");
	}
    catch (SQLException e){
	    System.out.println(e.getMessage());
	}

Statement stmt= con.createStatement();   //Create Statement Object					
ResultSet rs= stmt.executeQuery(query);	// Execute the SQL Query. Store results in ResultSet						

if (rs.next()) {
token=rs.getString(1);
}
	
rs.close();
stmt.close();
con.close();  // closing DB Connection
	
	return token;
	
}

public static String getFinancierFrmDb(String investorEmailAddress) throws SQLException, ClassNotFoundException
{
	String uid="";
   	String Url = "jdbc:postgresql://dev-staging-rds.culhoehta5zf.ap-south-1.rds.amazonaws.com:5432/ecs_kredx_harry";
    String user="vinay";
    String password="vinay";	
   	String query = "select uid from kredx.financiers where verification->'email_verification'->>'email'='"+investorEmailAddress+"'";	//Query to Execute	
   	Connection con =null;
   	
   	try {
            Class.forName("org.postgresql.Driver");
        }
    catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }	 	

   	try {
		con = DriverManager.getConnection(Url,user,password); //Create Connection to DB	
		System.out.println("Connected to the PostgreSQL server successfully.");
		}
	catch (SQLException e){
		System.out.println(e.getMessage());
		}
   
   Statement stmt= con.createStatement();   //Create Statement Object					
   ResultSet rs= stmt.executeQuery(query);	// Execute the SQL Query. Store results in ResultSet						

   if (rs.next()) {
    uid=rs.getString(1);
   }
		
   rs.close();
   stmt.close();
   con.close();  // closing DB Connection

		return uid;
			
}
}