/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

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
    private Button next;

    @FXML
    private void handlePreviousButton(ActionEvent event) {

    }

    @FXML
    private void handleNextButton(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?

    }

}
