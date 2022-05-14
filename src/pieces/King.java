package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Coordinate;
import Main.Main;
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
	
	public boolean safe() {
		
		// Straights
		Piece piece = attacker(1 , 0);
		if (piece != null && (piece.getName() != Name.ROOK || piece.getName() == Name.QUEEN)) return false;
		piece = attacker(-1, 0);
		if (piece != null && (piece.getName() == Name.ROOK || piece.getName() == Name.QUEEN)) return false;
		piece = attacker(0 , 1);
		if (piece != null && (piece.getName() == Name.ROOK || piece.getName() == Name.QUEEN)) return false;
		piece = attacker(0 ,-1);
		if (piece != null && (piece.getName() == Name.ROOK || piece.getName() == Name.QUEEN)) return false;

		// Diagonal
		piece = attacker(1 , 1);
		if (piece != null && (piece.getName() == Name.BISHOP || piece.getName() == Name.QUEEN)) return false;
		piece = attacker(-1, 1);
		if (piece != null && (piece.getName() == Name.BISHOP || piece.getName() == Name.QUEEN)) return false;
		piece = attacker(1 , -1);
		if (piece != null && (piece.getName() == Name.BISHOP || piece.getName() == Name.QUEEN)) return false;
		piece = attacker(-1 ,-1);
		if (piece != null && (piece.getName() == Name.BISHOP || piece.getName() == Name.QUEEN)) return false;

		// Knight
		for (int dx = -1; dx < 2; dx+=2) {
			for (int dy = -1; dy <2; dy+=2) {
				
				if (!(getX()+dx+dx > 7 || getX()+dx+dx < 0 || getY()+dy < 0 || getY()+dy > 7)) {
					Piece target = Main.getGameLogic().getPiece(getX()+dx+dx, getY()+dy);
					if (target != null && target.getSide() != getSide() && target.getName() == Name.KNIGHT) {
						return false;
					}
				}
				
				if (!(getX()+dx > 7 || getX()+dx < 0 || getY()+dy+dy < 0 || getY()+dy+dy > 7)) {
					
					Piece target = Main.getGameLogic().getPiece(getX()+dx, getY()+dy+dy);
					if (target != null && target.getSide() != getSide() && target.getName() == Name.KNIGHT) {
						return false;
					}}
				};
				
			}
		
		// Pawn
		int dy = 1;
		if (getSide() == Side.WHITE) {
			dy = -1;
		}
		Piece target = Main.getGameLogic().getPiece(getX()+1, getY()+dy);
		if (target != null && target.getSide() != getSide() && target.getName() == Name.PAWN) {
			return false;
		}
		
		target = Main.getGameLogic().getPiece(getX()-1, getY()+dy);
		if (target != null && target.getSide() != getSide() && target.getName() == Name.PAWN) {
			return false;
		}
		
		return true;
	}
	
	public Piece attacker(int xd, int yd){

		int x = getX()+xd;
		int y = getY()+yd;
		
		while (true){
			if (x < 0 || x == 8 || y < 0 || y == 8) break;
			
			Piece target = Main.getGameLogic().getPiece(x, y);
			if (target == null) {
				;
			} else if (target.getSide() != getSide()){
				return target;
			} else {
				break;
			}
			x += xd;
			y += yd;
		}
		
		return null;		
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

	public boolean legalMove(int x, int y) {
		
		int currentX = getX();
		int currentY = getY();
		Piece oldPiece = Main.getGameLogic().getPiece(x,y);
		
		Main.getGameLogic().setPiece(getX(), getY(), null);
		Main.getGameLogic().setPiece(x, y, this);
		
		boolean legal = safe();
		
		Main.getGameLogic().setPiece(getX(), getY(), oldPiece);
		Main.getGameLogic().setPiece(currentX, currentY, this);
		
		return legal;
	}
	
	@Override
	public ArrayList<Coordinate> getMoves() {
		ArrayList<Coordinate> moves = new	ArrayList<Coordinate>();
		
		for (int dx = -1; dx < 2; dx+=1) {
			for (int dy = -1; dy <2; dy+=1) {
				
				if (!(getX()+dx > 7 || getX()+dx < 0 || getY()+dy < 0 || getY()+dy > 7)) {
					
					Piece target = Main.getGameLogic().getPiece(getX()+dx, getY()+dy);
					if ((target == null || target.getSide() != getSide())) moves.add(new Coordinate(getX()+dx, getY()+dy));

				};
				
			}

		}
		
		System.out.println(getLastMove());
		if (getLastMove() == 0) {// Castling

			boolean queenSide = true;
			boolean kingSide = true;
			int dx = 1;
			while (getX() + dx < 7) {
				if (Main.getGameLogic().getPiece(getX()+dx, getY()) == null && legalMove(getX()+dx, getY())) {
					queenSide = false;
					break;
				}
				dx++;
			}
			
			if (queenSide) {
				Piece rook = Main.getGameLogic().getPiece(7, getY());
				if (rook != null && rook.getName() == Name.ROOK && rook.getLastMove() == 0 ) {
					 moves.add(new Coordinate(7, getY()));
					 System.out.println("QueenSide");
				}
			}
			
			dx = -1;
			while (getX() + dx > 0) {
				if (Main.getGameLogic().getPiece(getX()+dx, getY()) == null && legalMove(getX()+dx, getY())) {
					kingSide = false;
					break;
				}
				dx--;
			}
			
			if (kingSide) {
				Piece rook = Main.getGameLogic().getPiece(0, getY());
				if (rook != null && rook.getName() == Name.ROOK && rook.getLastMove() == 0 ) {
					 moves.add(new Coordinate(0, getY()));
					 System.out.println("kingSide");
				}
			}
			
		}
				
		return moves;
		
	}

}
