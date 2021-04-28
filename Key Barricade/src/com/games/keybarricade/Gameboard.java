package com.games.keybarricade;

import static com.games.keybarricade.common.Constants.GAME_FILE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import com.games.keybarricade.common.Utilities;
import com.games.keybarricade.model.Barricade;
import com.games.keybarricade.model.Block;
import com.games.keybarricade.model.FinishPoint;
import com.games.keybarricade.model.Key;
import com.games.keybarricade.model.Player;
import com.games.keybarricade.model.Tile;
import com.games.keybarricade.model.Wall;

/**
 * This class load, initialize and shows a window to play the Key Barricade game.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class Gameboard extends JFrame {

	private final int WINDOW_WIDTH;
	private final int WINDOW_HEIGHT;
	private final int GAME_WIDTH;
	private int columns;
	private int rows;
	private String boardArray[][];
	private int randomBarricades[];

	private Player player;
	private FinishPoint finishPoint;
	private GameInfo gameInfo;
	private boolean finished;
	private boolean testing;

	/**
	 * Default constructor for initializing gameboard.
	 */
	public Gameboard() {
		// Add keyboard movement listener
		addKeyListener(new GameListener(this));

		this.player = new Player();
		this.boardArray = Utilities.loadGameFromFile(this.getClass().getResourceAsStream(GAME_FILE));
		this.columns = boardArray.length;
		this.rows = boardArray[0].length;

		this.WINDOW_HEIGHT = rows * (player.getBlockHeight() + 1) + 80;
		this.WINDOW_WIDTH = columns * (player.getBlockWidth() + 1) + 200;
		this.GAME_WIDTH = WINDOW_WIDTH - 180;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		getContentPane().setBackground(Color.GRAY);
		buildMenu();
		buildPlayer();
		buildRandomBarricades();
		buildField();
		buildGameInfo();

		setTitle("Key Barricade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setFocusable(true);
		setLocationRelativeTo(null);
	}

	/**
	 * Parameterized constructor for initializing gameboard.
	 * If testing mode is true, game won't show dialog when winning.
	 * 
	 * @param testing	testing mode
	 */
	public Gameboard(boolean testing) {
		this();
		this.testing = testing;
	}

	/**
	 * Builds a menu bar
	 */
	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);

		JMenuItem restartMenuItem = new JMenuItem("Restart");
		gameMenu.add(restartMenuItem);
		gameMenu.add(new JSeparator());
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		gameMenu.add(exitMenuItem);

		// Restart game menu
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});

		// Exit game menu
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		JMenuItem howToPlayMenuItem = new JMenuItem("How to Play");
		helpMenu.add(howToPlayMenuItem);

		// How to play Help menu
		howToPlayMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				howToPlay();
			}
		});

		setJMenuBar(menuBar);
	}

	/**
	 * Builds a Player
	 */
	private void buildPlayer() {
		Main: for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				// P denotes a Player
				if (getBoardValueAt(x, y).equalsIgnoreCase("P")) {
					player.setLocation(x * (player.getBlockWidth() + 1) + 10, y * (player.getBlockHeight() + 1) + 10);
					add(player);
					player.setCurrentX(x);
					player.setCurrentY(y);
					break Main;
				}
			}
		}
	}

	/**
	 * Randomly generates and builds barricades
	 */
	private void buildRandomBarricades() {
		this.randomBarricades = new int[rows * columns];
		Random random = new Random();
		int i = 0;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				if (getBoardValueAt(x, y).equals("R")) {
					int value;
					do {
						value = random.nextInt(10) * 10;
					} while (value >= 100 && value <= 300);
					randomBarricades[i++] = value;
				}
			}
		}
	}

	/**
	 * Builds a specific block for game board cell block.
	 */
	private void buildField() {
		int i = 0;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				Block block = null;
				switch (getBoardValueAt(x, y)) {
					case "0":
						block = new Wall();
						break;
					case "1":
						block = new Tile();
						break;
					case "2":
						block = new Barricade(100);
						break;
					case "3":
						block = new Key(100);
						break;
					case "4":
						block = new Barricade(200);
						break;
					case "5":
						block = new Key(200);
						break;
					case "6":
						block = new Barricade(300);
						break;
					case "7":
						block = new Key(300);
						break;
					case "R":
						block = new Barricade(this.randomBarricades[i++]);
						break;
					case "F":
						finishPoint = new FinishPoint();
						finishPoint.setLocation(x * (finishPoint.getBlockWidth() + 1) + 10,
								y * (player.getBlockHeight() + 1) + 10);
						add(finishPoint);
						break;
					default:
						block = new Tile();
						break;
				}
				if (block != null) {
					block.setLocation(x * (block.getBlockWidth() + 1) + 10, y * (block.getBlockHeight() + 1) + 10);
					add(block);
				}
			}
		}
	}

	/**
	 * Builds a game info panel
	 */
	private void buildGameInfo() {
		gameInfo = new GameInfo();
		gameInfo.setSize(170, WINDOW_HEIGHT);
		gameInfo.setLocation(GAME_WIDTH, 0);
		add(gameInfo);
	}

	/**
	 * Restarts or resets the game
	 */
	private void restartGame() {
		finished = false;
		boardArray = Utilities.loadGameFromFile(this.getClass().getResourceAsStream(GAME_FILE));
		getContentPane().removeAll();

		buildPlayer();
		buildField();
		buildGameInfo();

		player.setKeyValue(0);
		setFocusable(true);

		repaint();
		revalidate();
	}
	
	/**
	 * Shows a dialog on how to play the game
	 */
	private void howToPlay() {
		JOptionPane.showMessageDialog(this,
				"Use arrow keys left, right, top, down to move player.\nUse space to pickup the key.", "Key Barricade",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Returns the block type from x,y position from gameboard
	 * 
	 * @param x	x position
	 * @param y	y position
	 * @return	block type
	 */
	public String getBoardValueAt(int x, int y) {
		return boardArray[y][x];
	}

	/**
	 * Sets the block type at given x and y position in gameboard 
	 * 
	 * @param x	x position
	 * @param y	y position
	 * @param value	block type
	 */
	public void setBoardValueAt(int x, int y, String value) {
		this.boardArray[y][x] = value;
		getContentPane().removeAll();
		getContentPane().add(gameInfo);
		getContentPane().add(player);
		buildField();
		player.setLocation(player.getCurrentX() * (player.getBlockWidth() + 1) + 10,
				player.getCurrentY() * (player.getBlockHeight() + 1) + 10);
	}

	/**
	 * Checks and returns true if move was valid otherwise false.
	 * 
	 * @param oldX	previous x position
	 * @param oldY	previous y position
	 * @param newX	new x position
	 * @param newY	new y position
	 * @return	valid move or not
	 */
	public boolean isValidMove(int oldX, int oldY, int newX, int newY) {
		// Invalid move if position is out of gameboard
		if (newX <= -1 || newY <= -1 || newX >= columns || newY >= rows) {
			return false;
		}

		String currentValue = getBoardValueAt(oldX, oldY);
		String destinationValue = getBoardValueAt(newX, newY);
		int currentKeyValue = player.getKeyValue();
		String barricadeValue;

		if (currentKeyValue == 100) {
			barricadeValue = "2";
		} else if (currentKeyValue == 200) {
			barricadeValue = "4";
		} else if (currentKeyValue == 300) {
			barricadeValue = "6";
		} else {
			barricadeValue = "0";
		}

		// If the destination value is not a wall
		if (!destinationValue.equals("0")) {
			if (!barricadeValue.equals(destinationValue) && (destinationValue.equals("2")
					|| destinationValue.equals("4") || destinationValue.equals("6") || destinationValue.equals("R"))) {
				// If key value doesn't match with barricade value or random barricade
				gameInfo.setErrorMessage("Invalid move!");
				gameInfo.addTotalErrorsCount();
				return false;
			} else {
				// Remove any previous error message
				gameInfo.removeErrorMessage();
				
				// Collect the barricade
				if (barricadeValue.equals(destinationValue)) {
					gameInfo.addTotalBarricadesCollected();
				}
				
				// Replace the barricade for a new tile
				if (currentValue.equals(barricadeValue)) {
					setBoardValueAt(oldX, oldY, "1");
					player.setKeyValue(currentKeyValue);
				}
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * @return Player the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return GameInfo the game info
	 */
	public GameInfo getGameInfo() {
		return gameInfo;
	}

	/**
	 * @param finished	finished to set
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	 * @return	finished the finished
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * @return testing the testing
	 */
	public boolean isTesting() {
		return testing;
	}
}