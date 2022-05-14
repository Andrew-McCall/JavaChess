package Main;

public class Coordinate {

	private int x;
	private int y;

	@Override
	public boolean equals(Object obj) {
		
		Coordinate obj1 = (Coordinate) obj;
		
		return (obj1.getX() == this.x && obj1.getY() == this.y);
		
	}
	
	@Override
	public String toString() {
		return "Coordinate (" + x + ", " + y + ")";
	}

	public Coordinate(int x, int y) {
		this.x = x;
			this.y = y;
		}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
