package com.games.keybarricade.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class provides common utility functions.
 * 
 * @author Marshano N. & Karan K.
 *
 */
public class Utilities {

	/**
	 * This method reads and returns game board from given input stream.
	 * 
	 * @param inputStream	input stream for game board
	 * @return	gameboard
	 */
	public static String[][] loadGameFromFile(InputStream inputStream) {
		String[][] game = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			String[] content = bufferedReader.readLine().split(" ");
			game = new String[Integer.parseInt(content[0])][Integer.parseInt(content[1])];

			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					game[i++] = line.split(" ");
				}
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return game;
	}
}