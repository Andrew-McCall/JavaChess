package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

}
