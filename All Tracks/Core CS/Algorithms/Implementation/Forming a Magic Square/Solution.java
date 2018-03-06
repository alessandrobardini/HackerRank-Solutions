import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * We have to find all the possible 3x3 magic squares and, for each of them, compute the cost of turning 
 * the given square into a magic square: the cost corresponds to the cost of changing all its cells
 * into the corresponding cells of the magic square (i.e. for the cell (i,j), the cost is the absolute difference
 * between the cell (i,j) of the given square and the cell (i,j) of the magic square).
 * After we have computed all the 8 costs, we keep the minimum cost.
 * Remember that Google is your friend: the quickest way to find all the 8 magic squares is through a web search :)
 * In this way, we hard-code the 8 magic squares into the solution.
 */

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] square = new int[3][3];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				square[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int[][] magicSquare1 = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };
		int[][] magicSquare2 = { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } };
		int[][] magicSquare3 = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
		int[][] magicSquare4 = { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } };
		int[][] magicSquare5 = { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } };
		int[][] magicSquare6 = { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } };
		int[][] magicSquare7 = { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } };
		int[][] magicSquare8 = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
		ArrayList<int[][]> magicSquares = new ArrayList<>();
		magicSquares.add(magicSquare1);
		magicSquares.add(magicSquare2);
		magicSquares.add(magicSquare3);
		magicSquares.add(magicSquare4);
		magicSquares.add(magicSquare5);
		magicSquares.add(magicSquare6);
		magicSquares.add(magicSquare7);
		magicSquares.add(magicSquare8);

		int minimumCost = Integer.MAX_VALUE;

		for (int[][] magicSquare : magicSquares) {
			int currentCost = 0;
			for (int i = 0; i < magicSquare.length; i++) {
				for (int j = 0; j < magicSquare.length; j++) {
					currentCost += Math.abs(magicSquare[i][j] - square[i][j]);
				}
			}
			minimumCost = Math.min(minimumCost, currentCost);
		}

		System.out.println(minimumCost);

	}
}

