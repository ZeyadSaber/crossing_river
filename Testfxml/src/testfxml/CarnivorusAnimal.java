package testfxml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarnivorusAnimal implements ICrosser {
	
	private final double Weight = 20.0 ;
    private final int  EatingRank = 2 ;
	private BufferedImage[] imgs = new BufferedImage[5];

	public boolean canSail() {
		return false;
	}

	public double getWeight() {
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
			imgs[0] = ImageIO.read(new File("images/lionLeft.png"));
			imgs[1] = ImageIO.read(new File("images/lionRight.png"));
			imgs[2] = ImageIO.read(new File("images/wolfLeft.png"));
			imgs[3] = ImageIO.read(new File("images/wolfRight.png"));
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
