package controller;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import testfxml.ICrosser;
import testfxml.ICrossingStrategy;

public class Load implements Command{
	public void execute(){
		Controller cont = Controller.getInstance();
		try {
			FileInputStream fls = new FileInputStream(new File("src/controller.xml"));
			XMLDecoder decoder = new XMLDecoder(fls);
			cont.gameStrategy = (ICrossingStrategy) decoder.readObject();
			List<ICrosser> readObject = (List<ICrosser>) decoder.readObject();
			cont.leftBank = readObject;
			cont.onBoat = (List<ICrosser>) decoder.readObject();
			cont.rightBank = (List<ICrosser>) decoder.readObject();
			cont.sails = (int) decoder.readObject();
			cont.canRedo = (boolean) decoder.readObject();
			cont.canUndo = (boolean) decoder.readObject();
			cont.boatOnLeft = (boolean) decoder.readObject();
			decoder.close();
			fls.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
