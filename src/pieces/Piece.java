package pieces;

interface Piece {
	
	public boolean getAlive();
	public Name getName();
	public Side getSide();
	public int[][] getMoves();
	
	public int getX();
	public int getY();
	public void setX();
	public void setY();
	
}

enum Name {
	KING,
	QUEEN,
	ROOK,
	KNIGHT,
	BISHOP,
	PAWN,
}

enum Side{
	BLACK, 
	WHITE,
}