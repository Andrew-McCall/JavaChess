package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
import Main.Main;
import enums.Name;
import enums.Side;

public class Pawn extends Piece{
	
	public Pawn() {
		try {
			
			setImage(ImageIO.read(new File("./assets/Pawn.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Pawn(Side side) {
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
	public ArrayList<Coordinate> getMoves() {
		ArrayList<Coordinate> moves = new ArrayList<Coordinate>(); 

		int forward = (Side.WHITE == getSide()) ? -1 : 1 ;
		
		if (Main.getGameLogic().getPiece(getX(), getY()+forward) == null) {
			moves.add(new Coordinate(getX(), getY()+forward));

			if (Math.floor(3.5 - (forward)*2.5) == getY() && Main.getGameLogic().getPiece(getX(), getY()+forward+forward) == null ){
				moves.add(new Coordinate(getX(), getY()+forward+forward));
			}
			
		}
		
		Piece takeLeft = Main.getGameLogic().getPiece(getX()-1, getY()+forward);
		if ( takeLeft != null && takeLeft.getSide() != getSide() ) {
			moves.add(new Coordinate(takeLeft.getX(), takeLeft.getY()));
		}
		
		Piece takeRight = Main.getGameLogic().getPiece(getX()+1, getY()+forward);
		if ( takeRight != null && takeRight.getSide() != getSide() ) {
			moves.add(new Coordinate(takeRight.getX(), takeRight.getY()));
		}
		
		Piece enPassantLeft = Main.getGameLogic().getPiece(getX()-1, getY());
		if ( enPassantLeft != null && enPassantLeft.getSide() != getSide() ) {
			moves.add(new Coordinate(getX()-1, getY()));
		}
		
		Piece enPassantRight = Main.getGameLogic().getPiece(getX()+1, getY());
		if ( enPassantRight != null && enPassantRight.getSide() != getSide() ) {
			moves.add(new Coordinate(getX()+1, getY()));
		}
		
		
		return moves;
	}
	
	@Override
	public Name getName() {
		return Name.PAWN;
	}
	
	

	
	
//	@Override
//	public void move(Coordinate coords) {
//		
//		Piece target = Main.getGameLogic().getPiece(x, y);
//		
//		if (x == getX()) {
//			
//			if (target == null) {
//				int modifer = 1;
//						
//				if (getSide() == Side.BLACK) {
//					modifer = -1;
//				}
//				
//				if ( Main.getGameLogic().getPiece(x, y ) == null && (y + modifer == getY() || (y+modifer+modifer == getY() && 3.5 + (modifer)*2.5 == getY() && target == null ) )){
//
//					Main.getGameLogic().setPiece(x, y, this);
//					Main.getGameLogic().endTurn();
//					
//				}
//				
//			}
//
//		}else if ((x+1 == getX() || x-1 == getX())) {
//			
//			if ((getSide() == Side.WHITE && getY() == y + 1 ) || (getSide() == Side.BLACK && getY() == y - 1 )) {
//				
//				if (target != null && target.getSide() != getSide()) {
//					
//					Main.getGameLogic().killPiece(target);
//					Main.getGameLogic().setPiece(x, y, this);
//					Main.getGameLogic().endTurn();
//
//					
//				} else {
//					if  (getSide() == Side.WHITE) {
//						target = Main.getGameLogic().getPiece(x, y+1);
//					}else {
//						target = Main.getGameLogic().getPiece(x, y-1);
//					}
//					
//					if (target != null && target.getSide() != getSide() && target.getLastMove()+1 == Main.getGameLogic().getBoardVersion()) {
//
//						Main.getGameLogic().killPiece(target);
//						Main.getGameLogic().setPiece(target.getX(), target.getY(), null);
//						Main.getGameLogic().setPiece(x, y, this);
//						Main.getGameLogic().endTurn();
//						
//					}
//				}
//			}
//			
//			
//			
//		}
//		
//	}

}
