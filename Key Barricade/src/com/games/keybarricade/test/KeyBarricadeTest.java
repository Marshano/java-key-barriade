package com.games.keybarricade.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.junit.jupiter.api.Test;

import com.games.keybarricade.Gameboard;

/**
 * This class tests Key Barricade game using JUnit 5 library.
 * 
 * @author Marshano N. & Karan K.
 *
 */
class KeyBarricadeTest {

	@Test
	void test() {
		Gameboard gameboard = new Gameboard(true);
		gameboard.requestFocusInWindow();
		
		assertFalse(gameboard.isFinished());
		
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 0);
		assertEquals(gameboard.getGameInfo().getCurrentKeyValue(), 0);
		assertEquals(gameboard.getGameInfo().getTotalKeysCollected(), 0);
		assertEquals(gameboard.getGameInfo().getTotalBarricadesCollected(), 0);
		assertEquals(gameboard.getGameInfo().getTotalErrorsCount(), 0);
		
		KeyEvent keyEventLeft = new KeyEvent(gameboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_LEFT, 'A');
		KeyEvent keyEventRight = new KeyEvent(gameboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_RIGHT, 'D');
		KeyEvent keyEventUp = new KeyEvent(gameboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP, 'W');
		KeyEvent keyEventDown = new KeyEvent(gameboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_DOWN, 'S');
		KeyEvent keyEventSpace = new KeyEvent(gameboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_SPACE, ' ');
	    KeyListener keyListener = gameboard.getKeyListeners()[0];
		
	    keyListener.keyPressed(keyEventDown);
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 1);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventUp);
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 2);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventDown);
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 3);
		assertEquals(gameboard.getGameInfo().getTotalErrorsCount(), 1);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventSpace);
		assertEquals(gameboard.getGameInfo().getCurrentKeyValue(), 100);
		assertEquals(gameboard.getGameInfo().getTotalKeysCollected(), 1);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 15);
		keyListener.keyPressed(keyEventRight);
		assertEquals(gameboard.getGameInfo().getTotalErrorsCount(), 2);
		assertEquals(gameboard.getGameInfo().getTotalBarricadesCollected(), 8);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventSpace);
		assertEquals(gameboard.getGameInfo().getCurrentKeyValue(), 300);
		assertEquals(gameboard.getGameInfo().getTotalKeysCollected(), 2);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		assertEquals(gameboard.getGameInfo().getTotalErrorsCount(), 3);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 39);
		assertEquals(gameboard.getGameInfo().getTotalErrorsCount(), 4);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventUp);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventSpace);
		assertEquals(gameboard.getGameInfo().getCurrentKeyValue(), 100);
		assertEquals(gameboard.getGameInfo().getTotalKeysCollected(), 3);
		assertEquals(gameboard.getGameInfo().getTotalBarricadesCollected(), 11);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventLeft);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventDown);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventRight);
		keyListener.keyPressed(keyEventDown);
		assertEquals(gameboard.getGameInfo().getTotalStepsCount(), 73);
		assertEquals(gameboard.getGameInfo().getTotalKeysCollected(), 3);
		assertEquals(gameboard.getGameInfo().getTotalBarricadesCollected(), 12);
		assertEquals(gameboard.getGameInfo().getTotalErrorsCount(), 4);
		assertFalse(gameboard.isFinished());
		keyListener.keyPressed(keyEventDown);
		assertTrue(gameboard.isFinished());
	}
}