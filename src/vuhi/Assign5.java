/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuhi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hieud
 */
public class Assign5 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLassign5.fxml"));
        root.getStylesheets().add(getClass().getResource("fxmlassign5.css").toExternalForm());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Assign5");
        stage.show();
        
    }
    
}
