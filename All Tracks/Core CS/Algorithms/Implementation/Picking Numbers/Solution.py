#!/bin/python3

import sys

"""
The condition "The absolute difference between any two of the chosen integers is <= 1" means that the number we choose are:
a) integer with identical value (absolute difference == 0) 
or 
b) consecutive integers (absolute difference == 1).
So it is a good idea to create a frequency array that counts the occurrences of the numbers and then 
iterate through the array to find the maximum value between consecutive elements (i.e. consecutive frequencies).
In this way, we handle case a) and case b).

Example case a):
6
1 1 1 4 5 6 
The frequency array is [3, 0, 0, 1, 1, 1] and the maximum value is 3 (3 + 0)

Example case b):
6
1 1 2 3 5 2 
The frequency array is [2, 2, 1, 1, 0] and the maximum value is 4 (2 + 2)
"""

if __name__ == '__main__':
    n = int(input().strip())
    array = list(map(int, input().strip().split(' ')))
    frequency = [0] * 100
    max_value = 0
    for number in array:
        frequency[number] += 1
    for i in range(1, 100):
        max_value = max(max_value, frequency[i] + frequency[i - 1])
    print(max_value)
