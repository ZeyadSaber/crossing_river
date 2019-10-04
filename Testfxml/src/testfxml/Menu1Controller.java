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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class Menu1Controller implements Initializable {

    Stage App_stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Story1Entry(ActionEvent e) throws IOException {
        Parent Puzzle = FXMLLoader.load(getClass().getResource("Story1.fxml"));
        Scene Puzzle_scene = new Scene(Puzzle);
        App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        App_stage.setScene(Puzzle_scene);
        App_stage.show();
        App_stage.setResizable(false);

    }

    public void Story2Entry(ActionEvent e) throws IOException {
        Parent Puzzle = FXMLLoader.load(getClass().getResource("Story22.fxml"));
        Scene Puzzle_scene = new Scene(Puzzle);
        App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        App_stage.setScene(Puzzle_scene);
        App_stage.show();
        App_stage.setResizable(false);

    }

}
