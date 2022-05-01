package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Main;
import enums.Name;
import enums.Side;

public class Rook extends Piece{
		
	public Rook() {

		try {
			
			setImage(ImageIO.read(new File("./assets/Rook.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Rook(Side side) {

		if (side == Side.BLACK) {
			
			try {
				setImage(ImageIO.read(new File("./assets/RookBlack.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.BLACK);
			
		}else {
			
			try {
				setImage(ImageIO.read(new File("./assets/Rook.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.WHITE);
			
		}
		
	}

	@Override
	public Name getName() {
		return Name.ROOK;
	}
	
	@Override
	public boolean moveLegal(int x, int y) {
		
		Piece target = Main.getGameLogic().getPiece(x,y);

		if ((target != null && target.getSide() == getSide())) {
			return false;
		} else if (y == getY()) {
			boolean positive = x>getX();

			if (positive) {
				x--;
			}else {
				x++;
			}
			while (x != getX()) {
				
				if (Main.getGameLogic().getPiece(x,y) != null) return false;
				
				if (positive) {
					x--;
				}else {
					x++;
				}
			}
			
			return true;
			
		} else if (x == getX()) {
			
			boolean positive = y>getY();
			
			if (positive) {
				y--;
			}else {
				y++;
			}
			while (y != getY()) {
				
				if (Main.getGameLogic().getPiece(x,y) != null) return false;
				
				if (positive) {
					y--;
				}else {
					y++;
				}
			}

			return true;
			
		}
		
		return false;
		
	}

}
