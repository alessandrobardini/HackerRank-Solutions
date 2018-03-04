#!/bin/python3

import sys

"""
Since x1 < x2, if v1 <= v2 the two kangaroos will never land at the same location at the same time
(the first kangaroo is slower than the second).
In all the other cases, we have the solve the equation x1 + t*v1 = x2 + t*v2, where t is the number of jumps.
t must be an integer value, so it's sufficient to verify that (x2 - x1) % (v1 - v2) == 0.
"""

x1, v1, x2, v2 = map(int, input().strip().split(' '))
print("NO" if v1 <= v2 or (x2 - x1) % (v1 - v2) != 0 else "YES")
