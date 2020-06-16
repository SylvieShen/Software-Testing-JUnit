package org.jpacman.test.framework.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jpacman.framework.ui.ButtonPanel;
import org.jpacman.framework.ui.PacmanInteraction;
import org.jpacman.framework.ui.IPacmanInteraction;
import org.junit.Test;


/**
 * Smoke test that just creates the button panel.
 * 
 * @author Arie van Deursen, TU Delft, Feb 9, 2012
 */
public class ButtonPanelTest {
	/**
	 * Smoke test that merely creates the panel.
	 */
	@Test
	public void buttonPanelSmokeTest() {
		JFrame jf = new JFrame();
		ButtonPanel bp = new ButtonPanel().withParent(jf);
		jf.add(bp);
		jf.setVisible(true);
		// next create suitable mocks for the listeners.
		// and then all we need is a gui testing
		// framework allowing us to click...
		PacmanInteraction pi = new PacmanInteraction();	  
		bp = bp.withInteractor(pi);
		IPacmanInteraction ip = bp.getPacmanInteractor();  
		bp.initialize();
		JButton tryButton = new JButton("try");
		bp.addButton(tryButton);
		bp.pause();
		bp.start(); 
	}

}

