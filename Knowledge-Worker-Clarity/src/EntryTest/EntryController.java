/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntryTest;

import BackEnd.Entries;
import BackEnd.Task;
import java.sql.SQLException;
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
public class EntryController {

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
    private TextField priority;

    @FXML
    private ComboBox<?> category;

    @FXML
    private Button confirm;

    public EntryController(TextField startTime, TextField endTime, TextField description, TextField taskTitle, TextField taskDescription, TextField doDate, TextField dueDate, TextField priority, ComboBox<?> category, Button confirm) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.doDate = doDate;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.confirm = confirm;
    }
/*
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {

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
        Task task = new Task(taskTitleText, taskDescriptionText, doDateText, dueDateText, priorityText);

        //EntriesController ec = new EntriesController(startTime, endTime, description, taskTitle, taskDescription, doDate, dueDate, category, priority);
        Database.insertEntries(entry);
        Database.insertTasks(task);

        try {

            pageSwitcher.switcher(event, "KanbanBoard.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
*/
    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?

    }

    public TextField getStartTime() {
        return startTime;
    }

    public void setStartTime(TextField startTime) {
        this.startTime = startTime;
    }

    public TextField getEndTime() {
        return endTime;
    }

    public void setEndTime(TextField endTime) {
        this.endTime = endTime;
    }

    public TextField getDescription() {
        return description;
    }

    public void setDescription(TextField description) {
        this.description = description;
    }

    public TextField getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(TextField taskTitle) {
        this.taskTitle = taskTitle;
    }

    public TextField getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(TextField taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TextField getDoDate() {
        return doDate;
    }

    public void setDoDate(TextField doDate) {
        this.doDate = doDate;
    }

    public TextField getDueDate() {
        return dueDate;
    }

    public void setDueDate(TextField dueDate) {
        this.dueDate = dueDate;
    }

    public TextField getPriority() {
        return priority;
    }

    public void setPriority(TextField priority) {
        this.priority = priority;
    }

    public ComboBox<?> getCategory() {
        return category;
    }

    public void setCategory(ComboBox<?> category) {
        this.category = category;
    }

    public Button getConfirm() {
        return confirm;
    }

    public void setConfirm(Button confirm) {
        this.confirm = confirm;
    }

}