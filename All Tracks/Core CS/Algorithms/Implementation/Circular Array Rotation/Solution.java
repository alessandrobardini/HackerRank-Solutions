import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * a) We create the array shifted by k.
 * b) We print the element of the shifted array at a given position.
 */

public class Solution {

    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		
		int[] array = new int[n];
		
		// a)
		for (int i = 0; i < n; i++) {
			array[(i + k) % n] = sc.nextInt();
		}
		
		// b)
		for (int i = 0; i < q; i++) {
			System.out.println(array[sc.nextInt()]);
		}
		
		sc.close();
	}
}