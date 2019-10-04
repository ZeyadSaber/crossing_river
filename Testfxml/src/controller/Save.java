package controller;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save implements Command{
	
	@Override
	public void execute() {
		Controller cont = Controller.getInstance();
		try {
			FileOutputStream fos = new FileOutputStream(new File("src/controller.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(cont.gameStrategy);
			encoder.writeObject(cont.leftBank);
			encoder.writeObject(cont.onBoat);
			encoder.writeObject(cont.rightBank);
			encoder.writeObject(cont.sails);
			encoder.writeObject(cont.canRedo);
			encoder.writeObject(cont.canUndo);
			encoder.writeObject(cont.boatOnLeft);
			encoder.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
