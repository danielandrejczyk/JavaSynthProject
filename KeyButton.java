import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KeyButton extends JButton implements ActionListener{
	
	public boolean pressed = false;
	
	public KeyButton(int posX, int posY, int w, int h) {
		super();
		setBounds(posX, posY, w, h);
		setBorder(null);
		setBorderPainted(true);
		setContentAreaFilled(false);
		setOpaque(false);
		
		
		setVisible(true);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button was pressed!");
		
	}

}
