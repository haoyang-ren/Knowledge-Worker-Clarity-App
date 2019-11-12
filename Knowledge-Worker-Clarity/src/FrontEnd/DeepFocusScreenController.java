/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DateFormat;
import javafx.util.Duration;
import java.time.LocalTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author lukestrong
 */
public class DeepFocusScreenController implements Initializable {

    @FXML
    private Label DeepFocusLabel;

    @FXML
    private Label DeepFocusLabel1;

    @FXML
    private ChoiceBox tasklist;

    @FXML
    private Label DeepFocusLabel11;

    @FXML
    private Label DeepFocusLabel111;

    @FXML
    private TextField tasknametext;

    @FXML
    private TextField taskdesctext;

    @FXML
    private Label DeepFocusLabel112;

    @FXML
    private TextField timefield;

    @FXML
    private TextField datefield;

    @FXML
    private Button back;

    Database d = new Database();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

    Date date = new Date();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {



            String getTasks = "SELECT TASKTITLE TASKDESCRIPTION FROM Tasks ";
            ResultSet taskSet = d.getResultSet(getTasks);
            if (taskSet.next()) {
                String taskTitle = taskSet.getString("TASKTITLE");
                String taskDescription = taskSet.getString("TASKDESCRIPTION");
                tasklist.getItems().add("Choice 1");

                System.out.println(taskTitle);

            }
            
            //Display current date
            datefield.setText(dateFormat.format(date));
            datefield.setAlignment(Pos.CENTER);
            datefield.setFont(Font.font("Arial", 24));

            //Display current date
            timefield.setText(dateFormat.format(date));
            timefield.setAlignment(Pos.CENTER);
            timefield.setFont(Font.font("Arial", 24));

            //Source:
            Timeline timepiece = new Timeline(new KeyFrame(Duration.ZERO, e -> {
                LocalTime timeNow = LocalTime.now();
                timefield.setText(timeNow.getHour() + ":" + timeNow.getMinute() + ":" + timeNow.getSecond());
            }),
                    new KeyFrame(Duration.seconds(1))
            );
            timepiece.setCycleCount(Animation.INDEFINITE);
            timepiece.play();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    PageSwitcher pageSwitcher = new PageSwitcher();

    @FXML
    private void handlePreviousButton(ActionEvent event) {
        try {

            pageSwitcher.switcher(event, "Dashboard.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
