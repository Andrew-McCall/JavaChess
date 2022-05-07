package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
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
	
	@Override
	public ArrayList<Coordinate> getMoves() {
		ArrayList<Coordinate> moves = new	ArrayList<Coordinate>();
		
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				line(x, y).stream().forEach(legal -> moves.add(legal));
			}
		}
		
		return moves;
	}
		
}
