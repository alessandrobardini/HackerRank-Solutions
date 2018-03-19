import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * At the beginning, we have have an amount of wrappers equal to the amount of chocolate bought.
 * We can exchange the wrappers for more chocolate until the remaining wrappers are >= the 'wrappersExchange'.
 * At each iteration, the numbers of wrappers is equal to the sum of the amount of chocolate just bought using
 * the previous wrappers (wrappers / wrappersExchange) and the the amount of unused wrappers (wrappers % wrappersExchange).
 */

public class Solution {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int money = sc.nextInt();
			int cost = sc.nextInt();
			int wrappersExchange = sc.nextInt();

			int chocolateBought = money / cost;
			int wrappers = chocolateBought;

			while (wrappers >= wrappersExchange) {
				chocolateBought += wrappers / wrappersExchange;
				wrappers = (wrappers / wrappersExchange) + (wrappers  % wrappersExchange);
			} 

			System.out.println(chocolateBought);
		}

		sc.close();
	}
}

