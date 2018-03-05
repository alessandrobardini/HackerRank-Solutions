import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * If Brie starts turning from the first page, she needs to turn p/2 pages.
 * If Brie starts turning from the last page, she needs to turn n/2 - p/2 pages.
 * So it is sufficient to determine the minimum between these two values.
 */

public class Solution {

    static int solve(int n, int p){
        return Math.min(p/2, n/2 - p/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
