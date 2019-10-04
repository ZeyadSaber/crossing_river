package testfxml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HerbevorusAnimal implements ICrosser{
	
	private final double Weight = 20.0 ;
	private final int  EatingRank = 1 ;
	private BufferedImage[] imgs = new BufferedImage[5];
	
	
	@Override
	public boolean canSail() {
		return false;
	}
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub   // return the goat weight !!
		return this.Weight;
	}
	                                        
	@Override
	public int getEatingRank() {
		// TODO Auto-generated method stub
		return this.EatingRank;
	}
	@Override
	public BufferedImage[] getImages() {
		try {
			imgs[0] = ImageIO.read(new File("images/goatLeft.png"));
			imgs[1] = ImageIO.read(new File("images/goatRight.png"));
			imgs[3] = ImageIO.read(new File("images/cowLeft.png"));
			imgs[4] = ImageIO.read(new File("images/cowRight.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return imgs;
	}
	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setLabelToBeShown(String label) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getLabelToBeShown() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
