package Main;
import java.util.ArrayList;

import enums.Name;
import enums.Side;
import pieces.*;

public class GameLogic {

	private Piece[] boardData;
	private ArrayList<Name> deadData;
	private int boardVersion = 0;
	private Side turn = Side.WHITE;
	
	public GameLogic() {

		boardData = new Piece[64];
		deadData = new ArrayList<Name>();
		
		/// Standard Board
		
		// Black 
		setPiece(0, 0, new Rook(Side.BLACK));
		setPiece(1, 0, new Bishop(Side.BLACK));
		setPiece(2, 0, new Knight(Side.BLACK));
		setPiece(3, 0, new King(Side.BLACK));
		setPiece(4, 0, new Queen(Side.BLACK));
		setPiece(5, 0, new Knight(Side.BLACK));
		setPiece(6, 0, new Bishop(Side.BLACK));
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
		
	}

	public Side getTurn() {
		return turn;
	}
	
	public void endTurn() {
		if (turn == Side.BLACK) {
			turn = Side.WHITE;
		}else {
			turn = Side.BLACK;
		}
	}
	
	public Piece getPiece(int x, int y) {

		return boardData[x + (y*8)];
		
	}
	
	public void setPiece(int x, int y, Piece piece) {

		boardData[x + (y*8)] = piece;

		if (piece != null) {
			piece.setX(x);
			piece.setY(y);
		}
		
	}
	
	public void movePiece(int x, int y, int newX, int newY) {
		
		Piece piece1 = getPiece(x, y);
		Piece piece2 = getPiece(newX, newY);

		// TODO: replace with piece1.getLegal(newX, newY)
		if (piece1.MoveLegal(newX, newY)) {
			
			setPiece(newX, newY, piece1);
			setPiece(x, y, null);
			
			if  (kingInCheck(piece1.getSide())) {
				setPiece(newX, newY, piece2);
				setPiece(x, y,  piece1);
			}else {
				
				if (piece2 != null) {
					deadData.add(piece2.getName());
				}
				
				boardVersion += 1;
				endTurn();
			}
			
		}
		
	}
	
	public boolean kingInCheck(Side side) {
		
		King king = (King) getPiece(Name.KING, side);
		
		if (king != null) {
			return king.inCheck();
		}
		
		return false;
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
