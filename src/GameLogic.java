import java.util.ArrayList;

import enums.Name;
import pieces.*;

public class GameLogic {

	private Piece[] boardData;
	private ArrayList<Name> deadData;
	
	public GameLogic() {

		boardData = new Piece[64];
		deadData = new ArrayList<Name>();
		
		
		/// Standard Board
		
		// Black 
		boardData[0] = new Rook();
		boardData[1] = new Knight();
		boardData[2] = new Bishop();
		boardData[3] = new King();
		boardData[4] = new Queen();
		boardData[5] = new Knight();
		boardData[6] = new Bishop();
		boardData[7] = new Rook();
		
		boardData[8] = new Pawn();
		boardData[9] = new Pawn();
		boardData[10] = new Pawn();
		boardData[11] = new Pawn();
		boardData[12] = new Pawn();
		boardData[13] = new Pawn();
		boardData[14] = new Pawn();
		boardData[15] = new Pawn();
		
		
		// White
		boardData[63] = new Rook();
		boardData[62] = new Knight();
		boardData[61] = new Bishop();
		boardData[60] = new Queen();
		boardData[59] = new King();
		boardData[58] = new Knight();
		boardData[57] = new Bishop();
		boardData[56] = new Rook();
		
		boardData[55] = new Pawn();
		boardData[54] = new Pawn();
		boardData[53] = new Pawn();
		boardData[52] = new Pawn();
		boardData[51] = new Pawn();
		boardData[50] = new Pawn();
		boardData[49] = new Pawn();
		boardData[48] = new Pawn();
		
	}

	public Piece getPiece(int x, int y) {

		return boardData[x + (y*8)];
		
	}
	
	public void movePiece(int x, int y, int newX, int newY) {
		
		Piece replaced = getPiece(newX, newY);
//		Piece moved = getPiece(x, y); TODO Legal Move Check
		
		if (replaced != null) {
			deadData.add(replaced.getName());
		}
		
		boardData[newX + (newY*8)] = boardData[x + (y*8)];
		boardData[x + (y*8)] = null;
		
	}
	
	
	
}
