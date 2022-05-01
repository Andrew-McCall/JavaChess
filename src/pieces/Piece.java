package pieces;

import java.awt.image.BufferedImage;

import enums.Name;
import enums.Side;

public class Piece {

	private boolean alive = true;
	private int xCoord;
	private int yCoord;
	private BufferedImage image;
	private Side side = Side.WHITE;
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean getAlive() {
		return alive;
	}

	
	public Name getName() {
		return null;
	}

	public void setSide(Side side) {
		this.side = side;
	}
	
	public Side getSide() {
		return side;
	}
	

	public int[][] getMoves() {
		return null;
	}
	
	public boolean moveLegal(int x, int y) {
		return false;
	}


	public void setX(int x) {
		xCoord = x;
	}


	public int getX() {
		return xCoord;
	}


	public void setY(int y) {
		yCoord = y;
	}


	public int getY() {
		return yCoord;
	}


	public void setImage(BufferedImage image) {

		this.image = image;
		
	}


	public BufferedImage getImage() {

		return image;
		
	}

}