/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

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

    @FXML
    private void handleButtonAction(ActionEvent event) {

        String startText = this.getStartTime().getText();
        String endText = this.getEndTime().getText();
        String descriptionText = this.getDescription().getText();
        String taskTitleText = this.getTaskTitle().getText();
        String taskDescriptionText = this.getTaskDescription().getText();
        String doDateText = this.getDoDate().getText();
        String dueDateText = this.getDueDate().getText();
        String priorityText = this.getPriority().getText();
        String selectedCategory = this.getCategory().getAccessibleText();
         
        try {

            pageSwitcher.switcher(event, "Entries.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

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

    public ComboBox<?> getCategory() {
        return category;
    }

    public void setCategory(ComboBox<?> category) {
        this.category = category;
    }

    public TextField getPriority() {
        return priority;
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

    public Database getD() {
        return d;
    }

    public void setD(Database d) {
        this.d = d;
    }

    public PageSwitcher getPageSwitcher() {
        return pageSwitcher;
    }

    public void setPageSwitcher(PageSwitcher pageSwitcher) {
        this.pageSwitcher = pageSwitcher;
    }

}
