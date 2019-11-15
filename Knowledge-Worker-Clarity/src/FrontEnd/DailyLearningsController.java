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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author calvinkoder
 */
public class DailyLearningsController implements Initializable {

    
    @FXML
    private Button backButton;

    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
          pageSwitcher.switcher(event, "Dashboard.fxml");          
    }
    
    PageSwitcher pageSwitcher = new PageSwitcher();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
