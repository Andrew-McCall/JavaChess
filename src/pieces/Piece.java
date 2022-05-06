package pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Main.Coordinate;
import Main.Main;
import enums.Name;
import enums.Side;

public class Piece {

	private int xCoord;
	private int yCoord;
	private BufferedImage image;
	private Side side = Side.WHITE;
	private int lastMove = 0;
	
	public Coordinate getCoords() {
		return new Coordinate(getX(), getY());
	}
	
	public int getLastMove() {
		return lastMove;
	}

	public void setLastMove(int lastMove) {
		this.lastMove = lastMove;
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
	

	public ArrayList<Coordinate> getMoves() {
		return new ArrayList<Coordinate>(); 
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

	public boolean move(Coordinate coords) {
		var process = new Object() {boolean legal = false;};

		getMoves().stream().forEach(legalCoords -> {
			if (coords.equals(legalCoords)) {
				Piece target = Main.getGameLogic().getPiece(coords.getX(), coords.getY());
				Main.getGameLogic().killPiece(target);
				Main.getGameLogic().setPiece(coords, this);
				process.legal = true;
			}
		});
		return process.legal;
		
	}

}