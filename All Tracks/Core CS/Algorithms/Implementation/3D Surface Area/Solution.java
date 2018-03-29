import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        // Regardless of the configuration, the toy has always a fixed "top surface" and "bottom surface"
        int result = 2 * H * W;
        for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				
                // We initially add the surface of the four lateral areas of the current cube...
				result += (A[i][j]) * 4;
				
                //... and then we remove the unnecessary areas, according the height of the adjacent cubes 
                // already considered
				if(i != 0) {
					result -= 2 * Math.min(A[i - 1][j], A[i][j]);
				}
				if(j != 0) {
					result -= 2 * Math.min(A[i][j], A[i][j - 1]);
				}
			}
			
		}
        
        System.out.println(result);
        
        
        in.close();
    }
}

