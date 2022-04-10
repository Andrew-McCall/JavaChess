import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	private final static int BOXSIZE = 80;
	private static GameLogic gameLogic = new GameLogic("test2");
	
	private static JFrame window;
	
	public static void main(String[] args) {
		
		window = new JFrame("Chess By Andrew McCall");
		
		setPanel(new Menu());
		
		window.setVisible(true);
	}

	public static void setPanel(JPanel panel) {
		
		window.getContentPane().removeAll();
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null); 
		
	}
	
	public static GameLogic getGameLogic() {
		return gameLogic;
	}

	public static int getBoxsize() {
		return BOXSIZE;
	}

}
