package testfxml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plant implements ICrosser {
	
	private final double Weight = 5.0 ;
	private final int  EatingRank = 0 ;
	private BufferedImage[] imgs = new BufferedImage[5];

	
	@Override
	public boolean canSail() {
		return false;
	}
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
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
			imgs[0] = ImageIO.read(new File("images/plantLeft.png"));
			imgs[1] = ImageIO.read(new File("images/plantRight.png"));

		}catch(IOException e) {
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


