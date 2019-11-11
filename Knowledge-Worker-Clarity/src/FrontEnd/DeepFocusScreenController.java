/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DateFormat;
import javafx.geometry.Pos;
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
    private TextField timefield;
    
    @FXML
    private TextField datefield;
    
    @FXML
    private TextField tasknametext;
    
    @FXML
    private TextField taskdesctext;
    

    
    
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
    
    Date date = new Date();
    
    
    //datefield.setText(dateFormat.format(date));
       @Override
        public void initialize(URL url, ResourceBundle rb) {
         try {
               timefield.setText(dateFormat.format(date));
               timefield.setAlignment(Pos.CENTER);
                timefield.setFont(Font.font ("Arial", 24));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
