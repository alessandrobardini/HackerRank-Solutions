import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * We first find the cycle of the counter at time t.
 * Given the upper limit of the cycle's interval, the answer is 1 + upperLimit - t.
 */

public class Solution {

    public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		long upperLimit = 3;
		long lowerLimit = 1;
		while (!(t >= lowerLimit && t <= upperLimit)) {
			lowerLimit = upperLimit + 1;
			upperLimit = (upperLimit * 2) + 3;

		}

		System.out.println(1 + upperLimit - t);

		in.close();
	}
}

