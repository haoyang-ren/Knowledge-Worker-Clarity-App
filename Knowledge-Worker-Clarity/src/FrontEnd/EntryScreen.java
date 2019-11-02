/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ryan
 */
public class EntryScreen extends Application { //TODO: What class do you need to extend?
    
    @Override
    public void start(Stage stage) throws Exception {
        //loadDatabase();
        //System.out.println("Starting now!");
        Parent root = FXMLLoader.load(getClass().getResource("Entries.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

    private void loadDatabase() throws SQLException {
       //TODO: Call Database methods here to create the database

       
    }
    
}
