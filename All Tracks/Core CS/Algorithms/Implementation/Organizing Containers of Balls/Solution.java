import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * We create an array 'containers' whose elements are the number of balls in every container
 * and another array 'colors' with the number of balls of each color.
 * For each color, we have to find a container capable to contain all the balls of that color.
 * To do this, it is sufficient to sort the arrays 'containers' and 'colors' and check if they are equal: 
 * if they are equal, the answer is possible. 
 */

public class Solution {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		int testCasesNumber = sc.nextInt();
		
		for (int i = 0; i < testCasesNumber; i++) {
			int n = sc.nextInt();
            int[] containers = new int[n];
            int[] colors = new int[n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                	int currentElement = sc.nextInt();
                    containers[j] += currentElement;
                    colors[k] += currentElement;
                }
            }
            
            Arrays.sort(containers);
            Arrays.sort(colors);
            System.out.println(Arrays.equals(containers, colors) ? "Possible" : "Impossible");
		}
		sc.close();
			
	}

}

