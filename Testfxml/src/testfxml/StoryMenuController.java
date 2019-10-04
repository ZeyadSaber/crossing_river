/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StoryMenuController implements Initializable {

    @FXML
    private Button Closemenue;

    @FXML
    private Button SaveGame;

    @FXML
    private Button ReturnMainmenu;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    
    
    
     public void Mainmenu(ActionEvent e) throws IOException {
        Parent Puzzle = FXMLLoader.load(getClass().getResource("menu1.fxml"));
        Scene Puzzle_scene = new Scene(Puzzle);
        Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        App_stage.setScene(Puzzle_scene);
        App_stage.show();
        App_stage.setResizable(false);
         
    }
    
}
