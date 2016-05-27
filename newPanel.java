import java.applet.Applet;
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
		page.fillRect (MID-225, 150, 49, 200);        //bkey 2


		page.setColor (Color.black);
		page.fillRect (MID-125, 150, 49, 200);        //bkey 2

		page.setColor (Color.black);
		page.fillRect (MID+75, 150, 49, 200);        //bkey 3

		page.setColor (Color.black);
		page.fillRect (MID+175, 150, 49, 200);        //bkey 4

		page.setColor (Color.black);
		page.fillRect (MID+275, 150, 49, 200);        //bkey 5

		//volume buttons

		page.setColor (Color.black);
		page.drawString ("VOLUME", MID-425, 160); //volume label

		page.setColor (Color.black);
		page.fillRect (MID-426, 169, 52, 52);        //volume up around
		page.setColor (Color.white);
		page.fillRect (MID-425, 170, 50, 50);        //volume up
		page.setColor (Color.black);
		page.fillRect (MID-426, 229, 52, 52);        //volume down around
		page.setColor (Color.white);
		page.fillRect (MID-425, 230, 50, 50);        //volume down

		//octave buttons

		page.setColor (Color.black);
		page.drawString ("OCTAVE", MID-425, 310); //octave label

		page.setColor (Color.black);
		page.fillRect (MID-426, 319, 52, 52);        //octave up around
		page.setColor (Color.white);
		page.fillRect (MID-425, 320, 50, 50);        //octave up
		page.setColor (Color.black);
		page.fillRect (MID-426, 379, 52, 52);        //octave down around
		page.setColor (Color.white);
		page.fillRect (MID-425, 380, 50, 50);        //octave down]

	}	
}
