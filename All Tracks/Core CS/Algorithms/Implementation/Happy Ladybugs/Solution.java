import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
 * We can make the ladybugs happy in two cases:
 * a) there is at least one empty cell and there are at least two ladybugs for each color.
 * b) the initial configuration is happy (i.e. it is already composed of happy ladybugs).
 */

public class Solution {

   public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int games = sc.nextInt();

		for (int i = 0; i < games; i++) {

			boolean thereIsAnEmptyCell = false;
			boolean alreadyHappyLadybugs = true;
			HashMap<Character, Boolean> happyLadybugs = new HashMap<>();

			int numberOfCells = sc.nextInt();
			String string = sc.next();

			for (int j = 0; j < string.length(); j++) {
				char currentCell = string.charAt(j);
				if (currentCell != '_') {

                    // We create the ladybugs maps, with a ladybug's color as key
                    // and true (if there are at least two ladybugs of that color)
                    // or false (otherwise) as value.
					if (happyLadybugs.containsKey(currentCell)) {
						happyLadybugs.put(currentCell, true);
					} else {
						happyLadybugs.put(currentCell, false);
					}
                    
                    // If the current ladybug's color is not present neither in the previous cell 
                    // nor in the next, it means that the current ladybug is not happy,
                    // so the initial configuration is not happy.
					if (j == 0) {
						if (string.length() != 1) {
							if (string.charAt(1) != currentCell) {
								alreadyHappyLadybugs = false;
							}
						} else {
                            alreadyHappyLadybugs = false;
                        }
					} else if (j != 0 && j != string.length() - 1) {
						if (!(string.charAt(j - 1) == currentCell || string.charAt(j + 1) == currentCell)) {
							alreadyHappyLadybugs = false;
						}
					} else if (j == string.length() - 1) {
						if (string.charAt(string.length() - 2) != currentCell) {
							alreadyHappyLadybugs = false;
						}
					}

				} else {
					thereIsAnEmptyCell = true;
				}

			}

			boolean singleLadybug = false;

            // if one value of the ladybugs map is equal to false, it means that there is
            // only one ladybug of that color
			for (HashMap.Entry<Character, Boolean> entry : happyLadybugs.entrySet()) {
				if (!entry.getValue()) {
					singleLadybug = true;
					break;
				}
			}

			if (alreadyHappyLadybugs || (!singleLadybug && thereIsAnEmptyCell)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

		sc.close();
	}
}

