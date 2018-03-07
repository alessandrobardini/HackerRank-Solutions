import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * BigInteger class is used for mathematical operations (such as the factorial of this problem)
 * which involves very big integer calculations that are outside the limit of all available primitive data types.
 * In Java, when we handle values greater than Long.MAX_VALUE (9,223,372,036,854,775,807),
 * it's necessary to use the BigInteger class.
 */

public class Solution {
	
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		BigInteger result = BigInteger.valueOf(n);
		while(n != 1){
			n--;
			result = result.multiply(BigInteger.valueOf(n));
		}
        
        sc.close();
        
		System.out.println(result);
	}
}