/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class Story2GamePlayController implements Initializable {

    @FXML
    private Button Menuofstory2; //return to menu of story 1 without saving
    @FXML
    private Button Savestory2;//save
    @FXML
    private Button moveboat2;//move
    @FXML
    private Button Redo;//redo
    @FXML
    private Button Undo;//undo
    @FXML
    private Button Resetstory2;//restart

    @FXML
    private ImageView farmer1;
    @FXML
    private ImageView farmer1Right;
    @FXML
    private ImageView farmer2;
    @FXML
    private ImageView farmer2Right;
    @FXML
    private ImageView farmer3;
    @FXML
    private ImageView farmer3Right;
    @FXML
    private ImageView farmer4;
    @FXML
    private ImageView farmer4Right;
    @FXML
    private ImageView animal;
    @FXML
    private ImageView animalRight;
    @FXML
    private ImageView boatPassenger1;//passenger 1 leftside
    @FXML
    private ImageView boatPassenger2;//passenger 2 leftside
    @FXML
    private ImageView boatPassenger1Right;//passenger 1 rightside
    @FXML
    private ImageView boatPassenger2Right;//passenger 2 rightside
    @FXML
    private ImageView boatLeft;
    @FXML
    private ImageView boatRight;

    @FXML
    private Label Story2Alerts;//label to show alerts of wrong moves
    @FXML
    private Label Story2instructions;//label to show instructions of story
    @FXML
    private Label Score;//label to show number of moves made
    
    private List<ICrosser> crossers;
    private List<ICrosser> onBoat = new ArrayList<ICrosser>();
    private List<ICrosser> crossersR = new ArrayList<ICrosser>();
    private boolean pass1empty, pass2empty;
    private Image f1, f2, f3, f4,an,f1right,f2right,f3right,f4right,anright;
    private Controller cont;
    private ICrosser far1, far2, far3, far4,ani;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
    	if(!Story2Controller.isLoad()) {
    	pass1empty = true;
        pass2empty = true;

        cont = Controller.getInstance();
        cont.newGame(new Story2());
        crossers = cont.getCrossersOnLeftBank();
        far1 = crossers.get(0);
        far2 = crossers.get(2);
        far3 = crossers.get(1);
        far4 = crossers.get(3);
        ani = crossers.get(4);
        f1 = SwingFXUtils.toFXImage(far1.getImages()[1], null);
        f1right = SwingFXUtils.toFXImage(far1.getImages()[6], null);
        f2 = SwingFXUtils.toFXImage(far2.getImages()[2], null);
        f2right = SwingFXUtils.toFXImage(far2.getImages()[7], null);
        f3 = SwingFXUtils.toFXImage(far3.getImages()[3], null);
        f3right = SwingFXUtils.toFXImage(far3.getImages()[8], null);
        f4 = SwingFXUtils.toFXImage(far4.getImages()[4], null);
        f4right = SwingFXUtils.toFXImage(far4.getImages()[9], null);
        an = SwingFXUtils.toFXImage(ani.getImages()[0], null);
        anright = SwingFXUtils.toFXImage(ani.getImages()[1], null);

        farmer1.setImage(f1);
        farmer2.setImage(f2);
        farmer3.setImage(f3);
        farmer4.setImage(f4);
        animal.setImage(an);
    	}else {
            cont = Controller.getInstance();
            crossers = cont.getCrossersOnLeftBank();
            crossersR = cont.getCrossersOnRightBank();
            pass1empty = pass2empty = true;
    		for(int i=0;i<cont.getCrossersOnLeftBank().size();i++) {
    			if(crossers.get(i).getWeight() == 90) {
    				far1 = crossers.get(i);
    				f1 = SwingFXUtils.toFXImage(far1.getImages()[1], null);
    		    	f1right = SwingFXUtils.toFXImage(far1.getImages()[6], null);
    		        farmer1.setImage(f1);
    			}else if(crossers.get(i).getWeight() == 80) {
    				far2 = crossers.get(i);
    				f2 = SwingFXUtils.toFXImage(far2.getImages()[2], null);
    		    	f2right = SwingFXUtils.toFXImage(far2.getImages()[7], null);
    		        farmer2.setImage(f2);
    			}else if(crossers.get(i).getWeight() == 20) {
    		        ani = crossers.get(i);
    		    	an = SwingFXUtils.toFXImage(ani.getImages()[0], null);
    		    	anright = SwingFXUtils.toFXImage(ani.getImages()[1], null);
    		        animal.setImage(an);
    			}else if(crossers.get(i).getWeight() == 60){
    		        far3 = crossers.get(i);
    		     	f3 = SwingFXUtils.toFXImage(far3.getImages()[3], null);
    		    	f3right = SwingFXUtils.toFXImage(far3.getImages()[8], null);
    		        farmer3.setImage(f3);
    			}else {
    				far4 = crossers.get(i);
    				f4 = SwingFXUtils.toFXImage(far4.getImages()[4], null);
    				f4right = SwingFXUtils.toFXImage(far4.getImages()[9], null);
    				farmer4.setImage(f4);
    			}
    		}
    		for(int i=0;i<cont.getCrossersOnRightBank().size();i++) {
    			if(crossersR.get(i).getWeight() == 90) {
    				far1 = crossersR.get(i);
    				f1 = SwingFXUtils.toFXImage(far1.getImages()[1], null);
    		    	f1right = SwingFXUtils.toFXImage(far1.getImages()[6], null);
    		        farmer1Right.setImage(f1right);
    			}else if(crossersR.get(i).getWeight() == 80) {
    				far2 = crossersR.get(i);
    				f2 = SwingFXUtils.toFXImage(far2.getImages()[2], null);
    		    	f2right = SwingFXUtils.toFXImage(far2.getImages()[7], null);
    		        farmer2Right.setImage(f2right);
    			}else if(crossersR.get(i).getWeight() == 20) {
    		        ani = crossersR.get(i);
    		    	an = SwingFXUtils.toFXImage(ani.getImages()[0], null);
    		    	anright = SwingFXUtils.toFXImage(ani.getImages()[1], null);
    		        animalRight.setImage(anright);
    			}else if(crossersR.get(i).getWeight() == 60){
    		        far3 = crossersR.get(i);
    		     	f3 = SwingFXUtils.toFXImage(far3.getImages()[3], null);
    		    	f3right = SwingFXUtils.toFXImage(far3.getImages()[8], null);
    		        farmer3Right.setImage(f3right);
    			}else {
    				far4 = crossersR.get(i);
    				f4 = SwingFXUtils.toFXImage(far4.getImages()[4], null);
    				f4right = SwingFXUtils.toFXImage(far4.getImages()[9], null);
    				farmer4Right.setImage(f4right);
    			}
    		}
    		
    	}
    	if(!cont.isBoatOnTheLeftBank()) {
       		farmer1Right.setDisable(false);
       		farmer1Right.setDisable(false);
       		farmer1Right.setDisable(false);
       		farmer1Right.setDisable(false);
       		animalRight.setDisable(false);
    		farmer1.setDisable(true);
    		farmer2.setDisable(true);
    		farmer3.setDisable(true);
    		farmer4.setDisable(true);
    		animal.setDisable(true);
    		boatRight.setImage(boatLeft.getImage());
    		boatLeft.setImage(null);
    	}else {
       		farmer1Right.setDisable(true);
       		farmer1Right.setDisable(true);
       		farmer1Right.setDisable(true);
       		farmer1Right.setDisable(true);
       		animalRight.setDisable(true);
    		farmer1.setDisable(false);
    		farmer2.setDisable(false);
    		farmer3.setDisable(false);
    		farmer4.setDisable(false);
    		animal.setDisable(false);
    	}
    	Score.setText(Integer.toString(cont.getNumberOfSails()));
        Story2instructions.setText(cont.getInstructions()[0]);   
    }
    
    public void Save(MouseEvent e) throws IOException{
    	cont.saveGame();
    	System.out.println("State Saved");
    }
    
    public void movetoLeft1(MouseEvent e) throws IOException {
        if (boatPassenger1.getImage() == f1 || boatPassenger1.getImage() == f1right) {
            farmer1.setImage(f1);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(far1);
            crossers.add(far1);
            farmer1.setDisable(false);
        } else if (boatPassenger1.getImage() == f2 || boatPassenger1.getImage() == f2right) {
            farmer2.setImage(f2);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(far2);
            crossers.add(far2);
            farmer2.setDisable(false);
        } else if (boatPassenger1.getImage() == f3 || boatPassenger1.getImage() == f3right) {
            farmer3.setImage(f3);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(far3);
            crossers.add(far3);
            farmer3.setDisable(false);
        } else if (boatPassenger1.getImage() == f4 || boatPassenger1.getImage() == f4right) {
            farmer4.setImage(f4);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(far4);
            crossers.add(far4);
            farmer4.setDisable(false);
        }
        else {
            animal.setImage(an);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(ani);
            crossers.add(ani);
            animal.setDisable(false);
        }
    }
    
    public void movetoLeft2(MouseEvent e) throws IOException {
        if (boatPassenger2.getImage() == f1 || boatPassenger2.getImage() == f1right) {
            farmer1.setImage(f1);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(far1);
            crossers.add(far1);
            farmer1.setDisable(false);
        } else if (boatPassenger2.getImage() == f2 || boatPassenger2.getImage() == f2right) {
            farmer2.setImage(f2);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(far2);
            crossers.add(far2);
            farmer2.setDisable(false);
        } else if (boatPassenger2.getImage() == f3 || boatPassenger2.getImage() == f3right) {
            farmer3.setImage(f3);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(far3);
            crossers.add(far3);
            farmer3.setDisable(false);
        } else if (boatPassenger2.getImage() == f4 || boatPassenger2.getImage() == f4right) {
            farmer4.setImage(f4);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(far4);
            crossers.add(far4);
            farmer4.setDisable(false);
        }
        else {
            animal.setImage(an);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(ani);
            crossers.add(ani);
            animal.setDisable(false);
        }
    }
     
    public void movefarmer1toboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
    	
        if (pass1empty) {
            boatPassenger1.setImage(f1);
            pass1empty = false;
            farmer1.setImage(null);
            farmer1.setDisable(true);
            crossers.remove(far1);
            onBoat.add(far1);
        } else if (pass2empty) {
            boatPassenger2.setImage(f1);
            pass2empty = false;
            farmer1.setImage(null);
            farmer1.setDisable(true);
            crossers.remove(far1);
            onBoat.add(far1);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {

            if (pass1empty) {
                boatPassenger1Right.setImage(f1right);
                pass1empty = false;
                farmer1Right.setImage(null);
                farmer1Right.setDisable(true);
                crossersR.remove(far1);
                onBoat.add(far1);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(f1right);
                pass2empty = false;
                farmer1Right.setImage(null);
                farmer1Right.setDisable(true);
                crossersR.remove(far1);
                onBoat.add(far1);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }
    
    public void movefarmer2toboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
    
        if (pass1empty) {
            boatPassenger1.setImage(f2);
            pass1empty = false;
            farmer2.setImage(null);
            farmer2.setDisable(true);
            crossers.remove(far2);
            onBoat.add(far2);
        } else if (pass2empty) {
            boatPassenger2.setImage(f2);
            pass2empty = false;
            farmer2.setImage(null);
            farmer2.setDisable(true);
            crossers.remove(far2);
            onBoat.add(far2);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
    	
            if (pass1empty) {
                boatPassenger1Right.setImage(f2right);
                pass1empty = false;
                farmer2Right.setImage(null);
                farmer2Right.setDisable(true);
                crossersR.remove(far2);
                onBoat.add(far2);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(f2right);
                pass2empty = false;
                farmer2Right.setImage(null);
                farmer2Right.setDisable(true);
                crossersR.remove(far2);
                onBoat.add(far2);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }
    
    public void movefarmer3toboat(MouseEvent e) throws IOException {
    	
    	if(cont.isBoatOnTheLeftBank()) {

        if (pass1empty) {
            boatPassenger1.setImage(f3);
            pass1empty = false;
            farmer3.setImage(null);
            farmer3.setDisable(true);
            crossers.remove(far3);
            onBoat.add(far3);
        } else if (pass2empty) {
            boatPassenger2.setImage(f3);
            pass2empty = false;
            farmer3.setImage(null);
            farmer3.setDisable(true);
            crossers.remove(far3);
            onBoat.add(far3);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
    
            if (pass1empty) {
                boatPassenger1Right.setImage(f3right);
                pass1empty = false;
                farmer3Right.setImage(null);
                farmer3Right.setDisable(true);
                crossersR.remove(far3);
                onBoat.add(far3);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(f3right);
                pass2empty = false;
                farmer3Right.setImage(null);
                farmer3Right.setDisable(true);
                crossersR.remove(far3);
                onBoat.add(far3);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }
    
    public void movefarmer4toboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
    
        if (pass1empty) {
            boatPassenger1.setImage(f4);
            pass1empty = false;
            farmer4.setImage(null);
            farmer4.setDisable(true);
            crossers.remove(far4);
            onBoat.add(far4);
        } else if (pass2empty) {
            boatPassenger2.setImage(f4);
            pass2empty = false;
            farmer4.setImage(null);
            farmer4.setDisable(true);
            crossers.remove(far4);
            onBoat.add(far4);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {

    		if (pass1empty) {
                boatPassenger1Right.setImage(f4right);
                pass1empty = false;
                farmer4Right.setImage(null);
                farmer4Right.setDisable(true);
                crossersR.remove(far4);
                onBoat.add(far4);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(f4right);
                pass2empty = false;
                farmer4Right.setImage(null);
                farmer4Right.setDisable(true);
                crossersR.remove(far4);
                onBoat.add(far4);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }
    
    public void moveAnimaltoboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
    		if (pass1empty) {
	            boatPassenger1.setImage(an);
	            pass1empty = false;
	            animal.setImage(null);
	            animal.setDisable(true);
	            crossers.remove(ani); 
	            onBoat.add(ani);
	        } else if (pass2empty) {
	            boatPassenger2.setImage(an);
	            pass2empty = false;
	            animal.setImage(null);
	            animal.setDisable(true);
	            crossers.remove(ani);
	            onBoat.add(ani);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
 
            if (pass1empty) {
                boatPassenger1Right.setImage(anright);
                pass1empty = false;
                animalRight.setImage(null);
                animalRight.setDisable(true);
                crossersR.remove(ani); 
                onBoat.add(ani);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(anright);
                pass2empty = false;
                animalRight.setImage(null);
                animalRight.setDisable(true);
                crossersR.remove(ani);
                onBoat.add(ani);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }
    
    public void Move(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
        if (cont.canMove(onBoat, cont.isBoatOnTheLeftBank())) {
        	farmer1Right.setDisable(false);
        	farmer2Right.setDisable(false);
        	farmer3Right.setDisable(false);
        	farmer4Right.setDisable(false);
        	animalRight.setDisable(false);
        	farmer1.setDisable(true);
        	farmer2.setDisable(true);
        	farmer3.setDisable(true);
        	farmer4.setDisable(true);
        	animal.setDisable(true);
            boatPassenger1Right.setImage(boatPassenger1.getImage());
            boatPassenger1.setImage(null);
            boatPassenger2Right.setImage(boatPassenger2.getImage());
            boatPassenger2.setImage(null);
            boatRight.setImage(boatLeft.getImage());
            boatLeft.setImage(null);
            Score.setText(Integer.toString(cont.getNumberOfSails()));
        } else{
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("Invalid move");
            error.showAndWait();
        }}else {

        	if(cont.canMove(onBoat, cont.isBoatOnTheLeftBank())) {
        		farmer1Right.setDisable(true);
        		farmer2Right.setDisable(true);
        		farmer3Right.setDisable(true);
        		farmer4Right.setDisable(true);
        		animalRight.setDisable(true);
        		farmer1.setDisable(false);
        		farmer2.setDisable(false);
        		farmer3.setDisable(false);
        		farmer4.setDisable(false);
        		animal.setDisable(false);
                boatPassenger1.setImage(boatPassenger1Right.getImage());
                boatPassenger1Right.setImage(null);
                boatPassenger2.setImage(boatPassenger2Right.getImage());
                boatPassenger2Right.setImage(null);
                boatLeft.setImage(boatRight.getImage());
                boatRight.setImage(null);
                Score.setText(Integer.toString(cont.getNumberOfSails()));
           } else{
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("Invalid move");
                error.showAndWait();
        }
        }
    	
    }
    
    public void MoveToRight1(MouseEvent e) throws IOException{
        if (boatPassenger1Right.getImage() == f1 || boatPassenger1Right.getImage() == f1right) {
            farmer1Right.setImage(f1right);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(far1);
            crossersR.add(far1);
            farmer1Right.setDisable(false);
        } else if (boatPassenger1Right.getImage() == f2 || boatPassenger1Right.getImage() == f2right) {
            farmer2Right.setImage(f2right);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(far2);
            crossersR.add(far2);
            farmer2Right.setDisable(false);
        } else if (boatPassenger1Right.getImage() == f3 || boatPassenger1Right.getImage() == f3right) {
            farmer3Right.setImage(f3right);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(far3);
            crossersR.add(far3);
            farmer3Right.setDisable(false);
        } else if (boatPassenger1Right.getImage() == f4 || boatPassenger1Right.getImage() == f4right) {
            farmer4Right.setImage(f4right);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(far4);
            crossersR.add(far4);
            farmer4Right.setDisable(false);
        }
        else {
            animalRight.setImage(anright);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(ani);
            crossersR.add(ani);
            animalRight.setDisable(false);
        }
        if(onBoat.isEmpty() && crossers.isEmpty()) {
        	Alert win = new Alert(AlertType.INFORMATION);
        	win.setContentText("YOU WIN !");
        	win.show();
        }
    }
    
    public void MoveToRight2(MouseEvent e) throws IOException{
        if (boatPassenger2Right.getImage() == f1 || boatPassenger2Right.getImage() == f1right) {
            farmer1Right.setImage(f1right);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(far1);
            crossersR.add(far1);
            farmer1Right.setDisable(false);
        } else if (boatPassenger2Right.getImage() == f2 || boatPassenger2Right.getImage() == f2right) {
            farmer2Right.setImage(f2right);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(far2);
            crossersR.add(far2);
            farmer2Right.setDisable(false);
        } else if (boatPassenger2Right.getImage() == f3 || boatPassenger2Right.getImage() == f3right) {
            farmer3Right.setImage(f3right);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(far3);
            crossersR.add(far3);
            farmer3Right.setDisable(false);
        } else if (boatPassenger2Right.getImage() == f4 || boatPassenger2Right.getImage() == f4right) {
            farmer4Right.setImage(f4right);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(far4);
            crossersR.add(far4);
            farmer4Right.setDisable(false);
        }
        else {
            animalRight.setImage(anright);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(ani);
            crossersR.add(ani);
            animalRight.setDisable(false);
        }
        if(onBoat.isEmpty() && crossers.isEmpty()) {
        	Alert win = new Alert(AlertType.INFORMATION);
        	win.setContentText("YOU WIN !");
        	win.show();
        }
    }
    
    public void Restart(ActionEvent e) throws IOException{
    	cont.resetGame();
        try {
            Parent loader =FXMLLoader.load(getClass().getResource("Story2Game.fxml"));

            Scene scene = new Scene(loader);

            Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            App_stage.setScene(scene);
            App_stage.show();
             App_stage.setResizable(false);

        } catch (Exception x) {
            System.out.println("Error Loading Game");
            x.printStackTrace();
        }
    }
    public void Mainmenu(ActionEvent e) throws IOException {
        Parent Puzzle = FXMLLoader.load(getClass().getResource("Story22.fxml"));
        Scene Puzzle_scene = new Scene(Puzzle);
        Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        App_stage.setScene(Puzzle_scene);
        App_stage.show();
        App_stage.setResizable(false);

    }

    public void movefarmertoRight(MouseEvent e) throws IOException {
        //gc.drawImage(farmer1,569 , 622);
    }
}
