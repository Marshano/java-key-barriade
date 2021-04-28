package com.games.keybarricade.model;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * This class represents a universal block.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public abstract class Block extends JPanel {

	private int blockWidth = 55;
	private int blockHeight = 55;

	/**
	 * Default constructor for initializing a block.
	 */
	public Block() {
		setBackground(Color.LIGHT_GRAY);
		setSize(blockWidth, blockHeight);
	}

	/**
	 * @return the blockWidth
	 */
	public int getBlockWidth() {
		return blockWidth;
	}

	/**
	 * @param blockWidth the blockWidth to set
	 */
	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	/**
	 * @return the blockHeight
	 */
	public int getBlockHeight() {
		return blockHeight;
	}

	/**
	 * @param blockHeight the blockHeight to set
	 */
	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}
}