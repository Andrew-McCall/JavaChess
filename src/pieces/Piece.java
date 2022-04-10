package pieces;

import java.awt.image.BufferedImage;

public interface Piece {
	
	boolean getAlive();
	Name getName();
	Side getSide();
	int[][] getMoves();
	
	void setX(int x);
	int getX();
	
	void setY(int y);
	int getY();
	
	void setImage(BufferedImage image); // Image
	BufferedImage getImage();
	
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