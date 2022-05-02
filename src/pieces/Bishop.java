package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Main;
import enums.Name;
import enums.Side;

public class Bishop extends Piece{
	
	public Bishop() {
		super();

		try {
			
			setImage(ImageIO.read(new File("./assets/Bishop.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Bishop(Side side) {
		super();

		if (side == Side.BLACK) {
			
			try {
				setImage(ImageIO.read(new File("./assets/BishopBlack.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.BLACK);
			
		}else {
			
			try {
				setImage(ImageIO.read(new File("./assets/Bishop.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.WHITE);
			
		}
		
	}

	@Override
	public Name getName() {
		return Name.BISHOP;
	}
	
	@Override
	public boolean moveLegal(int x, int y) {
		
		Piece target = Main.getGameLogic().getPiece(x, y);
		if (target != null && target.getSide()==this.getSide()) return false; // Target
				
		if (Math.abs(x-getX()) == Math.abs(y-getY())) { // Bishop
						
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
			
		}
		
		return false;
		
	}

	
}
