import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	private final static int BOXSIZE = 80;
	private final static int FPS = 60;
	
	private static GameLogic gameLogic = new GameLogic();
	
	private static JFrame window;
	
	private static Timer paintCall = new Timer();
	
	public static void main(String[] args) {
		
		window = new JFrame("Chess By Andrew McCall");
		
		setPanel(new Menu());
		
		window.setVisible(true);
		
		paintCall.schedule(new TimerTask(){
			@Override
	        public void run() {
	            window.repaint();
	        }
		}, 100, 1000/FPS);
		
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
