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
    private void handleLoginButtonAction(ActionEvent event) {
        /*String userString = username.getText();
        String passString = password.getText();
        String getResult = "SELECT * FROM USER "
                + "WHERE username = '" + userString + "' "
                + "AND password = '" + passString + "';";

        try {
            ResultSet rs = d.getResultSet(getResult); //TODO: Fill in this query
            if (!rs.next()) {
                //TODO: What should happen if there is no result?
                System.out.println("Login Failed!");
            } else {
                //TODO: What should happen if there is a result?
                System.out.println("Login Success!");
                psh.switcher(event, "MusicList.fxml");
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        String startText = startTime.getText();
        String endText = endTime.getText();
        String descriptionText = description.getText();
        String taskTitleText = taskTitle.getText();
        String taskDescriptionText = taskDescription.getText();
        String doDateText = doDate.getText();
        String dueDateText = dueDate.getText();
        String priorityText = priority.getText();
        String selectedCategory = category.getAccessibleText();

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

}
