import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Step a): we create the array 'scores' which contains all the distinct values of the scores. The index corresponding to each value of 'scores' is equal to 
 * the leaderboard position (with an offset of 1) associated with that score.
 * 
 * Example:
 * 100 100 50 40 40 20 10 
 * 
 * scores = [100, 50, 40, 20, 10]
 * 100 is at position 0 and it is the highest value in the leaderboard.
 * 50 is at position 1 and it is the second highest value in the leaderboard and so on.
 * 
 * Step b): for each Alice's score, we search in 'scores' (starting from the last element since 'scores' is decreasing) the first value that is >= than Alice's score and 
 * we print the corresponding position. 
 * Be careful that the position changes depending on whether alice's score is < or = than the score.
 * Thanks to the variable 'currentIndex', we keep track of the elements of 'scores' already visited and we don't iterate through the entire array for every Alice's score,
 * avoiding a TLE (Time Limit Excedeed) for large values of n.
 */

public class Solution {

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		ArrayList<Integer> scores = new ArrayList<>();

		int previousScore = scanner.nextInt();
		scores.add(previousScore);

		// a)
		
		for (int i = 1; i < n; i++) {
			int currentScore = scanner.nextInt();
			if (currentScore != previousScore) {
				scores.add(currentScore);
			}
			previousScore = currentScore;
		}

		int m = scanner.nextInt();

		int currentIndex = scores.size() - 1;

		// b)
		
		for (int i = 0; i < m; i++) {
			int currentAliceScore = scanner.nextInt();
			boolean searchingPosition = true;
			while (searchingPosition) {
				if (currentIndex < 0) {
					System.out.println(1);
					searchingPosition = false;
				} else {
					int currentScore = scores.get(currentIndex);
					if (currentScore == currentAliceScore) {
						System.out.println(currentIndex + 1);
						searchingPosition = false;

					} else if (currentScore > currentAliceScore) {
						System.out.println(currentIndex + 2);
						searchingPosition = false;

					}
					
					else {
						currentIndex--;
					}
				}

			}

		}

		scanner.close();
	}
}