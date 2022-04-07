public class Main {

	private final static int BOXSIZE = 50;
	private static GameLogic gameLogic = new GameLogic("test2");
	
	public static void main(String[] args) {
		
		new Menu();
	    
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
