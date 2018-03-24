import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * a) We create an array 'flatland' whose elements are 1 (if there is a station associated to that index) or 0 (if there isn't a station).
 * b) and c) We create two arrays, 'distancesFromLeftStation' and 'distancesFromRightStation', where we store, for each index, the distance
 * from the nearest left and right station, respectively. 
 * Beware that if we haven't met any station yet, we have to store an infinite distance value.
 * Example:
 * 20 5
 * 13 1 11 10 6
 * 
 * distancesFromLeftStation = [2147483647 0 1 2 3 4 0 1 2 3 0 0 1 0 1 2 3 4 5 6 ]
 * distancesFromRightStation = [1 0 4 3 2 1 0 3 2 1 0 0 1 0 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647]
 * 
 * d) Finally, for each index, we compare the associated left and right distances to determine which one is smaller. 
 * Among all these values, the answer is the maximum one.
 */

public class Solution {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] flatland = new int[n];
		int[] distancesFromLeftStation = new int[n];
		int[] distancesFromRightStation = new int[n];

		// a)
		
		for (int i = 0; i < m; i++) {
			flatland[sc.nextInt()] = 1;
		}

		// b)
		
		int currentDistance = Integer.MAX_VALUE;
		boolean searchingForTheFirstStation = true;

		for (int i = 0; i < n; i++) {
			if (searchingForTheFirstStation) {
				if (flatland[i] == 1) {
					searchingForTheFirstStation = false;
					currentDistance = 0;
				}
			} else {
				if(flatland[i] == 1) {
					currentDistance = 0;
				} else {
					currentDistance++;
				}
			}
			distancesFromLeftStation[i] = currentDistance;
		}

		//c)
		
		currentDistance = Integer.MAX_VALUE;
		searchingForTheFirstStation = true;

		for (int i = n - 1; i >= 0; i--) {
			if (searchingForTheFirstStation) {
				if (flatland[i] == 1) {
					searchingForTheFirstStation = false;
					currentDistance = 0;
				}
			} else {
				if(flatland[i] == 1) {
					currentDistance = 0;
				} else {
					currentDistance++;
				}
			}
			distancesFromRightStation[i] = currentDistance;
		}

		int maxDistance = 0;
		
		//d)

		for (int i = 0; i < n; i++) {
			maxDistance = Math.max(maxDistance, Math.min(distancesFromLeftStation[i], distancesFromRightStation[i]));
		}

		System.out.println(maxDistance);

		sc.close();
	}

}

