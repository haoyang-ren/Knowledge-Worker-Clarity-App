/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import com.sun.javafx.charts.Legend;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
    
    @FXML
    private Button aboutButton;
    
    @FXML
    private Button dailyLearningsButton;
    
    
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
    
    @FXML
    void handleAboutButtonAction(ActionEvent event) throws IOException {
       pageSwitcher.switcher(event, "About.fxml");     
    }
    
    @FXML
    void handleDailyLearningsButtonAction(ActionEvent event) throws IOException{
        pageSwitcher.switcher(event, "DailyLearnings.fxml");
    }
    
       
    //private ArrayList<String> categoryArrayList = new ArrayList<>();
    //private ArrayList<Integer> hoursArrayList = new ArrayList<>();
    
   
    
     Database d = new Database();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //DummyData
       // categoryArrayList.add("Reading");
       // categoryArrayList.add("Work");
       // categoryArrayList.add("Study");
       // categoryArrayList.add("Social");
       // categoryArrayList.add("Relax");
       
        try{
        
        String dailyQuery = "SELECT CATEGORY, SUM(DURATION) from ENTRIES"
                + " WHERE STARTTIME BETWEEN datetime('now', 'start of day') AND datetime ('now', 'localtime')"
                + "GROUP BY CATEGORY ORDER BY CATEGORY asc;";
        
       // TODO
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        
        
        ResultSet rs = d.getResultSet(dailyQuery);
        series1.setName("Time Spent");
                
        while (rs.next()){
            String category = rs.getString(1);
            int hours = rs.getInt(2);
            series1.getData().add(new XYChart.Data<>(category, hours));
        }
        DailyChart.getData().addAll(series1);
        
        Node n = DailyChart.lookup(".data0.chart-bar");
    n.setStyle("-fx-bar-fill: #02e04c");
    n = DailyChart.lookup(".data1.chart-bar");
    n.setStyle("-fx-bar-fill: #00f3ba");
    n = DailyChart.lookup(".data2.chart-bar");
    n.setStyle("-fx-bar-fill: #48ffff");
    n = DailyChart.lookup(".data3.chart-bar");
    n.setStyle("-fx-bar-fill: #00aaff");
     n = DailyChart.lookup(".data4.chart-bar");
    n.setStyle("-fx-bar-fill: #8402c4");
        
        
        }catch (Exception e){
        }
        
       // series1.setName("Time Spent");
        //series1.getData().add(new XYChart.Data("Work", 3));
        //series1.getData().add(new XYChart.Data("Reading", 10));
        
       // DailyChart.getData().addAll(series1); 
        try{
            
            String weeklyQuery = "SELECT CATEGORY, SUM(DURATION) from ENTRIES"
                    + " WHERE STARTTIME BETWEEN datetime ('now', '-6 days') AND datetime ('now', 'localtime')"
                    + " GROUP BY CATEGORY ORDER BY CATEGORY asc;";
            
            XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
            
            ResultSet rs2 = d.getResultSet(weeklyQuery);
            series2.setName("Time Spent");
            
            while (rs2.next()){
            String category = rs2.getString(1);
            int hours = rs2.getInt(2);
            series2.getData().add(new XYChart.Data<>(category, hours));
        }
            WeeklyChart.getData().addAll(series2);
            
            
            Node n = WeeklyChart.lookup(".data0.chart-bar");
    n.setStyle("-fx-bar-fill: #02e04c");
    n = WeeklyChart.lookup(".data1.chart-bar");
    n.setStyle("-fx-bar-fill: #00f3ba");
    n = WeeklyChart.lookup(".data2.chart-bar");
    n.setStyle("-fx-bar-fill: #48ffff");
    n = WeeklyChart.lookup(".data3.chart-bar");
    n.setStyle("-fx-bar-fill: #00aaff");
     n = WeeklyChart.lookup(".data4.chart-bar");
    n.setStyle("-fx-bar-fill: #8402c4");
            
            
            
        }catch(Exception e){
            
        }
        
        
       // XYChart.Series series2 = new XYChart.Series();
        //series2.setName("Time Spent");
       // series2.getData().add(new XYChart.Data("Study",99));
       // series2.getData().add(new XYChart.Data("Relax", 50));
       // series2.getData().add(new XYChart.Data("Work", 20));
        
       // WeeklyChart.getData().addAll(series2); 
        
        try{
             String pieQuery = "SELECT CATEGORY, SUM(DURATION) from ENTRIES"
                    + " GROUP BY CATEGORY ORDER BY CATEGORY asc;";
             
             
             ResultSet rs3 = d.getResultSet(pieQuery);
             
             ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(); 
              
             while (rs3.next()){
                  String category = rs3.getString(1);
                  int hours = rs3.getInt(2);
                  pieChartData.add(new PieChart.Data(category, hours));
              }
              
              PieChart.setData(pieChartData);
              
              String[] pieColors = {"#02e04c", "#00f3ba", "#48ffff", "#00aaff", "#8402c4"};
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
        }catch(Exception e){
            
        }
       
      
        
    }
}