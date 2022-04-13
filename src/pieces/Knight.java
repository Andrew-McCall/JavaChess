package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
}
