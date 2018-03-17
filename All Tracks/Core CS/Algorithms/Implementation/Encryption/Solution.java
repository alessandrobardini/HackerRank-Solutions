import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * We can implement an optimized solution that avoids to create a 2D array:
 * we simply "jump" over the desired characters of the initial string and build, step by step,
 * the encrypted string.
 * Note that both the loops operate in the range(0, columns): if we consider the range (0, rows) for the inner
 * loop (where rows is, as defined in the problem, the floor of the length of the string), we would skip
 * the last row if the last row contains less elements than the number of columns,
 * as happens in the following case:
 * 
 * chillout 
 * 
 * chi
 * llo
 * ut
 * 
 */

public class Solution {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int length = str.length();

		int columns = (int) Math.ceil(Math.sqrt(length));

		String encryptedString = "";

		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < columns; i++) {
				if (j + i * columns < length) {
					encryptedString += str.charAt(j + i * columns);
				}
			}
			encryptedString += " ";

		}

		System.out.println(encryptedString);

		sc.close();
	}
}

