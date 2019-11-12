/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ryan
 */
public class KanbanBoardController {

    @FXML
    private TextField compeletedTask;

    @FXML
    private TextField tomorrowTask;

    @FXML
    private TextField todayTask;

    @FXML
    private TextField weekTask;

    @FXML
    private Button previous;


    @FXML
    private Button showTask;

    Database d = new Database();

    PageSwitcher pageSwitcher = new PageSwitcher();

    @FXML
    private void handlePreviousButton(ActionEvent event) {
        try {

            pageSwitcher.switcher(event, "Dashboard.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleShowTaskButton(ActionEvent event) {

        compeletedTask.setText("Title" + " : " + "Description\n");

        todayTask.setText("Title" + " : " + "Description");
        
        tomorrowTask.setText("Title" + " : " + "Description");
        
        weekTask.setText("Title" + " : " + "Description");
        
        try {
            /*String getEntries = "SELECT STARTTIME ENDTIME FROM Entries ";
            ResultSet entriesSet = d.getResultSet(getEntries);
            if (entriesSet.next()) {
                ZoneId zone = ZoneId.systemDefault();
                LocalDate startDate = entriesSet.getDate("STARTTIME").toInstant().atZone(zone).toLocalDate();
                LocalDate endDate = entriesSet.getDate("ENDTIME").toInstant().atZone(zone).toLocalDate();
                */
                ZoneId zone = ZoneId.systemDefault();
                String getTask = "SELECT TASKTITLE TASKDESCRIPTION TASKDODATE TASKDUEDATE TASKPRIORITY FROM Tasks ";
                        //+ "WHERE TASKDODATE > '" + startDate + "' "
                        //+ "AND TASKDUEDATE < '" + endDate + "';";
                ResultSet taskSet = d.getResultSet(getTask);
                while (taskSet.next()) {
                    String taskTitle = taskSet.getString("TASKTITLE");
                    String taskDescription = taskSet.getString("TASKDESCRIPTION");
                    LocalDate taskDoDate = taskSet.getDate("TASKDODATE").toInstant().atZone(zone).toLocalDate();
                    LocalDate taskDueDate = taskSet.getDate("TASKDODATE").toInstant().atZone(zone).toLocalDate();
                    int taskPriority = taskSet.getInt("TASKPRIORITY");

                    LocalDate currentTime = LocalDate.now(zone);
                    KanbanBoard kanban = new KanbanBoard(currentTime, taskDoDate, taskDueDate);
                    if (kanban.checkCompleted(currentTime, taskDoDate, taskDueDate) == true) {
                        compeletedTask.setText(taskTitle + " : " + taskDescription);
                    }
                    if (kanban.checkToday(currentTime, taskDoDate, taskDueDate) == true) {
                        todayTask.setText(taskTitle + " : " + taskDescription);
                    }
                    if (kanban.checkTomorrow(currentTime, taskDoDate, taskDueDate) == true) {
                        tomorrowTask.setText(taskTitle + " : " + taskDescription);
                    }
                    if (kanban.checkWeek(currentTime, taskDoDate, taskDueDate) == true) {
                        weekTask.setText(taskTitle + " : " + taskDescription);
                    }
                    
                }
                taskSet.close();
            //}

            //entriesSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?

    }

}
