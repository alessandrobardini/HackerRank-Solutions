#!/bin/python3

import sys

"""
We have to find all the possible 3x3 magic squares and, for each of them, compute the cost of turning 
the given square into a magic square: the cost corresponds to the cost of changing all its cells
into the corresponding cells of the magic square (i.e. for the cell (i,j), the cost is the absolute difference
between the cell (i,j) of the given square and the cell (i,j) of the magic square).
After we have computed all the 8 costs, we keep the minimum cost.
Remember that Google is your friend: the quickest way to find all the 8 magic squares is through a web search :)
In this way, we hard-code the 8 magic squares into the solution.
"""

if __name__ == '__main__':
    square = []
    for i in range(3):
        square.append(list(map(int, input().strip().split(' '))))

    magic_squares = [[[8, 1, 6], [3, 5, 7], [4, 9, 2]],
                     [[6, 1, 8], [7, 5, 3], [2, 9, 4]],
                     [[4, 9, 2], [3, 5, 7], [8, 1, 6]],
                     [[2, 9, 4], [7, 5, 3], [6, 1, 8]],
                     [[8, 3, 4], [1, 5, 9], [6, 7, 2]],
                     [[4, 3, 8], [9, 5, 1], [2, 7, 6]],
                     [[6, 7, 2], [1, 5, 9], [8, 3, 4]],
                     [[2, 7, 6], [9, 5, 1], [4, 3, 8]]]

    minimum_cost = sys.maxsize

    for magic_square in magic_squares:
        current_cost = 0
        for i in range(3):
            for j in range(3):
                current_cost += abs(magic_square[i][j] - square[i][j])
        minimum_cost = min(minimum_cost, current_cost)

    print(minimum_cost)

