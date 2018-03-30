#!/bin/python3

import sys

if __name__ == '__main__':
    n = int(input().strip())
    arr = list(map(int, input().strip().split(' ')))
    sorted_list = []
    unsorted_list = []

    # We save the sequence in two arrays
    for number in arr:
        sorted_list.append(number)
        unsorted_list.append(number)

    # We sort the sequence contained in sorted_list
    sorted_list.sort()

    number_of_differences = 0
    start_swap_index = 0
    end_swap_index = 0

    # We find the number of differences between the sorted and the unsorted list.
    # We save the indexes of the first and the last difference: they will be used to check if
    # the sub-array delimited by them is sorted in descending order
    for i in range(n):
        if(unsorted_list[i] != sorted_list[i]):
            number_of_differences += 1
            if number_of_differences == 1:
                start_swap_index = i
            if number_of_differences >= 2:
                end_swap_index = i

    # If there are no differences, the original array was already sorted.
    if number_of_differences == 0:
        print("yes")

    # If there are two differences, we can sort the array with a single swap.
    elif number_of_differences == 2:
        print("yes\nswap {} {}".format(start_swap_index + 1, end_swap_index + 1))

    # Else we check if it's possible to sort the array by reverting a sub-segment.
    else:
        can_be_ordered = True
        sub_array = unsorted_list[start_swap_index:end_swap_index + 1]
        for i in range(1, len(sub_array)):
            if sub_array[i] > sub_array[i - 1]:
                can_be_ordered = False
                break
        if can_be_ordered:
            print("yes\nreverse {} {}".format(start_swap_index + 1, end_swap_index + 1))
        else:
            print("no")

