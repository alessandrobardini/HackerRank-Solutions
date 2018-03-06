import java.io.*;
import java.util.*;

/*
 * Starting from the prisoner s, if the number of prisoners were infinite , the last sweet would be given 
 * to the prisoner at index s - 1 + m.
 * Since the number of prisoners if limited, when we reach the last prisoner (i.e. the prisoner at index n),
 * we have to come back to prisoner at index 1.
 * So it's necessary to use the modulus operation ( % n).
 * If the lastSweetIndex is 0, the last sweet is given to prisoner at index n.
 */

public class Solution {
	
	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int s = scanner.nextInt();
			int lastSweetIndex = (s - 1 + m) % n;
            System.out.println(lastSweetIndex == 0 ? n : lastSweetIndex);
		}
        
        scanner.close();
	}

}