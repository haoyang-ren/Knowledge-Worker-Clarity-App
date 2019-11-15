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
        
        // REMOVE DROP STATEMENTS BEFORE SUBMIT
       String createStatement3 = "DROP TABLE Entries ";
       String createStatement4 = "DROP TABLE Tasks ";
       String createStatement6 = "DROP TABLE DailyLearnings ";
       st.execute(createStatement3);
       st.execute(createStatement4);
       st.execute(createStatement6);
        //create your table
        String createStatement = "CREATE TABLE IF NOT EXISTS Entries "
                + "(ID INTEGER PRIMARY KEY, "
                + "STARTTIME TEXT NOT NULL, "
                + "ENDTIME TEXT NOT NULL,"
                + "DURATION DOUBLE NOT NULL, "
                + "DESCRIPTION TEXT NOT NULL, "
                + "CATEGORY TEXT NOT NULL"
                + ");";

        st.execute(createStatement);

        String createStatement2 = "CREATE TABLE IF NOT EXISTS Tasks "
                + "(ID INTEGER PRIMARY KEY, "
                + "TASKTITLE TEXT NOT NULL, "
                + "TASKDESCRIPTION TEXT NOT NULL,"
                + "TASKDODATE TEXT NOT NULL, "
                + "TASKDUEDATE TEXT NOT NULL, "
                + "TASKPRIORITY INTEGER NOT NULL"
                + ");";

        st.execute(createStatement2);
        //cleanup code (close statement and connection objects)
        // conn.close();
        
        
        String createStatement5 = "CREATE TABLE IF NOT EXISTS DailyLearnings "
                + "(ID INTEGER PRIMARY KEY,"
                + "DONEWELL TEXT NOT NULL,"
                + "DONEBETTER TEXT NOT NULL, "
                + "DATE TEXT NOT NULL"
                + ");";

        st.execute(createStatement5);
        

    }
    
    public void insertDummyData() throws SQLException {

        openConnection();

        Statement s = conn.createStatement();

        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2014-10-23 15:21:07','2014-10-23 20:21','5.0', 'Notes', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2014-10-23 15:21:07','2014-10-23 22:21','20.0', 'Notes', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-12 10:21','2019-11-12 10:21','7.0', 'Notes', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-13 10:21','2019-11-12:10:07','100.0', 'Notes', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-07 10:21','2019-11-07 22:21','20.0', 'Notes', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-08 10:21','2019-11-07 22:21','70.0', 'Notes', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-07 10:21','2019-11-07 22:21','50.0', 'Notes', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-08 10:21','2019-11-07 22:21','20.0', 'Notes', 'Work');");
        
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Procrastinating','Watching cat videos','2014-10-23 15:21', '2014-10-23 22:21', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('DO assignment','Watching cat videos','2019-11-13 15:21', '2019-11-15 22:21', '1');");

        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Studying','Watching dog videos','2019-11-15 18:21', '2020-11-12 18:21', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Procrastinating','Watching horse videos','2019-11-16 23:21', '2019-11-13 23:25', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Working','INFS2605','2019-11-15 18:21', '2019-11-20 18:21', '1');");
        
        s.execute("INSERT OR REPLACE INTO DailyLearnings(DONEWELL, DONEBETTER, DATE) VALUES ('WORKED HARD', 'TRY HARDER', '2019-11-15 20:00');");
        s.execute("INSERT OR REPLACE INTO DailyLearnings(DONEWELL, DONEBETTER, DATE) VALUES ('WORD', 'TRDER', '2019-01-15 20:00');");
        
        s.close();
       // conn.close();
        
    } 

    public void insertEntries(Entries entry) throws SQLException {
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
        st.setString(3, "20");
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