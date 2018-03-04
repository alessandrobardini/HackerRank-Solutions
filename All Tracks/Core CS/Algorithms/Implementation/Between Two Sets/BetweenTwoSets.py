#!/bin/python3

import sys

from functools import reduce
from math import gcd

'''
    1) Find the gcd G of the second set
    2) Find the lcm L of the first set
    3) Find the divisors D of G 
    4) The result is the number of times that an element of D is divisible by L
'''

if __name__ == "__main__":
    n, m = map(int, input().strip().split(' '))
    first_set = list(map(int, input().strip().split(' ')))
    second_set = list(map(int, input().strip().split(' ')))

    gcd_value = reduce(gcd, second_set)
    lcm_value = reduce(lambda x, y: x * int(y / gcd(x, y)), first_set)
    divisors = [divisor for divisor in range(1, gcd_value + 1) if gcd_value % divisor == 0]
    print(sum(1 for divisor in divisors if divisor % lcm_value == 0))
