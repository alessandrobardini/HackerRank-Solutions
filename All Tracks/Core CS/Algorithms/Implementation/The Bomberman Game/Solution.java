import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Since detonations take place only at odd times, if n (the number of seconds) is even,
 * the grid is composed only of O (gridAtEvenTimes).
 * At n == 1, no detonations take place, so the grid is the starting grid (initialGrid).
 * At n == 3, the first detonation happens (gridAfterFirstDetonation).
 * After this second, we note that there is a recurrent pattern that repeat itself every 4 seconds: 
 * - at n == 5, 9, 13, ... (i.e. when n % 4 == 1), the grid is equal to gridAfterSecondDetonation
 * - at n == 7, 11, 15, ... (i.e when n % 4 == 3), the grid is equal to gridAfterThirdDetonation
 */

public class Solution {

   static char[][] bomberMan(int n, int c, int r, char[][] initialGrid) {
		char[][] gridAfterFirstDetonation = new char[r][c];
		char[][] gridAfterSecondDetonation = new char[r][c];
		char[][] gridAfterThirdDetonation = new char[r][c];
		char[][] gridAtEvenTimes = new char[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				gridAfterSecondDetonation[i][j] = 'O';
				gridAfterThirdDetonation[i][j] = 'O';
				gridAtEvenTimes[i][j] = 'O';
				gridAfterFirstDetonation[i][j] = 'O';
			}
		}

		gridAfterFirstDetonation = createGrid(r, c, initialGrid, gridAfterFirstDetonation);

		if (n % 2 == 0) {
			return gridAtEvenTimes;
		} else if (n < 4) {
			{
				if (n == 1) {
					return initialGrid;
				}
				if (n == 3) {
					return gridAfterFirstDetonation;
				}

			}
		} else {
			gridAfterSecondDetonation = createGrid(r, c, gridAfterFirstDetonation, gridAfterSecondDetonation);
			gridAfterThirdDetonation = createGrid(r, c, gridAfterSecondDetonation, gridAfterThirdDetonation);

			if (n % 4 == 1) {
				return gridAfterSecondDetonation;
			} else {
				return gridAfterThirdDetonation;
			}
		}

		return null;
	}

	private static char[][] createGrid(int r, int c, char[][] gridAtPreviousStep, char[][] gridAtNextStep) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				char currentCell = gridAtPreviousStep[i][j];
				if (currentCell == 'O') {
					gridAtNextStep[i][j] = '.';
					if (i - 1 >= 0) {
						gridAtNextStep[i - 1][j] = '.';
					}
					if (i + 1 <= r - 1) {
						gridAtNextStep[i + 1][j] = '.';
					}
					if (j - 1 >= 0) {
						gridAtNextStep[i][j - 1] = '.';
					}
					if (j + 1 <= c - 1) {
						gridAtNextStep[i][j + 1] = '.';
					}

				}

			}

		}

		return gridAtNextStep;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();
		int n = in.nextInt();
		char[][] initialGrid = new char[r][c];
		for (int i = 0; i < r; i++) {
			String currentLine = in.next();
			for (int j = 0; j < c; j++) {
				initialGrid[i][j] = currentLine.charAt(j);
			}
		}
		char[][] result = bomberMan(n, c, r, initialGrid);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

		in.close();
	}


}

