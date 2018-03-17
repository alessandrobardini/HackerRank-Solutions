#!/bin/python3

import sys

"""
a) We have to find the first_element_to_swap: this is the greatest index i such that
initial_string[i] > initial_string[i - 1].
If it's not possible to find the first_element_to_swap, the string is already the biggest permutation.

b) We have to find the second_element_to_swap: this is the greatest index j such that
initial_string[j] > initial_string[index_of_first_element_to_swap - 1] and
j >= index_of_first_element_to_swap.

c) We swap the first_element_to_swap and the second_element_to_swap.

d) We reverse the substring starting at first_element_to_swap.
"""

def swap_characters(s, i, j):
    lst = list(s);
    lst[i], lst[j] = lst[j], lst[i]
    return ''.join(lst)


def reverse_substring(s, i, j):
    return s[:i] + s[i:j][::-1] + s[j:]


def find_next_permutation(initial_string):
    # a)
    index_of_first_element_to_swap = 0
    for i in range(1, len(initial_string)):
        if initial_string[i] > initial_string[i - 1]:
            index_of_first_element_to_swap = i
    if index_of_first_element_to_swap == 0:
        return "no answer"
    else:

        # b)
        index_of_second_element_to_swap = 0
        for j in range(index_of_first_element_to_swap, len(initial_string)):
            if initial_string[j] > initial_string[index_of_first_element_to_swap - 1]:
                index_of_second_element_to_swap = j

        # c)
        string_with_swapped_characters = swap_characters(initial_string, index_of_first_element_to_swap - 1,
                                                         index_of_second_element_to_swap)

        # d)

        final_string = reverse_substring(string_with_swapped_characters, index_of_first_element_to_swap,
                                         len(initial_string))


        return final_string


if __name__ == '__main__':
    t = int(input().strip())
    for _ in range(t):
        initial_string = input().strip()
        print(find_next_permutation(initial_string))


