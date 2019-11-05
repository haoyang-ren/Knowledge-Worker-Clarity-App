package BackEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ryan
 */
public class Entries {

    private String start;
    private String end;
    private String description;
    private String category;

    public Entries(String start, String end, String description, String taskTitle, String taskDescription, String doDate, String dueDate, String priority, String category) {
        this.start = start;
        this.end = end;
        this.description = description;
        this.category = category;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
  

}
