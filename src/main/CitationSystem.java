/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import citation.CitationView;
import citation.CitationModel;
import citation.CitationController;
import javafx.scene.layout.BorderPane;
/**
 *
 * @author Kayla
 */
public class CitationSystem extends Application {
    
    CitationView citeView = new CitationView(); 
    CitationModel citeModel = new CitationModel();
    CitationController cc = new CitationController(citeModel, citeView);
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Scene scene = new Scene(citeView, 1500, 1000);
        
        primaryStage.setTitle("Citation System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
