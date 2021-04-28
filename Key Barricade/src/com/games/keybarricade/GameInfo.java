package com.games.keybarricade;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class provides game states information.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class GameInfo extends JPanel {

	private JLabel totalSteps;
	private JLabel currentKey;
	private JLabel keysCollected;
	private JLabel barricadesCollected;
	private JLabel totalErrors;
	private JLabel errorMessage;

	private int totalStepsCount;
	private int currentKeyValue;
	private int totalKeysCollected;
	private int totalBarricadesCollected;
	private int totalErrorsCount;

	/**
	 * Default constructor for initializing game state
	 */
	public GameInfo() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		totalSteps = new JLabel("Total Steps : " + totalStepsCount);
		totalSteps.setSize(200, 20);
		totalSteps.setLocation(10, 10);
		add(totalSteps);

		currentKey = new JLabel("Current Key : " + totalErrorsCount);
		currentKey.setSize(200, 20);
		currentKey.setLocation(10, 30);
		add(currentKey);

		keysCollected = new JLabel("Keys Collected : " + totalKeysCollected);
		keysCollected.setSize(200, 20);
		keysCollected.setLocation(10, 50);
		add(keysCollected);

		barricadesCollected = new JLabel("Barricades Collected : " + totalBarricadesCollected);
		barricadesCollected.setSize(200, 20);
		barricadesCollected.setLocation(10, 70);
		add(barricadesCollected);

		totalErrors = new JLabel("Total Errors : " + currentKeyValue);
		totalErrors.setSize(200, 20);
		totalErrors.setLocation(10, 90);
		add(totalErrors);

		errorMessage = new JLabel();
		errorMessage.setSize(200, 20);
		errorMessage.setLocation(10, 110);
		errorMessage.setForeground(Color.RED);
		add(errorMessage);
	}

	/**
	 * @return the totalStepsCount
	 */
	public int getTotalStepsCount() {
		return totalStepsCount;
	}

	/**
	 * @param totalStepsCount the totalStepsCount to set
	 */
	public void setTotalStepsCount(int totalStepsCount) {
		this.totalStepsCount = totalStepsCount;
	}

	/**
	 * @return the currentKeyValue
	 */
	public int getCurrentKeyValue() {
		return currentKeyValue;
	}

	/**
	 * @param currentKeyValue the currentKeyValue to set
	 */
	public void setCurrentKeyValue(int currentKeyValue) {
		this.currentKeyValue = currentKeyValue;
	}

	/**
	 * @return the totalKeysCollected
	 */
	public int getTotalKeysCollected() {
		return totalKeysCollected;
	}

	/**
	 * @param totalKeysCollected the totalKeysCollected to set
	 */
	public void setTotalKeysCollected(int totalKeysCollected) {
		this.totalKeysCollected = totalKeysCollected;
	}

	/**
	 * @return the totalBarricadesCollected
	 */
	public int getTotalBarricadesCollected() {
		return totalBarricadesCollected;
	}

	/**
	 * @param totalBarricadesCollected the totalBarricadesCollected to set
	 */
	public void setTotalBarricadesCollected(int totalBarricadesCollected) {
		this.totalBarricadesCollected = totalBarricadesCollected;
	}

	/**
	 * @return the totalErrorsCount
	 */
	public int getTotalErrorsCount() {
		return totalErrorsCount;
	}

	/**
	 * @param totalErrorsCount the totalErrorsCount to set
	 */
	public void setTotalErrorsCount(int totalErrorsCount) {
		this.totalErrorsCount = totalErrorsCount;
	}

	/**
	 * Increment in total keys collected
	 */
	public void addTotalKeysCollected() {
		this.totalKeysCollected++;
	}

	/**
	 * Increment in total barricades collected
	 */
	public void addTotalBarricadesCollected() {
		this.totalBarricadesCollected++;
	}

	/**
	 * Increment in total steps count
	 */
	public void addTotalStepsCount() {
		this.totalStepsCount++;
	}

	/**
	 * Increment in total errors count
	 */
	public void addTotalErrorsCount() {
		this.totalErrorsCount++;
	}

	/**
	 * @param message the error message to set
	 */
	public void setErrorMessage(String message) {
		this.errorMessage.setText(message);
	}

	/**
	 * Clears the error message
	 */
	public void removeErrorMessage() {
		this.setErrorMessage("");
	}

	/**
	 * Refreshes the game state with latest values
	 */
	public void refreshValues() {
		totalSteps.setText("Total Steps : " + totalStepsCount);
		currentKey.setText("Current Key : " + currentKeyValue);
		keysCollected.setText("Keys Collected : " + totalKeysCollected);
		barricadesCollected.setText("Barricades Collected : " + totalBarricadesCollected);
		totalErrors.setText("Total Errors : " + totalErrorsCount);
	}
}