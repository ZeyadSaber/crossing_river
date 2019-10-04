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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class Story1GamePlayController implements Initializable {

    @FXML
    private Button Menuofstory1; //return to menu of story 1 without saving
    @FXML
    private Button Savestory1;//save
    @FXML
    private Button moveboat1;//move
    @FXML
    private Button Redo;//redo
    @FXML
    private Button Undo;//undo
    @FXML
    private Button Resetstory1;//restart

    @FXML
    private ImageView farmerLeft;
    @FXML
    private ImageView farmerRight;
    @FXML
    private ImageView carnevorLeft;
    @FXML
    private ImageView carnevorRight;
    @FXML
    private ImageView herbevorLeft;
    @FXML
    private ImageView herbevorRight;
    @FXML
    private ImageView plantLeft;
    @FXML
    private ImageView plantRight;
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
    private Label Story1Alerts;//label to show alerts of wrong moves
    @FXML
    private Label Story1instructions;//label to show instructions of story
    @FXML
    private Label Score;//label to show number of moves made

    private List<ICrosser> crossers;
    private List<ICrosser> onBoat = new ArrayList<ICrosser>();
    private List<ICrosser> crossersR = new ArrayList<ICrosser>();
    private boolean pass1empty, pass2empty;
    private Image plant, image, herb, carn,fright,pright,cright,hright;
    private Controller cont;
    private ICrosser f, p, c, h;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	if(!Story1Controller.isLoad()) {
	        pass1empty = true;
	        pass2empty = true;
	
	        cont = Controller.getInstance();
	        cont.newGame(new Story1());
	        crossers = cont.getCrossersOnLeftBank();
	        f = crossers.get(0);
	        p = crossers.get(2);
	        c = crossers.get(1);
	        h = crossers.get(3);
	    	image = SwingFXUtils.toFXImage(f.getImages()[0], null);
	    	fright = SwingFXUtils.toFXImage(f.getImages()[5], null);
	    	herb = SwingFXUtils.toFXImage(h.getImages()[0], null);
	    	hright = SwingFXUtils.toFXImage(h.getImages()[1], null);
	    	carn = SwingFXUtils.toFXImage(c.getImages()[0], null);
	    	cright = SwingFXUtils.toFXImage(c.getImages()[1], null);
	    	plant = SwingFXUtils.toFXImage(p.getImages()[0], null);
	    	pright = SwingFXUtils.toFXImage(p.getImages()[1], null);
	        farmerLeft.setImage(image);
	        herbevorLeft.setImage(herb);
	        carnevorLeft.setImage(carn);
	        plantLeft.setImage(plant);
    	}else {
            cont = Controller.getInstance();
            crossers = cont.getCrossersOnLeftBank();
            crossersR = cont.getCrossersOnRightBank();
            pass1empty = pass2empty = true;
    		for(int i=0;i<cont.getCrossersOnLeftBank().size();i++) {
    			if(crossers.get(i).getEatingRank() == 4) {
    				f = crossers.get(i);
    				image = SwingFXUtils.toFXImage(f.getImages()[0], null);
    		    	fright = SwingFXUtils.toFXImage(f.getImages()[5], null);
    		        farmerLeft.setImage(image);
    			}else if(crossers.get(i).getEatingRank() == 2) {
    				c = crossers.get(i);
    				carn = SwingFXUtils.toFXImage(c.getImages()[0], null);
    		    	cright = SwingFXUtils.toFXImage(c.getImages()[1], null);
    		        carnevorLeft.setImage(carn);
    			}else if(crossers.get(i).getEatingRank() == 1) {
    		        h = crossers.get(i);
    		    	herb = SwingFXUtils.toFXImage(h.getImages()[0], null);
    		    	hright = SwingFXUtils.toFXImage(h.getImages()[1], null);
    		        herbevorLeft.setImage(herb);
    			}else {
    		        p = crossers.get(i);
    		     	plant = SwingFXUtils.toFXImage(p.getImages()[0], null);
    		    	pright = SwingFXUtils.toFXImage(p.getImages()[1], null);
    		        plantLeft.setImage(plant);
    			}
    		}
    		for(int i=0;i<cont.getCrossersOnRightBank().size();i++) {
    			if(crossersR.get(i).getEatingRank() == 4) {
    				f = crossersR.get(i);
    				image = SwingFXUtils.toFXImage(f.getImages()[0], null);
    		    	fright = SwingFXUtils.toFXImage(f.getImages()[5], null);
    		        farmerRight.setImage(fright);
    			}else if(crossersR.get(i).getEatingRank() == 2) {
    				c = crossersR.get(i);
    				carn = SwingFXUtils.toFXImage(c.getImages()[0], null);
    		    	cright = SwingFXUtils.toFXImage(c.getImages()[1], null);
    		        carnevorRight.setImage(cright);
    			}else if(crossersR.get(i).getEatingRank() == 1) {
    		        h = crossersR.get(i);
    		    	herb = SwingFXUtils.toFXImage(h.getImages()[0], null);
    		    	hright = SwingFXUtils.toFXImage(h.getImages()[1], null);
    		        herbevorRight.setImage(hright);
    			}else {
    		        p = crossersR.get(i);
    		     	plant = SwingFXUtils.toFXImage(p.getImages()[0], null);
    		    	pright = SwingFXUtils.toFXImage(p.getImages()[1], null);
    		        plantRight.setImage(pright);
    			}
    		}
    		
    	}
    	if(!cont.isBoatOnTheLeftBank()) {
       		farmerRight.setDisable(false);
    		plantRight.setDisable(false);
    		herbevorRight.setDisable(false);
    		carnevorRight.setDisable(false);
    		farmerLeft.setDisable(true);
    		plantLeft.setDisable(true);
    		herbevorLeft.setDisable(true);
    		carnevorLeft.setDisable(true);
    		boatRight.setImage(boatLeft.getImage());
    		boatLeft.setImage(null);
    	}else {
    		farmerRight.setDisable(true);
    		plantRight.setDisable(true);
    		herbevorRight.setDisable(true);
    		carnevorRight.setDisable(true);
    		farmerLeft.setDisable(false);
    		plantLeft.setDisable(false);
    		herbevorLeft.setDisable(false);
    		carnevorLeft.setDisable(false);
    	}
    	Score.setText(Integer.toString(cont.getNumberOfSails()));
    	Story1instructions.setText(cont.getInstructions()[0]);
    }


    public void movetoLeft1(MouseEvent e) throws IOException {
        if (boatPassenger1.getImage() == image || boatPassenger1.getImage() == fright) {
            farmerLeft.setImage(image);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(f);
            crossers.add(f);
            farmerLeft.setDisable(false);
        } else if (boatPassenger1.getImage() == carn || boatPassenger1.getImage() == cright) {
            carnevorLeft.setImage(carn);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(c);
            crossers.add(c);
            carnevorLeft.setDisable(false);
        } else if (boatPassenger1.getImage() == plant || boatPassenger1.getImage() == pright) {
            plantLeft.setImage(plant);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(p);
            crossers.add(p);
            plantLeft.setDisable(false);
        } else {
            herbevorLeft.setImage(herb);
            boatPassenger1.setImage(null);
            pass1empty = true;
            onBoat.remove(h);
            crossers.add(h);
            herbevorLeft.setDisable(false);
        }
    }

    public void movetoLeft2(MouseEvent e) throws IOException {
        if (boatPassenger2.getImage() == image || boatPassenger2.getImage() == fright) {
            farmerLeft.setImage(image);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(f);
            crossers.add(f);
            farmerLeft.setDisable(false);
        } else if (boatPassenger2.getImage() == carn || boatPassenger2.getImage() == cright) {
            carnevorLeft.setImage(carn);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(c);
            crossers.add(c);
            carnevorLeft.setDisable(false);
        } else if (boatPassenger2.getImage() == plant || boatPassenger2.getImage() == pright) {
            plantLeft.setImage(plant);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(p);
            crossers.add(p);
            plantLeft.setDisable(false);
        } else {
            herbevorLeft.setImage(herb);
            boatPassenger2.setImage(null);
            pass2empty = true;
            onBoat.remove(h);
            crossers.add(h);
            herbevorLeft.setDisable(false);
        }
    }

    public void movefarmertoboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
        if (pass1empty) {
            boatPassenger1.setImage(image);
            pass1empty = false;
            farmerLeft.setImage(null);
            farmerLeft.setDisable(true);
            crossers.remove(f);
            onBoat.add(f);
        } else if (pass2empty) {
            boatPassenger2.setImage(image);
            pass2empty = false;
            farmerLeft.setImage(null);
            farmerLeft.setDisable(true);
            crossers.remove(f);
            onBoat.add(f);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
            if (pass1empty) {
                boatPassenger1Right.setImage(fright);
                pass1empty = false;
                farmerRight.setImage(null);
                farmerRight.setDisable(true);
                crossersR.remove(f);
                onBoat.add(f);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(fright);
                pass2empty = false;
                farmerRight.setImage(null);
                farmerRight.setDisable(true);
                crossersR.remove(f);
                onBoat.add(f);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }

    public void moveplanttoboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
        if (pass1empty) {
            boatPassenger1.setImage(plant);
            pass1empty = false;
            plantLeft.setImage(null);
            plantLeft.setDisable(true);
            crossers.remove(p);
            onBoat.add(p);
        } else if (pass2empty) {
            boatPassenger2.setImage(plant);
            pass2empty = false;
            plantLeft.setImage(null);
            plantLeft.setDisable(true);
            crossers.remove(p);
            onBoat.add(p);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
            if (pass1empty) {
                boatPassenger1Right.setImage(pright);
                pass1empty = false;
                plantRight.setImage(null);
                plantRight.setDisable(true);
                crossersR.remove(p);
                onBoat.add(p);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(pright);
                pass2empty = false;
                plantRight.setImage(null);
                plantRight.setDisable(true);
                crossersR.remove(p);
                onBoat.add(p);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }

    public void moveherbtoboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
        if (pass1empty) {
            boatPassenger1.setImage(herb);
            pass1empty = false;
            herbevorLeft.setImage(null);
            herbevorLeft.setDisable(true);
            crossers.remove(h); 
            onBoat.add(h);
        } else if (pass2empty) {
            boatPassenger2.setImage(herb);
            pass2empty = false;
            herbevorLeft.setImage(null);
            herbevorLeft.setDisable(true);
            crossers.remove(h);
            onBoat.add(h);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
            if (pass1empty) {
                boatPassenger1Right.setImage(hright);
                pass1empty = false;
                herbevorRight.setImage(null);
                herbevorRight.setDisable(true);
                crossersR.remove(h); 
                onBoat.add(h);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(hright);
                pass2empty = false;
                herbevorRight.setImage(null);
                herbevorRight.setDisable(true);
                crossersR.remove(h);
                onBoat.add(h);
            } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("You Can't Add More Crossers");
                error.showAndWait();
            }
    	}
    }

    public void movecarntoboat(MouseEvent e) throws IOException {
    	if(cont.isBoatOnTheLeftBank()) {
        if (pass1empty) {
            boatPassenger1.setImage(carn);
            pass1empty = false;
            carnevorLeft.setImage(null);
            carnevorLeft.setDisable(true);
            crossers.remove(c);
            onBoat.add(c);
        } else if (pass2empty) {
            boatPassenger2.setImage(carn);
            pass2empty = false;
            carnevorLeft.setImage(null);
            carnevorLeft.setDisable(true);
            crossers.remove(c);
            onBoat.add(c);
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("You Can't Add More Crossers");
            error.showAndWait();
        }
    	}else {
            if (pass1empty) {
                boatPassenger1Right.setImage(cright);
                pass1empty = false;
                carnevorRight.setImage(null);
                carnevorRight.setDisable(true);
                crossersR.remove(c);
                onBoat.add(c);
            } else if (pass2empty) {
                boatPassenger2Right.setImage(cright);
                pass2empty = false;
                carnevorRight.setImage(null);
                carnevorRight.setDisable(true);
                crossersR.remove(c);
                onBoat.add(c);
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
        	farmerRight.setDisable(false);
    		plantRight.setDisable(false);
    		herbevorRight.setDisable(false);
    		carnevorRight.setDisable(false);
    		farmerLeft.setDisable(true);
    		plantLeft.setDisable(true);
    		herbevorLeft.setDisable(true);
    		carnevorLeft.setDisable(true);
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
        }
        }else {
        	if(cont.canMove(onBoat, cont.isBoatOnTheLeftBank())) {
            	farmerRight.setDisable(true);
            	plantRight.setDisable(true);
            	herbevorRight.setDisable(true);
            	carnevorRight.setDisable(true);
            	farmerLeft.setDisable(false);
            	plantLeft.setDisable(false);
            	herbevorLeft.setDisable(false);
            	carnevorLeft.setDisable(false);
        		
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
        if (boatPassenger1Right.getImage() == image || boatPassenger1Right.getImage() == fright) {
            farmerRight.setImage(fright);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(f);
            crossersR.add(f);
            farmerRight.setDisable(false);
        } else if (boatPassenger1Right.getImage() == carn || boatPassenger1Right.getImage() == cright) {
            carnevorRight.setImage(cright);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(c);
            crossersR.add(c);
            carnevorRight.setDisable(false);
        } else if (boatPassenger1Right.getImage() == plant || boatPassenger1Right.getImage() == pright) {
            plantRight.setImage(pright);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(p);
            crossersR.add(p);
            plantRight.setDisable(false);
        } else {
            herbevorRight.setImage(hright);
            boatPassenger1Right.setImage(null);
            pass1empty = true;
            onBoat.remove(h);
            crossersR.add(h);
            herbevorRight.setDisable(false);
        }
        if(onBoat.isEmpty() && crossers.isEmpty()) {
        	Alert win = new Alert(AlertType.INFORMATION);
        	win.setContentText("YOU WIN !");
        	win.show();
        }
    }

    public void MoveToRight2(MouseEvent e) throws IOException {
    	if (boatPassenger2Right.getImage() == image || boatPassenger2Right.getImage() == fright) {
            farmerRight.setImage(fright);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(f);
            crossersR.add(f);
            farmerRight.setDisable(false);
        } else if (boatPassenger2Right.getImage() == carn || boatPassenger2Right.getImage() == cright) {
            carnevorRight.setImage(cright);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(c);
            crossersR.add(c);
            carnevorRight.setDisable(false);
        } else if (boatPassenger2Right.getImage() == plant || boatPassenger2Right.getImage() == pright) {
            plantRight.setImage(pright);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(p);
            crossersR.add(p);
            plantRight.setDisable(false);
        } else {
            herbevorRight.setImage(hright);
            boatPassenger2Right.setImage(null);
            pass2empty = true;
            onBoat.remove(h);
            crossersR.add(h);
            herbevorRight.setDisable(false);
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
            Parent loader =FXMLLoader.load(getClass().getResource("Story1Game.fxml"));

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
        Parent Puzzle = FXMLLoader.load(getClass().getResource("Story1.fxml"));
        Scene Puzzle_scene = new Scene(Puzzle);
        Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        App_stage.setScene(Puzzle_scene);
        App_stage.show();
        App_stage.setResizable(false);

    }
    
    public void Save(MouseEvent e) throws IOException{
    	cont.saveGame();
    	System.out.println("State Saved");
    }

}
