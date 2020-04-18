#!/bin/python3

import sys

"""
If Brie starts turning from the first page, she needs to turn p/2 pages.
If Brie starts turning from the last page, she needs to turn n/2 - p/2 pages.
So it is sufficient to determine the minimum between these two values.
"""

def solve(n, p):
    if(p<=n):
        return min(p//2, n//2 - p//2)

n = int(input().strip())
p = int(input().strip())
result = solve(n, p)
print(result)

