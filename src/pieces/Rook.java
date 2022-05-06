package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
import enums.Name;
import enums.Side;

public class Rook extends Piece{
		
	public Rook() {

		try {
			
			setImage(ImageIO.read(new File("./assets/Rook.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Rook(Side side) {

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
	
	@Override
	public ArrayList<Coordinate> getMoves() {
		ArrayList<Coordinate> moves = new	ArrayList<Coordinate>();
		
		line(1 , 0).stream().forEach(legal -> moves.add(legal));
		line(-1, 0).stream().forEach(legal -> moves.add(legal));
		line(0 , 1).stream().forEach(legal -> moves.add(legal));
		line(0 ,-1).stream().forEach(legal -> moves.add(legal));

		
		return moves;
	}
		
}
