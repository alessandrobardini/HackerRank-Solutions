import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		ArrayList<Integer> unsortedList = new ArrayList<>();
		ArrayList<Integer> sortedList = new ArrayList<>();

		// We save the sequence in two arrays
		for (int i = 0; i < n; i++) {
			int currentNumber = sc.nextInt();
			unsortedList.add(currentNumber);
			sortedList.add(currentNumber);
		}

		sc.close();

		// We sort the sequence contained in sortedList
		Collections.sort(sortedList);

		int numberOfDifferences = 0;
		int startSwapIndex = 0;
		int endSwapIndex = 0;

		// We find the number of differences between the sorted and the unsorted list. 
		// We save the indexes of the first and the last difference: they will be used to check if 
		// the sub-array delimited by them is sorted in descending order.
		for (int i = 0; i < n; i++) {
			if (!unsortedList.get(i).equals(sortedList.get(i))) {
				numberOfDifferences++;
				if (numberOfDifferences == 1) {
					startSwapIndex = i;
				}
				if (numberOfDifferences >= 2) {
					endSwapIndex = i;
				}

			}
		}

		// If there are no differences, the original array was already sorted.
		if (numberOfDifferences == 0) {
			System.out.println("yes");
		// If there are two differences, we can sort the array with a single swap.
		} else if (numberOfDifferences == 2) {
			System.out.println(
					"yes\nswap " + Integer.valueOf(startSwapIndex + 1) + " " + Integer.valueOf(endSwapIndex + 1));
		
		// Else we check if it's possible to sort the array by reverting a sub-segment.
		} else {
			boolean canBeOrdered = true;
			List<Integer> subArray = unsortedList.subList(startSwapIndex, endSwapIndex + 1);
			for (int i = 1; i < subArray.size(); i++) {
				if (subArray.get(i) > subArray.get(i - 1)) {
					canBeOrdered = false;
					break;
				}
			}
			if (canBeOrdered) {
				System.out.println("yes\nreverse " + Integer.valueOf(startSwapIndex + 1) + " "
						+ Integer.valueOf(endSwapIndex + 1));
			} else {
				System.out.println("no");
			}
		}

	}
}

