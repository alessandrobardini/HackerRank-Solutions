#!/bin/python3

import sys

"""
We must distinguish three cases, depending on the year (year < 1918, year == 1918 and year > 1918),
and determine if the year is leap or not according to the rules described in the problem statement.
"""

if __name__ == '__main__':
    year = int(input().strip())
    if year < 1918:
        if year % 4 == 0:
            print("12.09.{}".format(year))
        else:
            print("13.09.{}".format(year))
    elif year == 1918:
        print("26.09.{}".format(year))
    else:
        if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
            print("12.09.{}".format(year))
        else:
            print("13.09.{}".format(year))

