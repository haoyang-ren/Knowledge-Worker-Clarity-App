/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author calvinkoder
 */
public class DashboardController implements Initializable {

    
    @FXML
    private BarChart<String, Integer> DailyChart;

    @FXML
    private CategoryAxis CategoryAxis;

    @FXML
    private NumberAxis HoursAxis;
    
    @FXML
    private BarChart<String, Integer> WeeklyChart;
    
    @FXML
    private CategoryAxis CategoryAxis2;

    @FXML
    private NumberAxis HoursAxis2;
    
    @FXML
    private Button KanbanButton;
    
    PageSwitcher pageSwitcher = new PageSwitcher();
    
    @FXML
    private void handleKanbanButtonAction(ActionEvent event) throws IOException{
        pageSwitcher.switcher(event, "KanbanBoard.fxml");
    }
    
    @FXML
    private void handleDeepFocusButtonAction(ActionEvent event) throws IOException{
        pageSwitcher.switcher(event, "DeepFocusScreen.fxml");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
       // TODO
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Time Spent");
        series1.getData().add(new XYChart.Data("Work", 3));
        series1.getData().add(new XYChart.Data("Reading", 10));
        
        DailyChart.getData().addAll(series1); 
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Time Spent");
        series2.getData().add(new XYChart.Data("Study",99));
        series2.getData().add(new XYChart.Data("Relax", 50));
        series2.getData().add(new XYChart.Data("Work", 20));
        
        WeeklyChart.getData().addAll(series2); 
        
        
        
    }    
    
}
