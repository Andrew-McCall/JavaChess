package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
import Main.Main;
import enums.Name;
import enums.Side;

public class King extends Piece{
	
	public King() {
		super();

		try {
			
			setImage(ImageIO.read(new File("./assets/King.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public King(Side side) {
		super();

		if (side == Side.BLACK) {
			
			try {
				setImage(ImageIO.read(new File("./assets/KingBlack.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.BLACK);
			
		}else {
			
			try {
				setImage(ImageIO.read(new File("./assets/King.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.WHITE);
			
		}
		
	}

	@Override
	public Name getName() {
		return Name.KING;
	}

	@Override
	public ArrayList<Coordinate> getMoves() {
		ArrayList<Coordinate> moves = new	ArrayList<Coordinate>();
		
		for (int dx = -1; dx < 2; dx+=1) {
			for (int dy = -1; dy <2; dy+=1) {
				
				if (!(getX()+dx > 7 || getX()+dx < 0 || getY()+dy < 0 || getY()+dy > 7)) {
					
					Piece target = Main.getGameLogic().getPiece(getX()+dx, getY()+dy);
					if (target == null || target.getSide() != getSide()) {
						moves.add(new Coordinate(getX()+dx, getY()+dy));
					}
					
				};
				
			}

		}
		
		return moves;
		
	}

}
