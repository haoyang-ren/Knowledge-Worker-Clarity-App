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
import java.util.ArrayList;
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

    @FXML
    private Button softpiano;
    
    @FXML
    private Button ukulele;
    
    @FXML
    private Button rock;

    Database d = new Database();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

    Date date = new Date();
    ArrayList<String> tasktitles = new ArrayList<String>();
    ArrayList<String> taskdescs = new ArrayList<String>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tasklist.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> updateText());
        try {

            String getTask = "SELECT TASKTITLE, TASKDESCRIPTION, TASKDODATE, TASKDUEDATE, TASKPRIORITY FROM Tasks ";
            ResultSet taskSet = d.getResultSet(getTask);

            while (taskSet.next()) {
                String taskTitle = taskSet.getString("TASKTITLE");
                tasktitles.add(taskTitle);

                String taskDescription = taskSet.getString("TASKDESCRIPTION");
                taskdescs.add(taskDescription);

                tasklist.getItems().add(taskTitle);

            }

            //Display current date
            datefield.setText(dateFormat.format(date));
            datefield.setAlignment(Pos.CENTER);
            datefield.setFont(Font.font("Arial", 24));

            //Display current date
            timefield.setText(dateFormat.format(date));
            timefield.setAlignment(Pos.CENTER);
            timefield.setFont(Font.font("Arial", 24));

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

    @FXML
    private void handlePianoButton(ActionEvent event) {
        MusicPlaybackHelper.playMusic("piano.mp3");
    }

    @FXML
    private void handleUkeButton(ActionEvent event) {
        MusicPlaybackHelper.playMusic("uke.mp3");
    }

    @FXML
    private void handleRockButton(ActionEvent event) {
        MusicPlaybackHelper.playMusic("rock.mp3");
    }

    private void updateText() {
        tasknametext.setText(tasklist.getValue().toString());
        tasknametext.setAlignment(Pos.CENTER);
        tasknametext.setFont(Font.font("Arial", 24));

        taskdesctext.setText(taskdescs.get(tasktitles.indexOf(tasklist.getValue().toString())));
        taskdesctext.setAlignment(Pos.CENTER);
        taskdesctext.setFont(Font.font("Arial", 18));
    }

}
