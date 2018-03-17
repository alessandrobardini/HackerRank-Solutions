#!/bin/python3

import sys

"""
We create an array 'containers' whose elements are the number of balls in every container
and another array 'colors' with the number of balls of each color.
For each color, we have to find a container capable to contain all the balls of that color.
To do this, it is sufficient to sort the arrays 'containers' and 'colors' and check if they are equal: 
if they are equal, the answer is possible.
"""

if __name__ == "__main__":
    q = int(input().strip())
    for _ in range(q):
        n = int(input().strip())
        containers = [0] * n
        colors = [0] * n
        for i in range(n):
            row = list(map(int, input().split(' ')))
            for j in range(n):
                containers[i] += row[j]
                colors[j] += row[j]
        print("Possible" if sorted(containers) == sorted(colors) else "Impossible")
