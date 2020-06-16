package org.jpacman.test.framework.ui;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PacmanInteraction.MatchState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PacmanKeyListenerTest {
	MainUI ui = new MainUI();
	
	@Test
	/**
     * Testing method keyPressed() using class 'Robot' 
     */
	public void testKeyPressed()  {
		try {
		Robot robot = new Robot();
		ui.initialize();
		ui.start();
		robot.keyPress(KeyEvent.VK_S);  //start	
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_S);
		assertEquals(SpriteType.PLAYER, ui.getGame().getBoardInspector().spriteTypeAt(11, 15));
		assertEquals(MatchState.PLAYING,ui.eventHandler().getCurrentState());
		
		robot.keyPress(KeyEvent.VK_H);  //left
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_H);
		assertEquals(SpriteType.PLAYER, ui.getGame().getBoardInspector().spriteTypeAt(10, 15));
		
		robot.keyPress(KeyEvent.VK_K);  //up
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_K);
		assertEquals(SpriteType.PLAYER, ui.getGame().getBoardInspector().spriteTypeAt(10, 14));
		
		robot.keyPress(KeyEvent.VK_J);  //down
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_J);
		assertEquals(SpriteType.PLAYER, ui.getGame().getBoardInspector().spriteTypeAt(10, 15));

		robot.keyPress(KeyEvent.VK_Q);  //stop
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_Q);
		assertEquals(MatchState.PAUSING, ui.eventHandler().getCurrentState());	
		
		robot.keyPress(KeyEvent.VK_S);  //start	
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_S);

		robot.keyPress(KeyEvent.VK_L);  //right
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_L);
		assertEquals(SpriteType.PLAYER, ui.getGame().getBoardInspector().spriteTypeAt(11, 15));
		
		robot.keyPress(KeyEvent.VK_X);  //exit
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_X);	
		} catch (Exception e) {
			fail("KeyPressed testing failed!");
		}
	}
	/**
     * Testing method keyReleased() using class 'Robot' 
     */
	@Test
	public void testKeyReleased(){
		try {
			Robot robot = new Robot();
			ui.initialize();
			ui.start();
		   robot.keyRelease(KeyEvent.VK_UP);  
		} catch (Exception e) {
			fail("KeyReleased testing failed!");
		}
	}
}



