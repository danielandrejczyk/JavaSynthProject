import java.awt.Canvas;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main.java
 * This is the main class. It controls all other classes and creates the window
 * 
 * @author Daniel Andrejczyk, Tom Lebert
 * @version 5/20/16 <- UPDATE THIS!!!
 */

public class Main extends Canvas implements Runnable {
	
	public static String gameTitle = "Java Synthesizer";
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 500;
	
	public boolean running = false;
	public Thread thread;
	
	public JFrame frame;
	public static JPanel panel;
	
	public ArrayList<KeyButton> keyButtons = new ArrayList<KeyButton>();
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Main(){
		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		setPreferredSize(size);
		
		frame = new JFrame(gameTitle);
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				updates++;
				delta--;
			}
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		
	}

	
	public void createKeyButtons(){
		final int MID = Main.SCREEN_WIDTH /2 + 20;
		
		//White keys 1-7
		KeyButton wk1 = new KeyButton(MID-300, 150, 99, 400);
		KeyButton wk2 = new KeyButton(MID-200, 150, 99, 400);
		KeyButton wk3 = new KeyButton(MID-100, 150, 99, 400);
		KeyButton wk4 = new KeyButton(MID, 150, 99, 400);
		KeyButton wk5 = new KeyButton(MID+100, 150, 99, 400);
		KeyButton wk6 = new KeyButton(MID+200, 150, 99, 400);
		KeyButton wk7 = new KeyButton(MID+300, 150, 99, 400);
		
		//Black keys 1-5
		KeyButton bk1 = new KeyButton(MID-225, 150, 49, 200);
		KeyButton bk2 = new KeyButton(MID-125, 150, 49, 200);
		KeyButton bk3 = new KeyButton(MID+75, 150, 49, 200);
		KeyButton bk4 = new KeyButton(MID+175, 150, 49, 200);
		KeyButton bk5 = new KeyButton(MID+275, 150, 49, 200);
		
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
