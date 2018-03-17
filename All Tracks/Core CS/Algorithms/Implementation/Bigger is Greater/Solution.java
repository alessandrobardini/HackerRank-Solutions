import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * a) We have to find the firstElementToSwap: this is the greatest index i such that 
 * initialString.charAt(i) > initialString.charAt(i - 1).
 * If it's not possible to find the firstElementToSwap, the string is already the biggest permutation.
 * 
 * b) We have to find the secondElementToSwap: this is the greatest index j such that 
 * initialString.charAt(j) > initialString.charAt(indexOfFirstElementToSwap - 1) and
 * j >= indexOfFirstElementToSwap.
 * 
 * c) We swap the firstElementToSwap and the secondElementToSwap.
 * 
 * d) We reverse the substring starting at firstElementToSwap.
 */

public class Solution {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			String initialString = sc.next();
			System.out.println(findNextPermutation(initialString));
		}

		sc.close();
	}

	public static String findNextPermutation(String initialString) {
		
		// a)
		int indexOfFirstElementToSwap = 0;
		for (int i = 1; i < initialString.length(); i++) {
			if (initialString.charAt(i) > initialString.charAt(i - 1)) {
				indexOfFirstElementToSwap = i;
			}
		}
		if (indexOfFirstElementToSwap == 0) {
			return "no answer";
		} else {
			
			// b)
			int indexOfSecondElementToSwap = 0;
			for (int j = indexOfFirstElementToSwap; j < initialString.length(); j++) {
				if (initialString.charAt(j) > initialString.charAt(indexOfFirstElementToSwap - 1)) {
					indexOfSecondElementToSwap = j;
				}
			}

			// c)
			String stringWithSwappedCharacters = swapCharacters(initialString, indexOfFirstElementToSwap - 1,
					indexOfSecondElementToSwap);
			// d)
			String finalString = reverseSubstring(stringWithSwappedCharacters, indexOfFirstElementToSwap,
					initialString.length());
			return finalString;
		}

	}

	public static String swapCharacters(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	}

	public static String reverseSubstring(String text, int startIndex, int endIndex) {
		String result = text.substring(0, startIndex);
		result += new StringBuilder(text.substring(startIndex, endIndex)).reverse().toString();
		result += text.substring(endIndex);
		return result;
	}
}

