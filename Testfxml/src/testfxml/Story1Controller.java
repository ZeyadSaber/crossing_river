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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.event.MenuEvent;

import controller.Controller;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class Story1Controller implements Initializable {

    @FXML
    private Label Storyname;
    @FXML
    private Button Back1;
    @FXML
    private Button Newgame1;
    @FXML
    private Button Loadgame1;
    private static boolean isLoad;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       

    }
    
    public static boolean isLoad() {
    	return isLoad;
    }

    public void Newgame(ActionEvent event) throws IOException {
    	isLoad = false;
        try {
            Parent loader =FXMLLoader.load(getClass().getResource("Story1Game.fxml"));

            Scene scene = new Scene(loader);

            Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            App_stage.setScene(scene);
            App_stage.show();
             App_stage.setResizable(false);

        } catch (Exception e) {
            System.out.println("Error Loading Game");
            e.printStackTrace();
        }
    }

     public void Loadgame(ActionEvent event) throws IOException {
    	 isLoad = true;
         Controller.getInstance().loadGame();
         try {
             Parent loader =FXMLLoader.load(getClass().getResource("Story1Game.fxml"));

             Scene scene = new Scene(loader);

             Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

             App_stage.setScene(scene);
             App_stage.show();
              App_stage.setResizable(false);

         } catch (Exception e) {
             System.out.println("Error Loading Game");
             e.printStackTrace();
         }
//         System.out.println(Controller.getInstance().getNumberOfSails());
//         System.out.println(Controller.getInstance().getCrossersOnLeftBank().size());
     }
    
    public void Back(ActionEvent e) throws IOException {
        Parent Puzzle = FXMLLoader.load(getClass().getResource("menu1.fxml"));
        Scene Puzzle_scene = new Scene(Puzzle);
        Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        App_stage.setScene(Puzzle_scene);
        App_stage.show();
         App_stage.setResizable(false);
    }

}
