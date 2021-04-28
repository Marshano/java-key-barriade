package com.games.keybarricade.model;

import static com.games.keybarricade.common.Constants.WALL_IMAGE_PATH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a wall.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class Wall extends Block {

	private ImageIcon wallIcon;
	private JLabel iconWrap;

	/**
	 * Default constructor for initializing a wall.
	 */
	public Wall() {
		wallIcon = new ImageIcon(this.getClass().getResource(WALL_IMAGE_PATH));

		iconWrap = new JLabel();
		iconWrap.setBounds(4, 4, wallIcon.getIconWidth(), wallIcon.getIconHeight());
		iconWrap.setIcon(wallIcon);

		this.setLayout(null);
		this.add(iconWrap);
	}
}