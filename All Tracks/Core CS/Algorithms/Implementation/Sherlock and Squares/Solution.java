import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * The easiest way is to iterate through the range and, for every number, check if that number is a perfect square.
 * Unfortunately, this approach leads to a TLE.
 * Instead of searching for the perfect squares, we can reverse the problem and search for the integers whose square is
 * included in the initial range.
 * In this way, we define a lower_limit as the smallest integer whose square is greater than 'a' and an upper_limit 
 * as the biggest integer whose square is smaller than 'b'.
 * The number of integers included in the range [a, b] is the solution.
 * Time complexity: O(1)
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int lower_limit = (int)Math.ceil(Math.sqrt(a));
            int upper_limit = (int)Math.floor(Math.sqrt(b));
            System.out.println(upper_limit - lower_limit + 1);
        }
        in.close();
    }
}

