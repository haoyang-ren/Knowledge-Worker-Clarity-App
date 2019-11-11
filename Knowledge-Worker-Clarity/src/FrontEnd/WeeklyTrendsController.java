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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author thegoochlord
 */
public class WeeklyTrendsController implements Initializable {
    
    
    @FXML
    private LineChart<String, Integer> WeeklyTrends;

    @FXML
    private CategoryAxis CategoryAxis;

    @FXML
    private NumberAxis NumberAxis; 
   
    
    
    PageSwitcher pageSwitcher = new PageSwitcher();
    
   
    
    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
        pageSwitcher.switcher(event, "Dashboard.fxml");
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series series = new XYChart.Series();
        
        series.getData().add(new XYChart.Data("1", 23));
        series.getData().add(new XYChart.Data("2", 24));
        series.setName("Studying");
        
        XYChart.Series series1 = new XYChart.Series();
        
        series1.getData().add(new XYChart.Data("1", 15));
        series1.getData().add(new XYChart.Data("2", 12));
        series1.setName("Procrastinating");
        WeeklyTrends.getData().addAll(series, series1); 
        
        
       
   
    }    
    
}
