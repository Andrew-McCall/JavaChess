import java.util.ArrayList;

import pieces.*;

public class GameLogic {

	private Piece[] boardData;
	private ArrayList<Piece> deadData;
	
	public GameLogic() {

		boardData = new Piece[64];
		deadData = new ArrayList<Piece>();
		
		
		// Test Data
		boardData[8] = new King();
		
	}

	public Piece getPiece(int x, int y) {

		return boardData[x + (y*8)];
		
	}
	
}
