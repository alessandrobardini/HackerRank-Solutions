import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * We iterate through the number of chapters and, for each chapter, we compute the number of pages completely 
 * occupied by problems (problemsOfThisChapter / maxNumberOfProblemsPerPage). 
 * The last page of the chapter could be partially occupied by problems, if problemsOfThisChapter / maxNumberOfProblemsPerPage
 * has a remainder: we store this information, also.
 * Then, we iterate through the pages completely occupied and we check if the page number is included in the 
 * range [offset, offset + maxNumberOfProblemsPerPage), where offset, at the beginning, is equal to 1 and it's incremented  
 * by maxProblemsPerPage at each iteration.
 * Finally, if the last page is partially occupied by problems, there is a special problem if the page number
 * is included in [offset, offset + problemsInTheLastPagePartiallyOccupied).
 */

public class Solution {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numberOfChapters = sc.nextInt();
		int maxNumberOfProblemsPerPage = sc.nextInt();

		int pageNumber = 1;
		int specialProblems = 0;

		for (int i = 0; i < numberOfChapters; i++) {
			int problemsOfThisChapter = sc.nextInt();
			int pagesCompletelyOccupied = problemsOfThisChapter / maxNumberOfProblemsPerPage;
			int problemsInTheLastPagePartiallyOccupied = problemsOfThisChapter % maxNumberOfProblemsPerPage;
			int offset = 1;
			for (int j = 0; j < pagesCompletelyOccupied; j++) {
				if (pageNumber >= offset && pageNumber < (offset + maxNumberOfProblemsPerPage)) {
					specialProblems++;
				}
				pageNumber++;
				offset += maxNumberOfProblemsPerPage;

			}

			if (problemsInTheLastPagePartiallyOccupied != 0) {
				if (pageNumber >= offset && pageNumber < (offset + problemsInTheLastPagePartiallyOccupied)) {
					specialProblems++;
				}
                pageNumber++;
			}

		}

		System.out.println(specialProblems);

		sc.close();
	}

}

