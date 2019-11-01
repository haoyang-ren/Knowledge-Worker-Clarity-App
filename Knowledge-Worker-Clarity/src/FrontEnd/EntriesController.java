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
        
    }

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?
        
    }

}
