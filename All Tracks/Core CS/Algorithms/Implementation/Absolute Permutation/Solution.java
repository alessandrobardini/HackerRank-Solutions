import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Let's consider the different cases:
 * 1) If k = 0, we simply print all the numbers between 1 and n
 * 2) If n is odd, there is no possible permutation
 * 3) If n % (2 * k) == 0, there is no possible permutation
 * 4) In all the other cases, the permutation is composed by n / k subsequences with length k:
 * 
 * Example:
 * n = 8 k = 2
 * The permutation is 3 4 1 2 7 8 5 6 
 * We clearly see 4 subsequences of 2 consecutive numbers 
 * 
 * Example:
 * n = 6 k = 3
 * The permutation is 4 5 6 1 2 3
 * We clearly see 2 subsequences of 3 consecutive numbers 
 * 
 * The permutation always follows a fixed pattern and can be created in a trivial way.
 */

public class Solution {

    static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();

			if (k == 0) {
				for (int i = 1; i <= n; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
			} else if (n % 2 == 0 && n % (2 * k) == 0) {
				int blocks = n / k;
				int currentNumber = k;
				for (int i = 0; i < blocks; i++) {
					for (int j = 0; j < k; j++) {
						currentNumber++;
						System.out.print(currentNumber + " ");

					}
					if (i % 2 != 0) {
						currentNumber = currentNumber + (2 * k);
					} else {
						currentNumber = currentNumber - (2 * k);
					}
				}
				System.out.println();
			} else {
				System.out.println(-1);
			}

		}
	}				
}

