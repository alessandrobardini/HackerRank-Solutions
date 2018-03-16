#!/bin/python3

import sys

"""
Time complexity: O(k)
Since the queen is able to move in eight different directions, we keep track of the number of squares
to which the queen can perform a move, for each of the eight different directions.
If there are no obstacle, the computation is straightforward.
Otherwise, for each obstacle, we save its row coordinate in ro and its column coordinate in co
and we check if the obstacle is placed in one of the eight possible directions.
Given a direction, the final number of squares for that direction is the number of squares between
the queen and the closest obstacle on that direction.
In the case of the up-down-left-right directions, we check if a obstacle is placed on that direction
simply by comparing the row/column coordinates of the obstacle and the queen.
In the case of the four diagonal directions, we check if a obstacle is placed on that direction by
checking if the queen and the obstacle are connected by a 45 degree line (abs(ro - rq) == abs(co - cq)).

"""

if __name__ == '__main__':
    n, k = map(int, input().strip().split(" "))
    rq, cq = map(int, input().strip().split(" "))

    up_squares = n - rq
    right_squares = n - cq
    down_squares = rq - 1
    left_squares = cq - 1
    left_up_squares = min(left_squares, up_squares)
    right_up_squares = min(up_squares, right_squares)
    left_down_squares = min(down_squares, left_squares)
    right_down_squares = min(right_squares, down_squares)

    for _ in range(0, k):
        ro, co = map(int, input().strip().split(" "))

        if ro == rq and co < cq and abs(co - cq) - 1 < left_squares:
            left_squares = abs(co - cq) - 1
        if ro == rq and co > cq and abs(co - cq) - 1 < right_squares:
            right_squares = abs(co - cq) - 1
        if co == cq and ro < rq and abs(ro - rq) - 1 < down_squares:
            down_squares = abs(ro - rq) - 1
        if co == cq and ro > rq and abs(ro - rq) - 1 < up_squares:
            up_squares = abs(ro - rq) - 1

        if abs(ro - rq) == abs(co - cq):
            if ro > rq and co < cq and abs(ro - rq) - 1 < left_up_squares:
                left_up_squares = abs(ro - rq) - 1
            if ro < rq and co < cq and abs(ro - rq) - 1 < left_down_squares:
                left_down_squares = abs(ro - rq) - 1
            if ro < rq and co > cq and abs(ro - rq) - 1 < right_down_squares:
                right_down_squares = abs(ro - rq) - 1
            if ro > rq and co > cq and abs(ro - rq) - 1 < right_up_squares:
                right_up_squares = abs(ro - rq) - 1

    total_moves = right_squares + left_squares + up_squares + down_squares + left_down_squares + left_up_squares + right_up_squares + right_down_squares

    print(total_moves)

