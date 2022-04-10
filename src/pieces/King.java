package pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class King implements Piece{
	
	private BufferedImage image;
	
	public King() {
		try {
			
			image = ImageIO.read(new File("./assets/King.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean getAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Name getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Side getSide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] getMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setImage(BufferedImage image) {

		this.image = image;
		
	}

	@Override
	public BufferedImage getImage() {

		return image;
		
	}


}
