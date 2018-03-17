#!/bin/python3

import sys
import math

"""
The problem is straightforward, we have only to take into account that, in case of small numbers,
the left hand piece (variable 'left') is the empty string, since the square has only one digit. 
In this case, we have to sum 0.
"""

if __name__ == '__main__':
    p = int(input().strip())
    q = int(input().strip())
    kaprekar_numbers = []
    for number in range(p, q + 1):
        square = str(int(math.pow(number, 2)))
        square_digits = len(square)
        right = int(square[square_digits // 2 :])
        left = 0 if square_digits == 1 else int(square[: square_digits // 2])
        if right + left == number:
            kaprekar_numbers.append(number)
    print(" ".join(map(str, kaprekar_numbers)) if len(kaprekar_numbers) != 0 else "INVALID RANGE")



