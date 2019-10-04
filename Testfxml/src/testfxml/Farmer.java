package testfxml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Farmer  implements ICrosser{
	
	private  double Weight = 90 ;
	private final int  EatingRank = 4 ;
	private BufferedImage[] imgs = new BufferedImage[10];
	
	
	public boolean canSail() {
		return true;
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
			imgs[0] = ImageIO.read(new File("images/farmer.png"));
			imgs[1] = ImageIO.read(new File("images/farmer1.png"));
			imgs[2] = ImageIO.read(new File("images/farmer2Left.png"));
			imgs[3] = ImageIO.read(new File("images/farmer3Left.png"));
			imgs[4] = ImageIO.read(new File("images/farmer4Left.png"));
			imgs[5] = ImageIO.read(new File("images/farmerRight.png"));
			imgs[6] = ImageIO.read(new File("images/farmer1Right.png"));
			imgs[7] = ImageIO.read(new File("images/farmer2Right.png"));
			imgs[8] = ImageIO.read(new File("images/farmer3Right.png"));
			imgs[9] = ImageIO.read(new File("images/farmer4Right.png"));

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
		return null;
	}
	public void setWeight(double Weight) {
		this.Weight = Weight;
	}
	

	
	
	

}
