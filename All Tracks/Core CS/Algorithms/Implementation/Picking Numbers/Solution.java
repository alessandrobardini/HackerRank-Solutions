import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * The condition "The absolute difference between any two of the chosen integers is <= 1" means that the number we choose are:
 * a) integer with identical value (absolute difference == 0) 
 * or 
 * b) consecutive integers (absolute difference == 1).
 * So it is a good idea to create a frequency array that counts the occurrences of the numbers and then 
 * iterate through the array to find the maximum value between consecutive elements (i.e. consecutive frequencies).
 * In this way, we handle case a) and case b).
 *
 * Example case a):
 * 6
 * 1 1 1 4 5 6 
 * The frequency array is [3, 0, 0, 1, 1, 1] and the maximum value is 3 (3 + 0)
 *
 * Example case b):
 * 6
 * 1 1 2 3 5 2 
 * The frequency array is [2, 2, 1, 1, 0] and the maximum value is 4 (2 + 2)
 * 
 */

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] freq = new int[100];
		for (int i = 0; i < n; i++) {
			freq[sc.nextInt()] += 1;
		}
		sc.close();
		int max = 0;
		for (int i = 1; i < freq.length; i++) {
			max = Math.max(max, freq[i] + freq[i - 1]);
		}
		
		System.out.println(max);
	}
}
