import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * 1) Find the gcd G of the second set
 * 2) Find the lcm L of the first set
 * 3) Find the divisors D of G 
 * 4) The result is the number of times that an element of D is divisible by L
 */

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		

		ArrayList<Integer> firstSet = new ArrayList<>();
		ArrayList<Integer> secondSet = new ArrayList<>();

		IntStream.range(0, n).forEach(number -> firstSet.add(sc.nextInt()));
		IntStream.range(0, m).forEach(number -> secondSet.add(sc.nextInt()));
		
		sc.close();


		int gcd = secondSet.stream()
					.reduce(secondSet.get(0), (a,b) -> gcdBetweenTwoNumbers(a, b));
		
		int lcm = firstSet.stream()
					.reduce(firstSet.get(0), (a,b) -> a * (b / gcdBetweenTwoNumbers(a, b)));
		
		List<Integer> divisors = IntStream.range(1, gcd + 1)
									.filter(number -> gcd % number == 0)
									.boxed()
									.collect(Collectors.toList());

		long cnt = divisors.stream()
					.filter(number -> number % lcm == 0)
					.count();

		System.out.println(cnt);

	}

	public static int gcdBetweenTwoNumbers(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
}

