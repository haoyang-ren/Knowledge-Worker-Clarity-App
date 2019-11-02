/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

/**
 *
 * @author ryan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author calvinkoder
 */
public class Database {
   
 
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
		connect();
		insertPets();
		printAllPets();	
		getPets("Cat");
		getPets("Frog");
						
	}
	public static void connect() throws ClassNotFoundException, SQLException{		
		//create connection
                Connection conn = DriverManager.getConnection("jdbc:sqlite:studentDatabase.db");
        
		//create statement
                Statement st = conn.createStatement();
               
		//create your table
		String createStatement = "CREATE TABLE IF NOT EXISTS Entries "
                        + "(ID INTEGER PRIMARY KEY AUTO_INCREMENT, "
                        + "STARTTIME DATETIME NOT NULL, "
                        + "ENDTIME DATETIME NOT NULL,"
                        + "DURATION DOUBLE NOT NULL, "
                        + "DESCRIPTION TEXT NOT NULL, "
                        + "CATEGORY TEXT NOT NULL"
                        + ");";
                
                st.execute(createStatement);
                
                String createStatement2 = "CREATE TABLE IF NOT EXISTS Tasks "
                        + "(ID INTEGER PRIMARY KEY AUTO_INCREMENT=100000, "
                        + "TASKTITLE TEXT NOT NULL, "
                        + "TASKDESCRIPTION TEXT NOT NULL,"
                        + "TASKDODATE DATETIME NOT NULL, "
                        + "TASKDUEDATE DATETIME NOT NULL, "
                        + "TASKPRIORITY INTEGER NOT NULL"
                        + ");"; 
		
                st.execute(createStatement2);
		//cleanup code (close statement and connection objects)
        
                 st.close();
                 conn.close();
		
	}
	
	public static void insertPets() throws SQLException{
		//create connection
                Connection conn = DriverManager.getConnection("jdbc:sqlite:studentDatabase.db");
		//create statement
                Statement st  = conn.createStatement();
               
		//write the SQL query and the java code to insert all four pets
                
                String insertQuery = "INSERT OR IGNORE INTO Pets (ID," + EntriesController.getdescriptionText + "SPECIES, COLOUR, OWNER) "
                           + "VALUES (1, 'KITTY', 'CAT', 'GREY', 'ANDREW'), "
                           + "(2, 'BLAIR', 'CAT', 'WHITE', 'YENNI'), "
                           + "(3, 'MIMI', 'FROG', 'GREEN', 'HATHERINE'), "
                           + "(4, 'QUACKYMOOMOO', 'DOG', 'BROWN', 'PHOEBE');";
                
                st.execute(insertQuery);
		
	}
	
	public static void printAllPets() throws SQLException{
		//create connection
                Connection conn = DriverManager.getConnection("jdbc:sqlite:studentDatabase.db");
                
		//create statement
                Statement st = conn.createStatement();
                
		//write the SQL query and the java code to retrieve and print out all pets in the database
                String retrieveQuery = "SELECT * from Pets";
                
                ResultSet rs = st.executeQuery(retrieveQuery);
               
                while(rs.next()){
                    System.out.println(rs.getString(2) + " is owned by " + rs.getString(5));
                }
        
		System.out.println("** SEARCH ALL PETS **");
	}
	
	public static void getPets(String species) throws SQLException{
		//create connection
                Connection conn = DriverManager.getConnection("jdbc:sqlite:studentDatabase.db");
                
		//create statement
                Statement st = conn.createStatement();
                
		//write the SQL query to retrieve all pets that are of the species specified in the parameter of this method
                String query = "select * from Pets where SPECIES = '" + species.toUpperCase() + "';";
               
                
                ResultSet rs = st.executeQuery(query);
                
                while(rs.next()){
                    
                    System.out.println(rs.getString(2) + " is owned by " + rs.getString(5));
                }
                        
		System.out.println("** SEARCH FOR SPECIES =  " + species + " **");
	}
	
}
    

