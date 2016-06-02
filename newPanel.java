import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Screen.java
 * Controls all GUI elements of the Synth Keyboard on the screen.
 * 
 * @author Daniel Andrejczyk
 * @version 5/24/16
 */

public class newPanel extends JPanel {

	//Constructor
	public newPanel(){
		setBorder(BorderFactory.createLineBorder(Color.black));//might delete this later...
		setVisible(true);
	}
	
	//Set the size methinks...
	public Dimension getPreferredSize(){
		Dimension d = new Dimension(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		return d;
	}
	
	//-----------------------------------------------------------------
	//  Draws a synthesizer.
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		
		super.paintComponent(page);
		
		final int MID = Main.SCREEN_WIDTH /2 + 20;
		page.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 

		page.setColor (Color.black);
		page.fillRect (MID-501, 99, 1002, 502);  //back

		page.setColor (Color.red);
		page.fillRect (MID-500, 100, 1000, 500);  //back

		page.setColor (Color.black);
		page.fillRect (MID-301, 149, 701, 402);        //behind keys

		//white keys

		page.setColor (Color.white);
		page.fillRect (MID-300, 150, 99, 400);        //wkey 1

		page.setColor (Color.white);
		page.fillRect (MID-200, 150, 99, 400);        //wkey 2

		page.setColor (Color.white);
		page.fillRect (MID-100, 150, 99, 400);        //wkey 3

		page.setColor (Color.white);
		page.fillRect (MID, 150, 99, 400);        //wkey 4

		page.setColor (Color.white);
		page.fillRect (MID+100, 150, 99, 400);        //wkey 5

		page.setColor (Color.white);
		page.fillRect (MID+200, 150, 99, 400);        //wkey 6

		page.setColor (Color.white);
		page.fillRect (MID+300, 150, 99, 400);        //wkey 7

		//black keys

		page.setColor (Color.black);
		page.fillRect (MID-225, 150, 49, 200);        //bkey 1


		page.setColor (Color.black);
		page.fillRect (MID-125, 150, 49, 200);        //bkey 2

		page.setColor (Color.black);
		page.fillRect (MID+75, 150, 49, 200);        //bkey 3

		page.setColor (Color.black);
		page.fillRect (MID+175, 150, 49, 200);        //bkey 4

		page.setColor (Color.black);
		page.fillRect (MID+275, 150, 49, 200);        //bkey 5

		

	}	
}
