package Main;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public final static int BOXSIZE = 80;
	public final static int FPS = 60;
	
	private static GameLogic gameLogic = new GameLogic();
	
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

}
