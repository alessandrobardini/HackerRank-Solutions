#!/bin/python3

import sys
import math

'''
The easiest way is to iterate through the range and, for every number, check if that number is a perfect square.
Unfortunately, this approach leads to a TLE.
Instead of searching for the perfect squares, we can reverse the problem and search for the integers whose square is
included in the initial range.
In this way, we define a lower_limit as the smallest integer whose square is greater than 'a' and an upper_limit 
as the biggest integer whose square is smaller than 'b'.
The number of integers included in the range [a, b] is the solution.
Time complexity: O(1)
'''

if __name__ == "__main__":
    q = int(input().strip())
    for a0 in range(q):
        a, b = map(int, input().strip().split(' '))
        lower_limit = math.ceil(math.sqrt(a))
        upper_limit = math.floor(math.sqrt(b))
        print(upper_limit - lower_limit + 1)

