/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author calvinkoder
 */
public class AboutController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private Button back;

   
    PageSwitcher pageSwitcher = new PageSwitcher();

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
    pageSwitcher.switcher(event, "Dashboard.fxml");    
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
