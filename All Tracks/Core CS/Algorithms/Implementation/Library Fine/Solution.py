#!/bin/python3

import sys

"""
To compute the fine, first we need to compare the years: if the years are equal, we compare the months.
If the months are equal, we compare the days.
In each of these cases, the fine is computed according the rules described in the problem.
"""

if __name__ == '__main__':
    d1, m1, y1 = map(int, input().strip().split(' '))
    d2, m2, y2 = map(int, input().strip().split(' '))
    if y1 < y2 or (y1 == y2 and m1 < m2) or (y1 == y2 and m1 == m2 and d1 <= d2):
        print(0)
    elif y1 > y2:
        print(10000)
    elif y1 == y2 and m1 > m2:
        print(500 * (m1 - m2))
    elif y1 == y2 and m1 == m2 and d1 > d2:
        print(15 * (d1 - d2))
