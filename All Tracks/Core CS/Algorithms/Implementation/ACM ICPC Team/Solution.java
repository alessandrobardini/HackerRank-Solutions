import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
 * We have to compare every couple of persons and count the number of couples who knows the max number of topics 
 * (i.e. the couple whose bitwise OR contains the max number of 1).
 */

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		String[] persons = new String[n];

		for (int i = 0; i < n; i++) {
			persons[i] = sc.next();
		}

		sc.close();

		int maxTopicsNumber = 0;
		int teams = 0;

		for (int i = 0; i < persons.length; i++) {
			for (int j = i + 1; j < persons.length; j++) {
				String firstPersonTopics = persons[i];
				String secondPersonTopics = persons[j];
				int currentTopicsNumber = 0;
				for (int k = 0; k < m; k++) {
					if (firstPersonTopics.charAt(k) == '1' || secondPersonTopics.charAt(k) == '1') {
						currentTopicsNumber++;
					}
				}
				if (currentTopicsNumber > maxTopicsNumber) {
					maxTopicsNumber = currentTopicsNumber;
					teams = 1;
				} else if (currentTopicsNumber == maxTopicsNumber) {
					teams++;
				}

			}
		}

		System.out.println(maxTopicsNumber);
		System.out.println(teams);
	}

}


