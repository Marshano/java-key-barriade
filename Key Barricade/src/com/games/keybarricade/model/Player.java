package com.games.keybarricade.model;

import static com.games.keybarricade.common.Constants.PLAYER_IMAGE_PATH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a player.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class Player extends Block {

	private int keyValue;
	private int currentX;
	private int currentY;

	private int playerWidth;
	private int playerHeight;

	private ImageIcon playerIcon;
	private JLabel iconWrap;

	/**
	 * Default constructor for initializing a player.
	 */
	public Player() {
		playerWidth = getBlockWidth();
		playerHeight = getBlockHeight();

		playerIcon = new ImageIcon(this.getClass().getResource(PLAYER_IMAGE_PATH));

		iconWrap = new JLabel();
		iconWrap.setBounds(4, 4, playerIcon.getIconWidth(), playerIcon.getIconHeight());
		iconWrap.setIcon(playerIcon);

		this.setLayout(null);
		add(iconWrap);
	}

	/**
	 * @return the keyValue
	 */
	public int getKeyValue() {
		return keyValue;
	}

	/**
	 * @param keyValue the keyValue to set
	 */
	public void setKeyValue(int keyValue) {
		this.keyValue = keyValue;
	}

	/**
	 * @return the currentX
	 */
	public int getCurrentX() {
		return currentX;
	}

	/**
	 * @param currentX the currentX to set
	 */
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	/**
	 * @return the currentY
	 */
	public int getCurrentY() {
		return currentY;
	}

	/**
	 * @param currentY the currentY to set
	 */
	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	/**
	 * This method moves player one step up.
	 */
	public void goUp() {
		setLocation(getX(), getY() - (this.playerHeight + 1));
		this.currentY--;
	}

	/**
	 * This method moves player one step down.
	 */
	public void goDown() {
		setLocation(getX(), getY() + (this.playerHeight + 1));
		this.currentY++;
	}

	/**
	 * This method moves player one step right.
	 */
	public void goRight() {
		setLocation(getX() + (this.playerHeight + 1), getY());
		this.currentX++;
	}

	/**
	 * This method moves player one step left.
	 */
	public void goLeft() {
		setLocation(getX() - (this.playerHeight + 1), getY());
		this.currentX--;
	}
}