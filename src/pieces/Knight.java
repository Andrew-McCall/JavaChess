package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
import Main.Main;
import enums.Name;
import enums.Side;

public class Knight extends Piece{
	
	public Knight() {
		super();

		try {
			
			setImage(ImageIO.read(new File("./assets/Knight.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Knight(Side side) {
		super();

		if (side == Side.BLACK) {
			
			try {
				setImage(ImageIO.read(new File("./assets/KnightBlack.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.BLACK);
			
		}else {
			
			try {
				setImage(ImageIO.read(new File("./assets/Knight.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.WHITE);
			
		}
		
	}

	@Override
	public Name getName() {
		return Name.KNIGHT;
	}
	

	@Override
	public ArrayList<Coordinate> getMoves() {
		ArrayList<Coordinate> moves = new	ArrayList<Coordinate>();
		

		for (int dx = -1; dx < 2; dx+=2) {
			for (int dy = -1; dy <2; dy+=2) {
				
				if (!(getX()+dx+dx > 7 || getX()+dx+dx < 0 || getY()+dy < 0 || getY()+dy > 7)) {
					Piece target = Main.getGameLogic().getPiece(getX()+dx+dx, getY()+dy);
					if (target == null || target.getSide() != getSide()) {
						moves.add(new Coordinate(getX()+dx+dx, getY()+dy));
					}
				}
				
				if (!(getX()+dx > 7 || getX()+dx < 0 || getY()+dy+dy < 0 || getY()+dy+dy > 7)) {
					
					Piece target = Main.getGameLogic().getPiece(getX()+dx, getY()+dy+dy);
					if (target == null || target.getSide() != getSide()) {
						moves.add(new Coordinate(getX()+dx, getY()+dy+dy));
					}
				};
				
			}

		}
		
		return moves;
		
	}
		
}
