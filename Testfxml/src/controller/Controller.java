package controller;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import testfxml.ICrosser;
import testfxml.ICrossingStrategy;
import testfxml.IRiverCrossingController;

public class Controller implements IRiverCrossingController {

	private static Controller controller;

	protected ICrossingStrategy gameStrategy;
	protected List<ICrosser> leftBank=new ArrayList<ICrosser>();
	protected List<ICrosser> rightBank = new ArrayList<ICrosser>();
	protected List<ICrosser> onBoat = new ArrayList<ICrosser>();


	protected int sails=0;
	protected boolean boatOnLeft,canUndo,canRedo;
	private Save save = new Save();
	private Load load = new Load();
	private Button proccess;

	private Controller() {}
	
	public static Controller getInstance() {
		if(controller == null)
			controller = new Controller();
		return controller;
	}
	public void newGame(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		resetGame();
	}

	@Override
	public void resetGame() {
		sails=0;
		boatOnLeft = true;
		canUndo = false;
		canRedo = false;
		leftBank = gameStrategy.getInitialCrossers();
		onBoat.clear();
		rightBank.clear();
	}

	@Override
	public String[] getInstructions() {
		return gameStrategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return rightBank;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return leftBank;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return boatOnLeft;
	}

	@Override
	public int getNumberOfSails() {
		return sails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if(fromLeftToRightBank) {
			leftBank.removeAll(crossers);
		}else {
			rightBank.removeAll(crossers);
		}
		onBoat.addAll(crossers);
		if(gameStrategy.isValid(rightBank, leftBank, onBoat)) {
			this.doMove(crossers, fromLeftToRightBank);
			return true;
		}else {
			onBoat.removeAll(crossers);
			if(fromLeftToRightBank) {
				leftBank.addAll(crossers);
			}else {
				rightBank.addAll(crossers);
			}
			return false;
		}
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		sails++;
		canUndo = true;
		onBoat.removeAll(crossers);
		if(fromLeftToRightBank) {
			rightBank.addAll(crossers);
			boatOnLeft = false;
		}else {
			leftBank.addAll(crossers);
			boatOnLeft = true;
		}
		if(fromLeftToRightBank)
			boatOnLeft = false;
		else
			boatOnLeft = true;
	}

	@Override
	public boolean canUndo() {
		return canUndo;
	}

	@Override
	public boolean canRedo() {
		return canRedo;
	}

	@Override
	public void undo() {
		canRedo = true;
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {
		proccess = new Button(save);
		
	}

	@Override
	public void loadGame() {
		proccess = new Button(load);
	}


	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
