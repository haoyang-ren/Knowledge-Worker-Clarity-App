/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Database d = new Database();

        
       // try {

            //String weeklyQuery =// "SELECT CATEGORY, DURATION, DATE(ENDTIME) FROM ENTRIES;";
                  //  + " WHERE STARTTIME BETWEEN datetime ('now', '-6 days') AND datetime ('now', 'localtime')"
                   // + " GROUP BY CATEGORY ORDER BY CATEGORY asc;";  
                   // "SELECT CATEGORY, DURATION"
           // System.out.println("Done");
            XYChart.Series series = new XYChart.Series();
            //ResultSet rs = d.getResultSet(weeklyQuery);
            series.setName("Procrastinating");
            series.getData().add(new XYChart.Data("2019/11/18", 25));
            series.getData().add(new XYChart.Data("2019/11/25", 20));
            series.getData().add(new XYChart.Data("2019/12/2", 45));
            series.getData().add(new XYChart.Data("2019/12/9", 20));
            series.getData().add(new XYChart.Data("2019/12/16", 5));
            series.getData().add(new XYChart.Data("2019/12/23", 25));
            
            XYChart.Series series3 = new XYChart.Series();
            series3.setName("Social activity");
            series3.getData().add(new XYChart.Data("2019/11/18", 20));
            series3.getData().add(new XYChart.Data("2019/11/25", 5));
            series3.getData().add(new XYChart.Data("2019/12/2", 35));
            series3.getData().add(new XYChart.Data("2019/12/9", 35));
            series3.getData().add(new XYChart.Data("2019/12/16", 60));
            series3.getData().add(new XYChart.Data("2019/12/23", 70));
            
            XYChart.Series series2 = new XYChart.Series();
            series2.setName("Studying");
            series2.getData().add(new XYChart.Data("2019/11/18", 55));
            series2.getData().add(new XYChart.Data("2019/11/25", 75));
            series2.getData().add(new XYChart.Data("2019/12/2", 25));
            series2.getData().add(new XYChart.Data("2019/12/9", 45));
            series2.getData().add(new XYChart.Data("2019/12/16", 35));
            series2.getData().add(new XYChart.Data("2019/12/23", 5));
            //while (rs.next()){
            //series.setName(rs.getString(1));
            //String category = rs.getString(1);
            //String hours = rs.getString(2);
            //String week = rs.getString(3);
            //series.getData().add(new XYChart.Data<>(hours, week));
              //  System.out.println("");
            //}
            //WeeklyTrends.getData().addAll(series);
             //} catch (SQLException ex) {
            //Logger.getLogger(WeeklyTrendsController.class.getName()).log(Level.SEVERE, null, ex);
       // }
            WeeklyTrends.getData().addAll(series);
            WeeklyTrends.getData().addAll(series2);
            WeeklyTrends.getData().addAll(series3);
       // }catch(Exception e){
            
        }
}
                   

         //   series.getData().add(new XYChart.Data("1", 23));
           // series.getData().add(new XYChart.Data("2", 24));
            //series.setName("Studying");

           // XYChart.Series series1 = new XYChart.Series();

            //series1.getData().add(new XYChart.Data("1", 15));
            //series1.getData().add(new XYChart.Data("2", 12));
            //series1.setName("Procrastinating");
            //WeeklyTrends.getData().addAll(series, series1);

        

    //}
