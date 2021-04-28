package com.games.keybarricade;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import com.games.keybarricade.model.Player;

/**
 * This class provides the implementation for keyboard movement for the game.
 * i.e. Player movement using up, down, left and right arrow keys.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class GameListener implements KeyListener {

	private Gameboard gameboard;

	/**
	 * Parameterized constructor for initializing Game listener.
	 * 
	 * @param gameboard	Gameboard
	 */
	public GameListener(Gameboard gameboard) {
		this.gameboard = gameboard;
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		gameboard.revalidate();
		gameboard.repaint();

		Player player = gameboard.getPlayer();

		int code = ke.getKeyCode();
		if ((code == KeyEvent.VK_LEFT)
				&& gameboard.isValidMove(player.getCurrentX(), player.getCurrentY(), player.getCurrentX() - 1, player.getCurrentY())) {
			// On valid left move, move player one step left and add to total steps count
			player.goLeft();
			gameboard.getGameInfo().addTotalStepsCount();
		} else if ((code == KeyEvent.VK_UP)
				&& gameboard.isValidMove(player.getCurrentX(), player.getCurrentY(), player.getCurrentX(), player.getCurrentY() - 1)) {
			// On valid up move, move player one step left and add to total steps count
			player.goUp();
			gameboard.getGameInfo().addTotalStepsCount();
		} else if ((code == KeyEvent.VK_RIGHT)
				&& gameboard.isValidMove(player.getCurrentX(), player.getCurrentY(), player.getCurrentX() + 1, player.getCurrentY())) {
			// On valid right move, move player one step left and add to total steps count
			player.goRight();
			gameboard.getGameInfo().addTotalStepsCount();
		} else if ((code == KeyEvent.VK_DOWN)
				&& gameboard.isValidMove(player.getCurrentX(), player.getCurrentY(), player.getCurrentX(), player.getCurrentY() + 1)) {
			// On valid down move, move player one step left and add to total steps count
			player.goDown();
			gameboard.getGameInfo().addTotalStepsCount();
		} else if (code == KeyEvent.VK_SPACE) {
			// When space is pressed on key block, update player key value and remove key from gameboard
			if (gameboard.getBoardValueAt(player.getCurrentX(), player.getCurrentY()).equals("3")) {
				gameboard.setBoardValueAt(player.getCurrentX(), player.getCurrentY(), "1");
				player.setKeyValue(100);
				gameboard.getGameInfo().addTotalKeysCollected();
			} else if (gameboard.getBoardValueAt(player.getCurrentX(), player.getCurrentY()).equals("5")) {
				gameboard.setBoardValueAt(player.getCurrentX(), player.getCurrentY(), "1");
				player.setKeyValue(200);
				gameboard.getGameInfo().addTotalKeysCollected();
			} else if (gameboard.getBoardValueAt(player.getCurrentX(), player.getCurrentY()).equals("7")) {
				gameboard.setBoardValueAt(player.getCurrentX(), player.getCurrentY(), "1");
				player.setKeyValue(300);
				gameboard.getGameInfo().addTotalKeysCollected();
			}
			gameboard.getGameInfo().setCurrentKeyValue(player.getKeyValue());
		}

		// If player is reached on finish point block, show winning dialog.
		if (gameboard.getBoardValueAt(player.getCurrentX(), player.getCurrentY()).equals("F")) {
			gameboard.setFinished(true);
			if(!gameboard.isTesting()) {
				JOptionPane.showMessageDialog(null, "Congratulations!!!", "Key Barricade", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		gameboard.getGameInfo().refreshValues();
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

	@Override
	public void keyReleased(KeyEvent ke) {
	}
}