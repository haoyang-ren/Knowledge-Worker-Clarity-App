/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.Learning;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

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
    private ComboBox<String> wellComboBox;
    
    @FXML
    private Button confirmButton;
    
    @FXML
    private ListView<String> doneWellList;
    
    @FXML
    private ListView<Integer> countList;
    
    @FXML
    private ListView<String> doBetterList;
    
    @FXML
    private ListView<Integer> countList2;
            
    PageSwitcher pageSwitcher = new PageSwitcher();
    Database d = new Database();
    
    @FXML
    void handleBackButtonAction(ActionEvent event) throws IOException {
          pageSwitcher.switcher(event, "Dashboard.fxml");          
    }
    
    @FXML
    void handleConfirmButtonAction(ActionEvent event) throws IOException{
        String doneWellInput = wellComboBox.getValue();
        String doBetterInput = betterComboBox.getValue();
        
        try{
        d.insertLearning(doneWellInput, doBetterInput);
        }catch (Exception e){
        
        }
        
        
    }
    
    @FXML
    void handleReportButtonAction(ActionEvent event) throws IOException{
        
        doneWellList.getItems().clear();
        doBetterList.getItems().clear();
        countList.getItems().clear();
        countList2.getItems().clear();
        
        try{
        
        String query = "SELECT DONEWELL, COUNT(DONEWELL) as c from DailyLearnings"
                + " WHERE DATE BETWEEN datetime('now', '-30 days') AND datetime ('now', 'localtime')"
                + "GROUP BY DONEWELL ORDER BY c desc;";
        
       // TODO
        //XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
         
        ResultSet rs = d.getResultSet(query);
        
        while(rs.next()){
            doneWellList.getItems().add(rs.getString(1)); 
            countList.getItems().add(rs.getInt(2));
        }
        
        String query2 = "SELECT DOBETTER, COUNT(DOBETTER) as count from DailyLearnings"
                + " WHERE DATE BETWEEN datetime('now', '-30 days') AND datetime ('now', 'localtime')"
                + "GROUP BY DOBETTER ORDER BY count desc;";
        
        ResultSet rs2 = d.getResultSet(query2);
        
        while(rs2.next()){
            doBetterList.getItems().add(rs2.getString(1));
            countList2.getItems().add(rs2.getInt(2));
        }
        //series1.setName("No. of times past 30 days");
                
        //while (rs.next()){
       //     String learning = rs.getString(1);
        //    int days = rs.getInt(2);
         //   series1.getData().add(new XYChart.Data<>(learning, days));
       // }
       // doneWellChart.getData().addAll(series1);
       }catch (Exception e){
      //  }
    }
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
    
                String doneWellQuery = "SELECT DONEWELL from DailyLearnings "
                         + "GROUP BY DONEWELL ORDER BY DONEWELL asc; ";
    
                ResultSet rs = d.getResultSet(doneWellQuery);
    
                ObservableList<String> wellList = FXCollections.observableArrayList();
                   
              while(rs.next()){
                   String doneWell = rs.getString(1);
                  wellList.add(doneWell);
                }
                
                
                wellComboBox.setItems(wellList);
                
        }catch(Exception e){
            e.printStackTrace();
    
    }
        try {
    
                String doBetterQuery = "SELECT DOBETTER from DailyLearnings "
                         + "GROUP BY DOBETTER ORDER BY DOBETTER asc; ";
    
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
