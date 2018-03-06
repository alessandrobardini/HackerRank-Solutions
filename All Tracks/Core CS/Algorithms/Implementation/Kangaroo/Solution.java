import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Since x1 < x2, if v1 <= v2 the two kangaroos will never land at the same location at the same time
 * (the first kangaroo is slower than the second).
 * In all the other cases, we have the solve the equation x1 + t*v1 = x2 + t*v2, where t is the number of jumps.
 * t must be an integer value, so it's sufficient to verify that (x2 - x1) % (v1 - v2) == 0.
 */


public class Solution {
	 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int v1 = sc.nextInt();
		int x2 = sc.nextInt();
		int v2 = sc.nextInt();
		sc.close();

		System.out.println((v1 <= v2 || (x2 - x1) % (v1 - v2) != 0) ? "NO" : "YES");
            
	}
}
