import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener  {
	
	private static final long serialVersionUID = -3691008469289316169L;

	public Menu() {
		
		JButton test1 = new JButton("test 1");
		JButton test2 = new JButton("test 2");
		JButton test3 = new JButton("test 3");
				
		test1.addActionListener(this);
		test2.addActionListener(this);
		test3.addActionListener(this);
				
		this.add(test1);
		this.add(test2);
		this.add(test3);
				
		
		this.setLayout(new GridLayout(3,1,5,10));
//		setPreferredSize(new Dimension(Main.getBoxsize() * 10, Main.getBoxsize() * 8));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		
			case "test 1":
				Main.setPanel(new Board());
				break;
				
			default:
				
		}
						
	}
	
}
