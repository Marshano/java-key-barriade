package com.games.keybarricade;

import javax.swing.SwingUtilities;

/**
 * Main class for starting the Key Barricade game.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class KeyBarricade {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Gameboard gameboard = new Gameboard();
				gameboard.setVisible(true);
			}
		});
	}
}