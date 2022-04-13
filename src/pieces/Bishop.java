package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

}
