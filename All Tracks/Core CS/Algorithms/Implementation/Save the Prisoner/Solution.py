#!/bin/python3

import sys

"""
Starting from the prisoner s, if the number of prisoners were infinite , the last sweet would be given 
to the prisoner at index s - 1 + m.
Since the number of prisoners if limited, when we reach the last prisoner (i.e. the prisoner at index n),
we have to come back to prisoner at index 1.
So it's necessary to use the modulus operation ( % n).
If the lastSweetIndex is 0, the last sweet is given to prisoner at index n.
"""

if __name__ == '__main__':
    t = int(input().strip())
    for a0 in range(t):
        n, m, s = map(int, input().strip().split(' '))
        last_sweet_index = (s - 1 + m) % n
        print(last_sweet_index if last_sweet_index != 0 else n)