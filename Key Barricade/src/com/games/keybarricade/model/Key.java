package com.games.keybarricade.model;

import static com.games.keybarricade.common.Constants.KEY_IMAGE_PATH;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a key.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class Key extends Block {

	private ImageIcon keyIcon;
	private JLabel iconWrap;
	private JLabel iconValue;

	/**
	 * Parameterized constructor for initializing a key.
	 * 
	 * @param value	Key value
	 */
	public Key(int value) {
		keyIcon = new ImageIcon(this.getClass().getResource(KEY_IMAGE_PATH));

		iconWrap = new JLabel();
		iconWrap.setBounds(4, 4, keyIcon.getIconWidth(), keyIcon.getIconHeight());
		iconWrap.setIcon(keyIcon);

		iconValue = new JLabel(Integer.toString(value));
		iconValue.setFont(new Font("Calibri", Font.BOLD, 13));
		iconValue.setForeground(Color.WHITE);
		iconValue.setBounds(19, 7, 22, 10);
		iconValue.setForeground(Color.BLACK);

		this.setLayout(null);
		this.add(iconValue);
		this.add(iconWrap);
	}
}