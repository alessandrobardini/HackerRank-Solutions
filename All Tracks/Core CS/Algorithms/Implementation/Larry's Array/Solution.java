import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * A rotation does not change the parity of the number of inversions.
 * The array can be sorted only if the initial number of inversions is even
 * (since we want 0 inversions at the end, i.e. an even number).
 */

public class Solution {

    static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			ArrayList<Integer> numbers = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				numbers.add(sc.nextInt());
			}
			
			int numberOfInversions = 0;
			
			for (int k = 0; k < numbers.size(); k++) {
				for (int k2 = k + 1; k2 < numbers.size(); k2++) {
					if(numbers.get(k) > numbers.get(k2)){
						numberOfInversions++;
					}
				}
			}
			
			if(numberOfInversions % 2 == 0){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}			
		}
	}
}

