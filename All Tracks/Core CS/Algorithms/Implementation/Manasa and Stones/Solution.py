#!/bin/python3

import sys

"""
The final stones are the values included in the range [a * (n - 1), b * (n - 1)] with step (b - a).
"""

if __name__ == '__main__':
    t = int(input().strip())
    for a0 in range(t):
        n = int(input().strip())
        a = int(input().strip())
        b = int(input().strip())
        stones = set()
        final_stone = a * (n - 1)
        stones.add(final_stone)
        while final_stone != b * (n - 1):
            final_stone += b - a
            stones.add(final_stone)
        print(*sorted(stones))



