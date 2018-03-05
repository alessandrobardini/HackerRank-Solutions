#!/bin/python3

import sys

"""
We use the frequency array 'is_even' to keep track of the frequencies of all the possible colors:
each index of the array corresponds to a possible color.
If the color i is appeared an odd number of times, we cannot sell a pair of socks, but is_even[i] is set to false, in such a way that the next time the color i appear, we can make a pair of socks of the same color.
If the color i is appeared an even number of times, we can sell a pair of socks, but it is necessary to set is_even[i] to true, since we can encounter other socks of the same color and repeat the process described above.
In this time, we implement an optimized solution with a time complexity of O(n).
"""

if __name__ == "__main__":
    n = int(input().strip())
    array = list(map(int, input().strip().split(' ')))
    is_even = [True] * 101
    pair_of_socks = 0
    for color in array:
        if is_even[color]:
            is_even[color] = False
        else:
            is_even[color] = True
            pair_of_socks += 1
    print(pair_of_socks)
