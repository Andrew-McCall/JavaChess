package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import enums.Name;
import enums.Side;

public class Pawn extends Piece{
	
	public Pawn() {
		super();

		try {
			
			setImage(ImageIO.read(new File("./assets/Pawn.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Pawn(Side side) {
		super();

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

}
