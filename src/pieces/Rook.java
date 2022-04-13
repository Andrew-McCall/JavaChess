package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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


}
