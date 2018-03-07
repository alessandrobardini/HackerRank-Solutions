#!/bin/python3

import sys

"""
a) We create the shifted_array.
b) We print the element of the shifted_array at a given position.
"""

if __name__ == '__main__':

    n, k, q = map(int, input().strip().split(" "))

    array = list(map(int, input().strip().split(" ")))

    shifted_array = [0] * n

    # a)
    for i in range(n):
        shifted_array[(i + k) % n] = array[i]

    # b)
    for _ in range(q):
        print(shifted_array[int(input().strip())])



