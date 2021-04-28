package com.games.keybarricade.model;

import static com.games.keybarricade.common.Constants.DOOR_IMAGE_PATH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a finish point i.e. winning door.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class FinishPoint extends Block {

	private ImageIcon finIcon;
	private JLabel iconWrap;

	/**
	 * Default constructor for initializing a finish point.
	 */
	public FinishPoint() {
		finIcon = new ImageIcon(this.getClass().getResource(DOOR_IMAGE_PATH));

		iconWrap = new JLabel();
		iconWrap.setBounds(4, 4, finIcon.getIconWidth(), finIcon.getIconHeight());
		iconWrap.setIcon(finIcon);

		this.setLayout(null);
		add(iconWrap);
	}
}