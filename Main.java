import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main.java
 * This is the main class. It controls all other classes and creates the window
 * 
 * @author Daniel Andrejczyk, Tom Lebert, Michael Lungo
 * @version 5/20/16 <- UPDATE THIS!!!
 */

public class Main extends Canvas {
	
	public static String gameTitle = "Java Synthesizer";
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 500;
	
	public JFrame frame;
	public static JPanel panel;
	public static Screen screen;
	
	public Main(){
		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		setPreferredSize(size);
		
		frame = new JFrame(gameTitle); //Creates a new JFrame object and sets the title
		panel = new JPanel();
		screen = new Screen();
	}

	public static void main(String args[]){

		Main main = new Main();
		main.frame.setResizable(false);
		main.frame.add(main);
		main.frame.pack();
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setLocationRelativeTo(null);
		main.frame.setVisible(true);
		screen.drawKeyboard();
	}

}
