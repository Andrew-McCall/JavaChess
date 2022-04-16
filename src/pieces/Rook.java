package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Main;
import enums.Name;
import enums.Side;

public class Rook extends Piece{
		
	public Rook() {
		super();

		try {
			
			setImage(ImageIO.read(new File("./assets/Rook.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Rook(Side side) {
		super();

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
	public boolean MoveLegal(int x, int y) {

		Piece target = Main.getGameLogic().getPiece(x,y);
		
		boolean xSame = (x == getX());
		boolean ySame = (y == getY());

		if ((target != null && target.getSide() == getSide())) {
			return false;
		} else if (ySame) {
			if (x>getX()) {
				x--;
			}else {
				x++;
			}
			while (x != getX()) {
				
				if (Main.getGameLogic().getPiece(x,y) != null) return false;
				
				if (x>getX()) {
					x--;
				}else {
					x++;
				}
			}
			
			return true;
			
		} else if (xSame) {
			if (y>getY()) {
				y--;
			}else {
				y++;
			}
			while (y != getY()) {
				
				if (Main.getGameLogic().getPiece(x,y) != null) return false;
				
				if (y>getY()) {
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
