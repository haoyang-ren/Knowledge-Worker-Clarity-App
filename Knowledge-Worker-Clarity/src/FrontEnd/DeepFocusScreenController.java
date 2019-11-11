/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author lukestrong
 */
public class DeepFocusScreenController implements Initializable {

    
    
    @FXML
    private Label DeepFocusLabel;
    
    @FXML
    private TextField timefield;
    
    @FXML
    private TextField datefield;
    
    @FXML
    private TextField tasknametext;
    
    @FXML
    private TextField taskdesctext;
    

    
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    
    Date date = new Date();
    
    
    //datefield.setText(dateFormat.format(date));
       @FXML
        public void initialize(URL url, ResourceBundle rb) {
         try {
               timefield.setText("Hi");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
