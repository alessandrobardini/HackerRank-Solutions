import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * The problem is straightforward, we have only to take into account that:
 * 1) it's necessary to perform a casting to long when computing the squares of the numbers, 
 * since the maximum number could be 99999 (see the constraints in the problem).
 * 2) in case of small numbers, the left hand piece (variable 'left') is the empty string, since the square has only one digit. 
 * In this case, we have to sum 0.
 */

public class Solution {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();

		ArrayList<Integer> kaprekarNumbers = new ArrayList<>();

		for (int i = p; i <= q; i++) {
			String square = String.valueOf((long) Math.pow(i, 2));
			int squareDigits = square.length();
			int right = Integer.parseInt(square.substring(squareDigits / 2, squareDigits));
			int left = squareDigits == 1 ? 0 : Integer.parseInt(square.substring(0, squareDigits / 2));
			if (right + left == i) {
				kaprekarNumbers.add(i);

			}
		}

		if (kaprekarNumbers.size() != 0) {
			for (Integer kaprekar : kaprekarNumbers) {
				System.out.print(kaprekar + " ");
			}
		} else {
			System.out.println("INVALID RANGE");
		}

		sc.close();
	}


}

