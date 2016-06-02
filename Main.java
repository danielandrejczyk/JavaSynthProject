import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main.java
 * This is the main class. It controls all other classes and creates the window
 * 
 * @author Daniel Andrejczyk, Tom Lebert
 * @version 5/20/16 <- UPDATE THIS!!!
 */

public class Main extends Canvas implements Runnable, MouseListener {

	public static String gameTitle = "Java Synthesizer";
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 500;

	public boolean running = false;
	public boolean pressed = false;
	public int mx;
	public int my;
	public Thread thread;

	public JFrame frame;
	public static newPanel panel = new newPanel();

	public ArrayList<KeyButton> keyButtons = new ArrayList<KeyButton>();

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
		run();
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
		panel.addMouseListener(this);
		createKeyButtons1();
	
	}


	public void update(){
		if(pressed){
			String keyNote = "";
			for(KeyButton button : keyButtons){
				if(button.hovering(mx, my)){
					keyNote = button.getKeyNote();
				}
			}

			switch(keyNote){
			case "C":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\C_A2.wav");	break;
			case "C#":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\CS_A2.wav");	break;
			case "D":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\D_A2.wav");	break;
			case "D#":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\DS_A2.wav");	break;
			case "E":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\E_A2.wav");	break;
			case "F":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\F_A2.wav");	break;
			case "F#":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\FS_A2.wav");	break;
			case "G":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\G_A2.wav");	break;
			case "G#":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\GS_A2.wav");	break;
			case "A":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\A_A2.wav");	break;
			case "A#":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\AS_A2.wav");	break;
			case "B":		KeyButton.playNote("C:\\Users\\Tom\\Documents\\Programming (Home)\\Final Project\\Programming Final Project\\Notes\\Octave A2\\B_A2.wav");	break;
			default:	break;	//do nothing
			}
		}
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
				update();
				delta--;
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}

	}

	public void createKeyButtons1() {
	
		final int MID = SCREEN_WIDTH /2 + 20;
	
		//White keys 1-7
		KeyButton wk1 = new KeyButton(MID-300, 150, 99, 400, "C");
		keyButtons.add(wk1);
		KeyButton wk2 = new KeyButton(MID-200, 150, 99, 400, "D");
		keyButtons.add(wk2);
		KeyButton wk3 = new KeyButton(MID-100, 150, 99, 400, "E");
		keyButtons.add(wk3);
		KeyButton wk4 = new KeyButton(MID, 150, 99, 400, "F");
		keyButtons.add(wk4);
		KeyButton wk5 = new KeyButton(MID+100, 150, 99, 400, "G");
		keyButtons.add(wk5);
		KeyButton wk6 = new KeyButton(MID+200, 150, 99, 400, "A");
		keyButtons.add(wk6);
		KeyButton wk7 = new KeyButton(MID+300, 150, 99, 400, "B");
		keyButtons.add(wk7);
		
		//Black Keys 1-5
		KeyButton bk1 = new KeyButton(MID-225, 150, 49, 200, "C#");
		keyButtons.add(bk1);
		KeyButton bk2 = new KeyButton(MID-125, 150, 49, 200, "D#");
		keyButtons.add(bk2);
		KeyButton bk3 = new KeyButton(MID+75, 150, 49, 200, "F#");
		keyButtons.add(bk3);
		KeyButton bk4 = new KeyButton(MID+175, 150, 49, 200, "G#");
		keyButtons.add(bk4);
		KeyButton bk5 = new KeyButton(MID+275, 150, 49, 200, "A#");
		keyButtons.add(bk5);
		
	}

	

	public void mousePressed(MouseEvent me){
		pressed = true;
		mx = me.getX();
		my = me.getY();
	}

	public void mouseReleased(MouseEvent me){
		pressed = false;
	}

	public void mouseClicked(MouseEvent me){
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}


	public static void main(String args[]){

		Main main = new Main();
		main.frame.setResizable(true);
		main.frame.add(main);
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setLocationRelativeTo(null);
		main.frame.add(panel);
		main.frame.pack();
		main.frame.setVisible(true);
		main.start();
	}



}
