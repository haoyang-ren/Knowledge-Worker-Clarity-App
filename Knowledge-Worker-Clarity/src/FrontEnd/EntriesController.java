/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.Entries;
import BackEnd.Task;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ryan
 */
public class EntriesController {

    @FXML
    private TextField startTime;

    @FXML
    private TextField endTime;

    @FXML
    private TextField description;

    @FXML
    private TextField taskTitle;

    @FXML
    private TextField taskDescription;

    @FXML
    private TextField doDate;

    @FXML
    private TextField dueDate;

    @FXML
    private ComboBox<String> category;

    @FXML
    private TextField priority;

    @FXML
    private Button confirmButton;
    
    @FXML
    private Button confirmTaskButton;

    Database d = new Database();
    //TODO: Instatiate the PageSwitchHelper class
    PageSwitcher pageSwitcher = new PageSwitcher();

    /*public EntriesController(TextField startTime, TextField endTime, TextField description, TextField taskTitle, TextField taskDescription, TextField doDate, TextField dueDate, ComboBox<?> category, TextField priority) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.doDate = doDate;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
    }*/

    @FXML
    private void handleConfirmButtonAction(ActionEvent event) throws SQLException {
        
        String startText = this.getStartTime();
        String endText = this.getEndTime();
        String descriptionText = this.getDescription();
        String categoryText = category.getValue();
       
        
        Entries entry = new Entries(startText, endText, descriptionText, categoryText);
        

        d.insertEntries(entry);
        //Database.insertTasks(task);
        
        try {

            pageSwitcher.switcher(event, "KanbanBoard.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    @FXML
    private void handleConfirmTaskButtonAction(ActionEvent event) throws SQLException {    
        
        
        String taskTitleText = this.getTaskTitle();
        String taskDescriptionText = this.getTaskDescription();
        String doDateText = this.getDoDate();
        String dueDateText = this.getDueDate();
        String priorityText = this.getPriority();
        
        Task task = new Task(taskTitleText, taskDescriptionText, doDateText, dueDateText,priorityText);
        
        d.insertTasks(task);

    }
    
    
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException{
        pageSwitcher.switcher(event, "Dashboard.fxml");
    }

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?
        ObservableList<String> categoryList = FXCollections.observableArrayList();
        
        categoryList.add("Study");
        categoryList.add("Work");
        categoryList.add("Eating");
        
        category.setItems(categoryList);
    }

    public String getStartTime() {
        return startTime.getText();
    }

    public void setStartTime(TextField startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime.getText();
    }

    public void setEndTime(TextField endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description.getText();
    }

    public void setDescription(TextField description) {
        this.description = description;
    }

    public String getTaskTitle() {
        return taskTitle.getText();
    }

    public void setTaskTitle(TextField taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription.getText();
    }

    public void setTaskDescription(TextField taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDoDate() {
        return doDate.getText();
    }

    public void setDoDate(TextField doDate) {
        this.doDate = doDate;
    }

    public String getDueDate() {
        return dueDate.getText();
    }

    public void setDueDate(TextField dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority.getText();
    }

    public void setPriority(TextField priority) {
        this.priority = priority;
    }

    public Button getConfirm() {
        return confirmButton;
    }

    public void setConfirm(Button confirm) {
        this.confirmButton = confirm;
    }

}
