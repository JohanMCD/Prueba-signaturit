package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	
	 private static Connection connection = null;
	 private static Statement stm = null;
	 private final static String ADRESS   = "jdbc:mysql://dlimybe01.oracle.sta";
	 private final static String DATABASE = "apptech";
	 private final static String USER     = "ow_apptech";
	 private final static String PASSWORD = "wdxfnbi6";
	 private final static String PORT     = "3306";
	 private final static String DRIVER   = "com.mysql.jdbc.Driver";
	    
	    /**
	     * Method that loads the specified driver
	     * 
	     * @return void
		**/
		
		private static void loadDriver() {
		    try {
		        Class.forName(DRIVER);
		    }
		    catch (Exception e) {
		        errorHandler("Failed to load the driver " + DRIVER, e);
		    }
		}

	    /**
	     * Method that loads the connection into the right property
	     * 
	     * @return void
	     **/
	    
	    private static void loadConnection() {
	        try {
	            connection = DriverManager.getConnection(getFormatedUrl(), USER, PASSWORD);
	        }
	        catch (SQLException e) {
	            errorHandler("Failed to connect to the database " + getFormatedUrl(), e);         
	        }
	    }
	    
	    /**
	     * Method that shows the errors thrown by the singleton
	     * 
	     * @param  {String}    Message
	     * @option {Exception} e
	     * @return  void
	     **/
	    
	    private static void errorHandler(String message, Exception e) {
	        System.out.println(message);  
	        if (e != null) System.out.println(e.getMessage());   
	    }

	    /**
	     * Method that returns the formated URL to connect to the database
	     * 
	     * @return {String}
	     **/
	    
	    private static String getFormatedUrl() {
	        return ADRESS + ":" + PORT + "/" + DATABASE;
	    }
	    
	    /**
	     * Static method that returns the instance for the singleton
	     * 
	     * @return {Connection} connection
	     **/
	    
	    public static Connection getConnection() {
	        if (connection == null) {
	            loadDriver();
	            loadConnection();
	        }
	        return connection;
	    }
	    
	    public static Statement StatementQuery(){
	    	try {
	    		 stm = connection.createStatement();
			} catch (Exception e) {
				// TODO: handle exception
			}	
	    	return stm;
	    }
	    
	    /**
	     * Static method that close the connection to the database
	     * 
	     * @return void
	     **/
	    
	    public static void closeConnection() {
	        if (connection == null) {
	            errorHandler("No connection found", null);
	        }
	        else {
	            try {
	                connection.close();
	                connection = null;
	            }
	            catch (SQLException e) {
	                errorHandler("Failed to close the connection", e);
	            }
	        }
	    }
}
