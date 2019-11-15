/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author calvinkoder
 */
public class DailyLearningsController implements Initializable {

    
    @FXML
    private Button backButton;
    
    @FXML
    private ComboBox<String> betterComboBox;

    @FXML
    private ComboBox<?> wellComboBox;
    
    PageSwitcher pageSwitcher = new PageSwitcher();
    Database d = new Database();
    
    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
          pageSwitcher.switcher(event, "Dashboard.fxml");          
    }
    
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         try {
    
                String doBetterQuery = "SELECT DONEBETTER from DailyLearnings "
                         + "ORDER BY DONEBETTER asc; ";
    
                ResultSet rs = d.getResultSet(doBetterQuery);
    
                ObservableList<String> betterList = FXCollections.observableArrayList();
                   
              while(rs.next()){
                   String doBetter = rs.getString(1);
                  betterList.add(doBetter);
                }
                
                
                betterComboBox.setItems(betterList);
                
        }catch(Exception e){
            e.printStackTrace();
    
    }
    
    
        
        
    }    
    
}
