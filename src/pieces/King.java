package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

}
