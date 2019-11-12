/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author calvinkoder
 */
public class Dashboard extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
        loadDatabase();
        
 
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        
         
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
    private void loadDatabase() throws IOException, ClassNotFoundException {
       //TODO: Call Database methods here to create the database
       Database d = new Database();
        try{
            Database.connect();
            d.insertDummyData();
             
        } catch (SQLException createTableException) {
            System.err.println(createTableException);
       
       
       
    }
    }
}

