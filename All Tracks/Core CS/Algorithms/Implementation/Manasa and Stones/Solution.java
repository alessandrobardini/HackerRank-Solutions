import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * The final stones are the values included in the range [a * (n - 1), b * (n - 1)] with step (b - a).
 */

public class Solution {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			TreeSet<Integer> stones = new TreeSet<>();

			int finalStone = a * (n - 1);
			stones.add(finalStone);

			while (finalStone != b * (n - 1)) {
				finalStone += (b - a);
				stones.add(finalStone);
			}

			for (Integer stone : stones) {
				System.out.print(stone + " ");
			}

			System.out.println();
		}

		sc.close();
	}
}

