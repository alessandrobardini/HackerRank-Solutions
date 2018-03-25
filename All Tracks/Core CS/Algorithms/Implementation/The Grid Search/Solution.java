import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			String[] G = new String[R];
			for (int j = 0; j < R; j++) {
				G[j] = sc.next();
			}
			int r = sc.nextInt();
			int c = sc.nextInt();
			String[] P = new String[r];
			for (int j = 0; j < r; j++) {
				P[j] = sc.next();
			}

			System.out.println(gridSearch(G, P));
		}

		sc.close();
	}

	private static String gridSearch(String[] G, String[] P) {
		boolean found = false;
		// We iterate through the rows of G
		for (int i = 0; i < G.length; i++) {
			if (found)
				break;
			else {
				String rowToBeFound = P[0];
				// We check if the first row of P is contained in G[i]
				if (G[i].contains(rowToBeFound)) {
					// We find all the startIndexes, i.e. all the indexes of
					// G[i] where P[0] starts
					ArrayList<Integer> startIndexes = findIndexes(G[i], rowToBeFound);
					for (Integer startIndex : startIndexes) {
						if (found)
							break;
						else {
							// if P is made on only one row, found = true
							if (P.length == 1)
								found = true;
							else {
								// We check if the remaining rows of P are equal
								// to the corresponding parts of the rows of P,
								// according to the current startIndex
								for (int j = 1; j < P.length; j++) {
									rowToBeFound = P[j];
									if (i + j < G.length) {	
										if (!G[i + j].substring(startIndex,
												startIndex + rowToBeFound.length()).equals(rowToBeFound)) {
											found = false;
											break;
										} else {
											// If we have reached the last row
											// of P, found = true
											if (j == P.length - 1) {
												found = true;
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return found == true ? "YES" : "NO";
	}

	private static ArrayList<Integer> findIndexes(String string, String stringToBeFound) {

		ArrayList<Integer> startIndexes = new ArrayList<>();
		int index = string.indexOf(stringToBeFound);
		startIndexes.add(index);
		while (index >= 0) {
			index = string.indexOf(stringToBeFound, index + 1);
            if (index != -1)
				startIndexes.add(index);
		}
		return startIndexes;
	}
}

