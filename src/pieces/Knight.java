package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	public void move(int x, int y) {
		
		Piece target = Main.getGameLogic().getPiece(x,y);
		int dx = Math.abs(getX() - x); 
		int dy = Math.abs(getY() - y); 
		
		if ((target == null || target.getSide() != getSide()) && (dx == 1 && dy==2 || dx  == 2 && dy==1)) {
			
			Main.getGameLogic().killPiece(target);
			Main.getGameLogic().setPiece(x, y, this);
			Main.getGameLogic().endTurn();

		}
		

	}
}
