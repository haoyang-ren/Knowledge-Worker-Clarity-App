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
import BackEnd.Entries;
import BackEnd.Task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author calvinkoder
 */
public class Database {

    /*public static void main(String[] args) throws ClassNotFoundException, SQLException {
        connect();

    }*/
    
    public static Connection conn;

	/* NO NEED TO CALL THIS METHOD OUTSIDE THE DATABASE CLASS */
    public static void openConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
      
    /* Pass an SQL String into this method when querying the database */
    public ResultSet getResultSet(String sqlstatement) throws SQLException {
        openConnection();
        java.sql.Statement statement = conn.createStatement();
        ResultSet RS = statement.executeQuery(sqlstatement);
        return RS;
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        //create connection
        openConnection();

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

    public static void insertEntries(Entries entry) throws SQLException {
        //create connection
        openConnection();
        //create statement

        //EntriesController ec = new EntriesController();
        //String newDescription = ec.getDescription().getText();
        String myPreparedSt = "INSERT OR IGNORE INTO Entries (STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY)"
                + "VALUES (?,?,?,?,?)";

        PreparedStatement st = conn.prepareStatement(myPreparedSt);

        st.setString(1, entry.getStart());
        st.setString(2, entry.getEnd());
        //add duration
        st.setString(4, entry.getDescription());
        st.setString(5, entry.getCategory());

        st.execute(myPreparedSt);

    }

    public static void insertTasks(Task task) throws SQLException {

       openConnection();

        String myPreparedSt = "INSERT OR IGNORE INTO Tasks (TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY)"
                + "VALUES (?,?,?,?,?)";

        PreparedStatement st = conn.prepareStatement(myPreparedSt);

        st.setString(1, task.getTaskTitle());
        st.setString(2, task.getTaskDescription());
        st.setString(3, task.getDoDate());
        st.setString(4, task.getDueDate());
        st.setString(5, task.getPriority());
        st.execute(myPreparedSt);

    }
    
    
    


}