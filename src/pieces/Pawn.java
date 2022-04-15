package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Main;
import enums.Name;
import enums.Side;

public class Pawn extends Piece{
	
	public Pawn() {
		try {
			
			setImage(ImageIO.read(new File("./assets/Pawn.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Pawn(Side side) {
		if (side == Side.BLACK) {
			
			try {
				setImage(ImageIO.read(new File("./assets/PawnBlack.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.BLACK);
			
		}else {
			
			try {
				setImage(ImageIO.read(new File("./assets/Pawn.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSide(Side.WHITE);
			
		}
		
	}

	@Override
	public Name getName() {
		return Name.PAWN;
	}
	
	@Override
	public boolean MoveLegal(int x, int y) {
		
		Piece target = Main.getGameLogic().getPiece(x, y);
		
		if (x == getX()) {
			
			if (target == null) {
				int modifer = 1;
						
				if (getSide() == Side.BLACK) {
					modifer = -1;
				}
								
				if (y + modifer == getY()) {
					return true;
					
				}else if (y + modifer + modifer == getY() && 3.5 + (modifer)*2.5 == getY()){
						
					return (Main.getGameLogic().getPiece(x, y + modifer) == null);
					
				}
				
			}

		}else if ((x+1 == getX() || x-1 == getX()) && target != null ) {
			
			// TODO: En Passant
			if ((getSide() == Side.WHITE && getY() == y + 1 ) || (getSide() == Side.BLACK && getY() == y - 1 )) {
				return !(target.getSide() == getSide());
			}
			
		}
			
		
		return false;
		// Forward 1 IF empty
		
		// Forward 2 IF y == 2 AND empty empty
		
		// Take LEFT/RIGHT IF enemy
		
		
		
		
		
		
	}

}
