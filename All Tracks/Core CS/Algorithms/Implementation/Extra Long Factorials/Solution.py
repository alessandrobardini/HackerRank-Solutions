#!/bin/python3

import sys
import math

"""
In Python 3, the int type is unbounded.
For this reason, when we have to handle huge numbers, Python is a recommended choice.
"""

if __name__ == "__main__":
    print(math.factorial(int(input().strip())))