package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Main;
import enums.Name;
import enums.Side;

public class Queen extends Piece{
		
	public Queen() {
		super();

		try {
			
			setImage(ImageIO.read(new File("./assets/Queen.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Queen(Side side) {
		super();

		if (side == Side.BLACK) {
			
			try {
				setImage(ImageIO.read(new File("./assets/QueenBlack.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.BLACK);
			
		}else {
			
			try {
				setImage(ImageIO.read(new File("./assets/Queen.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.WHITE);
			
		}
		
	}

	@Override
	public Name getName() {
		return Name.QUEEN;
	}
	
	@Override
	public boolean moveLegal(int x, int y) {
		
		Piece target = Main.getGameLogic().getPiece(x, y);
		if (target != null && target.getSide()==this.getSide()) return false;
				
		if (Math.abs(x-getX()) == Math.abs(y-getY())) {
						
			int i = 0;
			int z = 0;
			while (getX()!=x+i) {
				
				if (x<getX()) i++; 
				else i--;
				
				if (y<getY()) z++;
				else z--;
				
				if (getX()-i == x && getY()-z == y)continue;
				
				if ( Main.getGameLogic().getPiece(getX()-i, getY()-z) != null) return false;
				
			}
			
			return true;
			
		}if (y == getY()) {
			
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
