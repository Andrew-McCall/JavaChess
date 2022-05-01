package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	public boolean MoveLegal(int x, int y) {
		
		Piece target = Main.getGameLogic().getPiece(x,y);
		
		if (target != null && (target.getSide() == getSide())) {
			return false;
		}else {
		
			return ! ((Math.abs(getX() - x )>1 || Math.abs(getY() - y )>1)) ;

		}


	}

	public boolean inCheck() {
		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
				if (i == getX() && z == getY()) continue;
				
				Piece piece = Main.getGameLogic().getPiece(i, z);
				if (piece == null || piece.getSide()==this.getSide()) continue;
				
				if (piece.MoveLegal(getX(), getY())) {
					return true;
				}
				
			}
		}
		return false;
	}
	
}
