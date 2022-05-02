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
			
			while (x != getX()) {
				
				if (x>getX()) {
					x--;
				}else {
					x++;
				}
				
				if (y == getY()) continue;

				if (Main.getGameLogic().getPiece(x,y) != null) return false;
				
			}
			
			return true;
			
		} else if (x == getX()) {
			
			while (y != getY()) {
				
				if (y>getY()) {
					y--;
				}else {
					y++;
				}
				
				if (y == getY()) continue;
				
				if (Main.getGameLogic().getPiece(x,y) != null) return false;
				
			}
			return true;
			
		}
		
		return false;
		
	}

}
