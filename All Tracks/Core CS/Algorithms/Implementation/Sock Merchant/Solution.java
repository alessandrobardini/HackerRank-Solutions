import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* 
 * We use the frequency array 'is_even' to keep track of the frequencies of all the possible colors:
 * each index of the array corresponds to a possible color.
 * If the color i is appeared an odd number of times, we cannot sell a pair of socks, but is_even[i] is set to
 * false, in such a way that the next time the color i appear, we can make a pair of socks of the same color.
 * If the color i is appeared an even number of times, we can sell a pair of socks, but it is necessary to set
 * is_even[i] to true, since we can encounter other socks of the same color and repeat the process described above.
 * In this time, we implement an optimized solution with a time complexity of O(n).
 */

public class Solution {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int pairOfSocks = 0;
		boolean[] isEven = new boolean[101];
		Arrays.fill(isEven, Boolean.TRUE);

		for (int i = 0; i < n; i++) {
			int currentColor = sc.nextInt();
			if (isEven[currentColor]) {
				isEven[currentColor] = false;
			} else {
				isEven[currentColor] = true;
				pairOfSocks++;
			}
		}

		sc.close();

		System.out.println(pairOfSocks);
	}
}
