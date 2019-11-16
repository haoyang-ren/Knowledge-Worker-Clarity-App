/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ryan
 */
public class KanbanBoardController {

    @FXML
    private TextArea compeletedTask;

    @FXML
    private TextArea tomorrowTask;

    @FXML
    private TextArea weekTask;

    @FXML
    private TextArea todayTask;


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
        // Default placeholder incase user have not task input
        compeletedTask.setText("Title" + " : " + "Description\n");
        todayTask.setText("Title" + " : " + "Description");
        tomorrowTask.setText("Title" + " : " + "Description");
        weekTask.setText("Title" + " : " + "Description");
        
        StringBuilder compeletedTaskString = new StringBuilder();
        StringBuilder todayTaskString = new StringBuilder();
        StringBuilder tomorrowTaskString = new StringBuilder();
        StringBuilder weekTaskString = new StringBuilder();
       
        try {
            ZoneId zone = ZoneId.systemDefault();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String getTask = "SELECT TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY FROM Tasks ";
            ResultSet taskSet = d.getResultSet(getTask);
            while (taskSet.next()) {
                String taskTitle = taskSet.getString("TASKTITLE");
                String taskDescription = taskSet.getString("TASKDESCRIPTION");
                LocalDateTime taskDoDate = LocalDateTime.parse(taskSet.getString("TASKDODATE"), formatter);
                LocalDateTime taskDueDate = LocalDateTime.parse(taskSet.getString("TASKDUEDATE"), formatter);
                int taskPriority = taskSet.getInt("TASKPRIORITY");

                LocalDateTime currentTime = LocalDateTime.now(zone);
                KanbanBoard kanban = new KanbanBoard(currentTime, taskDoDate, taskDueDate);
                if (kanban.checkCompleted(currentTime, taskDoDate, taskDueDate) == true) {
                    
                    compeletedTaskString.append(taskTitle).append(" : ").append(taskDescription).append("\n");
                }
                if (kanban.checkToday(currentTime, taskDoDate, taskDueDate) == true) {
                   
                    todayTaskString.append(taskTitle).append(" : ").append(taskDescription).append("\n");
                }
                if (kanban.checkTomorrow(currentTime, taskDoDate, taskDueDate) == true) {
                    
                    tomorrowTaskString.append(taskTitle).append(" : ").append(taskDescription).append("\n");
                }
                if (kanban.checkWeek(currentTime, taskDoDate, taskDueDate) == true) {
                    
                    weekTaskString.append(taskTitle).append(" : ").append(taskDescription).append("\n");
                }

            }
            
            compeletedTask.setText(compeletedTaskString.toString());
            todayTask.setText(todayTaskString.toString());
            tomorrowTask.setText(tomorrowTaskString.toString());
            weekTask.setText(weekTaskString.toString());

            taskSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?

    }

}
