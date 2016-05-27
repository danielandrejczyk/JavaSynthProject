import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main.java
 * This is the main class. It controls all other classes and creates the window
 * 
 * @author Daniel Andrejczyk, Tom Lebert
 * @version 5/20/16 <- UPDATE THIS!!!
 */

public class Main extends Canvas {
	
	public static String gameTitle = "Java Synthesizer";
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 500;
	
	public JFrame frame;
	public static JPanel panel;
	
	//public synchronized static start(){
		//running = true;
	//}
	
	public Main(){
		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		setPreferredSize(size);
		
		frame = new JFrame(gameTitle);
	}

	public static void main(String args[]){

		Main main = new Main();
		main.frame.setResizable(true);
		main.frame.add(main);
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setLocationRelativeTo(null);
		main.frame.add(new newPanel());
		main.frame.pack();
		main.frame.setVisible(true);
	}

}
