package pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Main.Coordinate;
import Main.Main;
import enums.Name;
import enums.Side;

public abstract class Piece {

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
	
	// Used by rook, bishop, queen
	public ArrayList<Coordinate> line (int xd, int yd){
		ArrayList<Coordinate> moves =  new ArrayList<Coordinate>(); 

		int x = getX()+xd;
		int y = getY()+yd;
		
		while (true){
			if (x < 0 || x == 8 || y < 0 || y == 8) break;
			
			Piece target = Main.getGameLogic().getPiece(x, y);
			if (target == null) {
				moves.add(new Coordinate(x,y));
			}else if (target.getSide() != getSide()){
				moves.add(new Coordinate(x,y));
				break;
			}else {
				break;
			}
			x += xd;
			y += yd;
		}
		
		return moves;		
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
				setLastMove(Main.getGameLogic().getBoardVersion());
				process.legal = true;
			}
		});
		return process.legal;
		
	}

	@Override
	public String toString() {
		return "Piece [Coords=(" + xCoord + ", " + yCoord + "), side=" + side + ", class="+getName()+"]";
	}

}