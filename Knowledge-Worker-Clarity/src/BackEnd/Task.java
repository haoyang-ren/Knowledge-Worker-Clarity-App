/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.time.LocalDate;

/**
 *
 * @author ryan
 */
public class Task {
    private String taskTitle;
    private String taskDescription;
    private String doDate;
    private String dueDate;
    private String priority;

    public Task(String taskTitle, String taskDescription, String doDate, String dueDate, String priority) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.doDate = doDate;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDoDate() {
        return doDate;
    }

    public void setDoDate(String doDate) {
        this.doDate = doDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    
    
}
