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
import java.time.LocalDate;

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
                + "DOBETTER TEXT NOT NULL, "
                + "DATE TEXT NOT NULL"
                + ");";

        st.execute(createStatement5);
        

    }
    
    public void insertDummyData() throws SQLException {

        openConnection();

        Statement s = conn.createStatement();
        
        //DUMMY DATA FOR DAILY CHART
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-14 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-14 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-14 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-14 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-14 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-16 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-16 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-16 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-16 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-16 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-17 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-17 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-17 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-17 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-17 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-18 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-18 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-18 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-18 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-18 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-19 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-19 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-19 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-19 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-19 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-20 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-20 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-20 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-20 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-20 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-21 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-21 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-21 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-21 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-21 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-22 10:21:07','2019-11-23 20:21','5.0', 'INFS2605', 'Study');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-22 10:21:07','2019-11-23 22:21','3.0', 'Accounting', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-22 10:21','2019-11-16 15:21','2.0', 'Notes', 'Exercise');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-22 10:21','2019-11-16 18:07','8.0', 'Went to a party', 'Social');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-22 10:21','2019-11-17 17:21','8.0', 'Slept', 'Relax');");
       //For weekly breakdown
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21','2019-11-17 17:21','20.0', 'Slept', 'Work');");
        s.execute("INSERT OR IGNORE INTO Entries(STARTTIME, ENDTIME, DURATION, DESCRIPTION, CATEGORY) VALUES ('2019-11-15 10:21','2019-11-17 17:21','25.0', 'Slept', 'Exercise');");
        
        
        
        
        
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Do Assignment','INFS2605 Group Assingment','2019-11-16 15:21', '2019-11-17 22:21', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Revision','Accounting Quiz','2019-11-18 15:21', '2019-11-15 22:21', '1');");
        s.execute("INSERT OR IGNORE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Do Assignment','INFS2605 Group Assingment','2019-11-20 15:21', '2019-11-20 22:21', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Revision','Finance Quiz','2019-11-20 18:21', '2019-11-16 18:21', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Do Assignment','Information systems homework','2019-11-18 23:21', '2019-11-17 23:25', '1');");
        s.execute("INSERT OR REPLACE INTO Tasks(TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY) VALUES ('Prepare for interview','Summer internship','2019-11-19 18:21', '2019-11-20 18:21', '1');");
        
        //DAILY LEARNINGS DUMMY DATA
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Ate healthy', 'Do more exercise', '2019-10-16 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-10-17 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Relax more', '2019-10-18 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-10-19 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'So more exercise', '2019-10-20 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Revised alot', 'Sleep earlier', '2019-10-21 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'Relax more', '2019-10-22 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Worked hard', 'Sleep earlier', '2019-10-23');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'Work harder', '2019-10-24 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Ate healthy', 'Do more exercise', '2019-10-25 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-10-26 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Relax more', '2019-10-27 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-10-28 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'So more exercise', '2019-10-29 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Revised alot', 'Sleep earlier', '2019-10-30 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'Relax more', '2019-10-31 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Worked hard', 'Sleep earlier', '2019-11-01');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'Work harder', '2019-11-02 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Ate healthy', 'Do more exercise', '2019-11-03 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-11-04 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Relax more', '2019-11-05 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-11-06 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'So more exercise', '2019-11-07 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Revised alot', 'Sleep earlier', '2019-11-08 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'Relax more', '2019-11-09 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Worked hard', 'Sleep earlier', '2019-11-10');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'Work harder', '2019-11-11 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Ate healthy', 'Do more exercise', '2019-11-12 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-11-13 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Relax more', '2019-11-14 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Studied hard', 'Sleep earlier', '2019-11-15 ');");
        s.execute("INSERT OR IGNORE INTO DailyLearnings(DONEWELL, DOBETTER, DATE) VALUES ('Slept well', 'So more exercise', '2019-11-16 ');");
 
        
        
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
        st.setString(3, entry.getDuration());
        st.setString(4, entry.getDescription());
        st.setString(5, entry.getCategory());

        st.execute();
        st.close();

    }

    public void insertTasks(Task task) throws SQLException {

       openConnection();

        String myPreparedSt = "INSERT OR IGNORE INTO Tasks (TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY)"
                + "VALUES (?,?,?,?,?)";

        PreparedStatement st = conn.prepareStatement(myPreparedSt);

        st.setString(1, task.getTaskTitle());
        st.setString(2, task.getTaskDescription());
        st.setString(3, task.getDoDate());
        st.setString(4, task.getDueDate());
        st.setString(5, task.getPriority());
        st.execute();
        st.close();

    }
    public void insertLearning(String doneWell, String doBetter) throws SQLException{
        
       openConnection();
        
       // Statement s = conn.createStatement();
       LocalDate today = LocalDate.now(); 
       String date = today.toString();
       
       
        String myPreparedSt = "INSERT OR REPLACE INTO DailyLearnings (DONEWELL, DOBETTER, DATE)"
                + " VALUES (?,?,?)";

        try{
        PreparedStatement st = conn.prepareStatement(myPreparedSt);
        
        st.setString(1, doneWell);
        st.setString(2, doBetter);
        st.setString(3, date);
        
        st.execute();
        st.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
       // s.execute("INSERT OR REPLACE INTO DailyLearnings (DONEWELL, DOBETTER, DATE) VALUES ('" + doneWell + "', '" + doBetter + "', '2019-01-15');");
        
        //s.close();
    }
    
    


}