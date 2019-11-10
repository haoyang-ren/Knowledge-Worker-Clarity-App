/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.Entries;
import BackEnd.Task;
import java.sql.ResultSet;
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
    private ComboBox<?> category;

    @FXML
    private TextField priority;

    @FXML
    private Button confirm;

    Database d = new Database();
    //TODO: Instatiate the PageSwitchHelper class
    PageSwitcher pageSwitcher = new PageSwitcher();

    public EntriesController(TextField startTime, TextField endTime, TextField description, TextField taskTitle, TextField taskDescription, TextField doDate, TextField dueDate, ComboBox<?> category, TextField priority) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.doDate = doDate;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        String startText = this.getStartTime();
        String endText = this.getEndTime();
        String descriptionText = this.getDescription();
        String selectedCategory = this.getCategory();
        String taskTitleText = this.getTaskTitle();
        String taskDescriptionText = this.getTaskDescription();
        String doDateText = this.getDoDate();
        String dueDateText = this.getDueDate();
        String priorityText = this.getPriority();
        
        Entries entry = new Entries(startText, endText, descriptionText, selectedCategory);
        Task task = new Task(taskTitleText, taskDescriptionText, doDateText, dueDateText,priorityText);

        //EntriesController ec = new EntriesController(startTime, endTime, description, taskTitle, taskDescription, doDate, dueDate, category, priority);
        
        
        try {

            pageSwitcher.switcher(event, "KanbanBoard.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?

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

    public String getCategory() {
        return category.getAccessibleText();
    }

    public void setCategory(ComboBox<?> category) {
        this.category = category;
    }

    public String getPriority() {
        return priority.getText();
    }

    public void setPriority(TextField priority) {
        this.priority = priority;
    }

    public Button getConfirm() {
        return confirm;
    }

    public void setConfirm(Button confirm) {
        this.confirm = confirm;
    }

}
