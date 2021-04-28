package com.games.keybarricade.model;

import static com.games.keybarricade.common.Constants.BARRICADE_IMAGE_PATH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a barricade.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class Barricade extends Block {

	private int barricadeValue;
	private ImageIcon barricadeIcon;
	private JLabel iconWrap;
	private JLabel iconValue;

	/**
	 * Parameterized constructor for initializing a barricade.
	 * 
	 * @param value	Barricade value
	 */
	public Barricade(int value) {
		this.barricadeValue = value;

		barricadeIcon = new ImageIcon(this.getClass().getResource(BARRICADE_IMAGE_PATH));

		iconWrap = new JLabel();
		iconWrap.setBounds(4, 4, barricadeIcon.getIconWidth(), barricadeIcon.getIconHeight());
		iconWrap.setIcon(barricadeIcon);

		iconValue = new JLabel(Integer.toString(this.barricadeValue));
		iconValue.setBounds(17, 7, 22, 10);

		this.setLayout(null);
		this.add(iconValue);
		this.add(iconWrap);
	}

	/**
	 * @return the barricadeValue
	 */
	public int getBarricadeValue() {
		return barricadeValue;
	}

	/**
	 * @param barricadeValue the barricadeValue to set
	 */
	public void setBarricadeValue(int barricadeValue) {
		this.barricadeValue = barricadeValue;
	}

	/**
	 * @return the barricadeIcon
	 */
	public ImageIcon getBarricadeIcon() {
		return barricadeIcon;
	}

	/**
	 * @param barricadeIcon the barricadeIcon to set
	 */
	public void setBarricadeIcon(ImageIcon barricadeIcon) {
		this.barricadeIcon = barricadeIcon;
	}
}