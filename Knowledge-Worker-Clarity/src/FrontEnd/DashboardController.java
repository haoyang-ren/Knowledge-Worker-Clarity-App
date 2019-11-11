/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import com.sun.javafx.charts.Legend;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author calvinkoder
 */
public class DashboardController implements Initializable {

    
    @FXML
    private Label ClarityLabel;
    
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
    
    @FXML
    private Button LogEntryButton;
    
    @FXML
    private Button WeeklyTrendsButton;
    
    @FXML
    private PieChart PieChart;

    
    PageSwitcher pageSwitcher = new PageSwitcher();
    
    @FXML
    private void handleKanbanButtonAction(ActionEvent event) throws IOException{
        pageSwitcher.switcher(event, "KanbanBoard.fxml");
    }
    
    @FXML
    private void handleDeepFocusButtonAction(ActionEvent event) throws IOException{
        pageSwitcher.switcher(event, "DeepFocusScreen.fxml");
    }
    
    @FXML
    void handleLogEntryButtonAction(ActionEvent event) throws IOException {
        pageSwitcher.switcher(event, "Entries.fxml");
    }
    
    @FXML
    void handleWeeklyTrendsButtonAction(ActionEvent event) throws IOException {
        pageSwitcher.switcher(event, "WeeklyTrends.fxml");
    }
    
    //private ArrayList<String> categoryArrayList = new ArrayList<>();
    //private ArrayList<Integer> hoursArrayList = new ArrayList<>();
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //DummyData
       // categoryArrayList.add("Reading");
       // categoryArrayList.add("Work");
       // categoryArrayList.add("Study");
       // categoryArrayList.add("Social");
       // categoryArrayList.add("Relax");
        
        
       
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
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Study", 13),
                new PieChart.Data("Work", 25),
                new PieChart.Data("Relax", 10),
                new PieChart.Data("Reading", 22),
                new PieChart.Data("Social", 30)
        );
        PieChart.setData(pieChartData);
        
        String[] pieColors = {"#8ee53f", "#2f7532", "#8e4585", "#1ca9c9", "#afeeee"};
        int i = 0;
        for (PieChart.Data data : pieChartData) {
            data.getNode().setStyle(
                    "-fx-pie-color: " + pieColors[i % pieColors.length] + ";"
            );
            i++;
        }
        i = 0;
        
        for (Node n : PieChart.getChildrenUnmodifiable()) {
            if (n instanceof Legend) {
                Legend l = (Legend) n;
                for (Legend.LegendItem li : l.getItems()) {
                    Node thisNode = li.getSymbol();
                    thisNode.setStyle(
                            "-fx-pie-color: " + pieColors[i % pieColors.length] + ";"
                    );
                    i++;
                }
            }
        }
        
    }    
    
}
