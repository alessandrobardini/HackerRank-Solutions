#!/bin/python3

import sys

"""
We iterate through the number of chapters and, for each chapter, we compute the number of pages completely 
occupied by problems (problems_of_this_chapter / max_number_of_problems_per_page).
The last page of the chapter could be partially occupied by problems, if problems_of_this_chapter / max_number_of_problems_per_page
has a remainder: we store this information, also.
Then, we iterate through the pages completely occupied and we check if the page number is included in the
range [offset, offset + max_numbers_of_problems_per_page), where offset, at the beginning, is equal to 1 and it's incremented
by maxProblemsPerPage at each iteration. 
Finally, if the last page is partially occupied by problems, there is a special problem if the page number
is included in [offset, offset + problems_in_the_last_page_partially_occupied). 
"""


if __name__ == "__main__":
    number_of_chapters, max_number_of_problems_per_page = input().strip().split(' ')
    number_of_chapters, max_number_of_problems_per_page = [int(number_of_chapters), int(max_number_of_problems_per_page)]
    arr = list(map(int, input().strip().split(' ')))
    page_number = 1
    special_problems = 0
    for problems_per_chapter in arr:
        pages_completely_occupied = problems_per_chapter // max_number_of_problems_per_page
        problems_in_the_last_page_partially_occupied = problems_per_chapter % max_number_of_problems_per_page
        offset = 1
        for _ in range(pages_completely_occupied):
            if page_number >= offset and page_number < (offset + max_number_of_problems_per_page):
                special_problems += 1
            page_number += 1
            offset += max_number_of_problems_per_page
        if problems_in_the_last_page_partially_occupied != 0:
            if page_number >= offset and page_number < (offset + problems_in_the_last_page_partially_occupied):
                special_problems += 1
            page_number += 1
    print(special_problems)
            


