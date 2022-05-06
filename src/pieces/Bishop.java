package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
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
	
	@Override
	public ArrayList<Coordinate> getMoves() {

		ArrayList<Coordinate> moves =  new ArrayList<Coordinate>(); 

		for (int x = -1; x < 2; x+=2) {
			for (int y = -1; y < 2; y+=2) {
				line(x, y).stream().forEach(legal -> moves.add(legal));
			}
		}
		
		return moves;
		
	}
	
}
