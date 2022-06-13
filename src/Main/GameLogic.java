package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


import enums.Name;
import enums.Side;
import pieces.*;

public class GameLogic implements ActionListener {

	private Piece[] boardData;
	private ArrayList<Piece> deadBlack;
	private ArrayList<Piece> deadWhite;
 	private int boardVersion = 0;
	private Side turn = Side.WHITE;
	private int[] counter = new int[2];
	
	public int[] getCounter() {
		return counter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (this.getTurn()){
			case WHITE:
				counter[0] += 1;
				break;
			case BLACK:
				counter[1] += 1;
				break;
		}
	}
	
		
	public GameLogic() {

		boardData = new Piece[64];
		deadWhite = new ArrayList<Piece>();
		deadBlack = new ArrayList<Piece>();
		Timer timer = new Timer(100, this);
		
		/// Standard Board
		
		// Black 
		setPiece(1, 0, new Knight(Side.BLACK));
		setPiece(2, 0, new Bishop(Side.BLACK));
		setPiece(3, 0, new King(Side.BLACK));
		setPiece(4, 0, new Queen(Side.BLACK));
		setPiece(5, 0, new Bishop(Side.BLACK));
		setPiece(6, 0, new Knight(Side.BLACK));
		setPiece(7, 0, new Rook(Side.BLACK));
		
		setPiece(0, 1, new Pawn(Side.BLACK));
		setPiece(1, 1, new Pawn(Side.BLACK));
		setPiece(2, 1, new Pawn(Side.BLACK));
		setPiece(3, 1, new Pawn(Side.BLACK));
		setPiece(4, 1, new Pawn(Side.BLACK));
		setPiece(5, 1, new Pawn(Side.BLACK));
		setPiece(6, 1, new Pawn(Side.BLACK));
		setPiece(7, 1, new Pawn(Side.BLACK));
		
		// White
		setPiece(0, 7, new Rook());
		setPiece(1, 7, new Knight());
		setPiece(2, 7, new Bishop());
		setPiece(3, 7, new King());
		setPiece(4, 7, new Queen());
		setPiece(5, 7, new Bishop());
		setPiece(6, 7, new Knight());
		setPiece(7, 7, new Rook());
		
		setPiece(0, 6, new Pawn());
		setPiece(1, 6, new Pawn());
		setPiece(2, 6, new Pawn());
		setPiece(3, 6, new Pawn());
		setPiece(4, 6, new Pawn());
		setPiece(5, 6, new Pawn());
		setPiece(6, 6, new Pawn());
		setPiece(7, 6, new Pawn());
		
		setPiece(0, 0, new Rook(Side.BLACK));
		timer.start(); 
	}

	public Side getTurn() {
		return turn;
	}
	
	private boolean kingInDanger(Side side) {
		King king = (King) getPiece(Name.KING, side);

		return !king.safe();
		
	}
	
	public void movePiece(Piece piece, Coordinate newPos) {
				
		Piece[] boardSave = boardData.clone();
		
		if (piece.move(newPos)) {
			
			if (kingInDanger(turn)) {

				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						setPiece(x,y, boardSave[x+ y*8]);
					}
				}

			}else {
				Main.getGameLogic().endTurn();
				boardSave = null;
				}
		}
		
		
	}

	public void endTurn() {
		if (turn == Side.BLACK) {
			turn = Side.WHITE;
		}else {
			turn = Side.BLACK;
		}
		boardVersion++;
	}
	
	public Piece getPiece(int x, int y) {

		return boardData[x + (y*8)];
		
	}
	
	public Piece getPiece(Coordinate coords) {

		return boardData[coords.getX() + (coords.getY()*8)];
		
	}
	
	public ArrayList<Piece> getPieces(Side side){
		
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		
		for (int i = 0; i < boardData.length; i++) {
			if (boardData[i] != null && boardData[i].getSide() == side) pieces.add(boardData[i]); 
		}
		
		return pieces;
		
	}
	
	public void setPiece(int x, int y, Piece piece) {

		if (piece != null) {
			boardData[piece.getX() + 8* piece.getY()] = null;
			piece.setX(x);
			piece.setY(y);
		}
		
		boardData[x + y*8] = piece;
		
	}
	
	public void setPiece(Coordinate coords, Piece piece) {

		if (piece != null) {
			boardData[piece.getX() + 8* piece.getY()] = null;
			piece.setX(coords.getX());
			piece.setY(coords.getY());
		}
		
		boardData[coords.getX() + (coords.getY()*8)] = piece;
		
	}
	
	public void killPiece(Piece piece) {
		if (piece != null) {
			if (piece.getSide() == Side.WHITE) {
				deadWhite.add(piece);
			}else {
				deadBlack.add(piece);
			}
			
//			setPiece(piece.getX(), piece.getY(), null);
		}
	}
	
//	public boolean kingInCheck(Side side) {
//		
//		King king = (King) getPiece(Name.KING, side);
//		
//		if (king != null) {
//			return king.inCheck();
//		}
//		
//		return false;
//	}
	
	public ArrayList<Piece> getDeadBlack() {
		return deadBlack;
	}

	public ArrayList<Piece> getDeadWhite() {
		return deadWhite;
	}

	public Piece getPiece(Name name, Side side) {
		
		Piece piece = null;
		for (Piece p : boardData){
			if (p != null && p.getName() == name && p.getSide() == side) {
				piece = p;
				break;
			}
		}
		
		return piece;
		
	}
	

	public int getBoardVersion() {
		return boardVersion;
	}


	
}
