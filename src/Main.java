public class Main {

	private final static int BOXSIZE = 50;
	private static GameLogic gameLogic = new GameLogic();
	
	public static void main(String[] args) {
		
//		new Board();
	    
	}

	public static GameLogic getGameLogic() {
		return gameLogic;
	}

	public static void setGameLogic(GameLogic gameLogic) {
		Main.gameLogic = gameLogic;
	}

	public static int getBoxsize() {
		return BOXSIZE;
	}

}
