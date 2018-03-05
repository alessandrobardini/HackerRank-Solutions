import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * We must distinguish three cases, depending on the year (year < 1918, year == 1918 and year > 1918),
 * and determine if the year is leap or not according to the rules described in the problem statement.
 */

public class Solution {

   public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int year = scanner.nextInt();

		scanner.close();

		if (year < 1918) {
			if (year % 4 == 0) {
				System.out.println("12.09." + year);
			} else {
				System.out.println("13.09." + year);
			}
		} else if (year == 1918) {
			System.out.println("26.09." + year);
		} else {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				System.out.println("12.09." + year);
			} else {
				System.out.println("13.09." + year);
			}

		}

	}
}
