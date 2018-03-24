#!/bin/python3

import sys

"""
 a) We create an array 'flatland' whose elements are 1 (if there is a station associated to that index) or 0 (if there isn't a station).
 b) and c) We create two arrays, 'distances_from_left_station' and 'distances_from_right_station', where we store, for each index, the distance
from the nearest left and right station, respectively.
Beware that if we haven't met any station yet, we have to store an infinite distance value.
Example:
20 5
13 1 11 10 6

distances_from_left_station = [2147483647 0 1 2 3 4 0 1 2 3 0 0 1 0 1 2 3 4 5 6 ]
distances_from_right_station = [1 0 4 3 2 1 0 3 2 1 0 0 1 0 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647]

d) Finally, for each index, we compare the associated left and right distances to determine which one is smaller.
Among all these values, the answer is the maximum one.
"""

if __name__ == '__main__':
    n, m = map(int, input().strip().split(" "))
    space_stations = list(map(int, input().strip().split(" ")))
    flatland, distances_from_left_station, distances_from_right_station  = [[0] * n, [0] * n, [0] * n]

    # a)

    for space_station in space_stations:
        flatland[space_station] = 1

    # b)

    current_distance = sys.maxsize
    searching_for_the_first_station = True

    for i in range(n):
        if searching_for_the_first_station:
            if flatland[i] == 1:
                searching_for_the_first_station = False
                current_distance = 0
        else:
            if flatland[i] == 1:
                current_distance = 0
            else:
                current_distance += 1
        distances_from_left_station[i] = current_distance

    # c)

    current_distance = sys.maxsize
    searching_for_the_first_station = True

    for i in range(n - 1, -1, -1):
        if searching_for_the_first_station:
            if flatland[i] == 1:
                searching_for_the_first_station = False
                current_distance = 0
        else:
            if flatland[i] == 1:
                current_distance = 0
            else:
                current_distance += 1
        distances_from_right_station[i] = current_distance

    # d)

    max_distance = 0

    for i in range(n):
        max_distance = max(max_distance, min(distances_from_left_station[i], distances_from_right_station[i]))

    print(max_distance)
