#!/bin/python3

import sys


"""
We can make the ladybugs happy in two cases:
a) there is at least one empty cell and there are at least two ladybugs for each color.
b) the initial configuration is happy (i.e. it is already composed of happy ladybugs)
"""


if __name__ == '__main__':
    q = int(input().strip())
    for a0 in range(q):
        n = int(input().strip())
        configuration = input().strip()
        ladybugs = dict()
        there_is_empty_cell = False
        already_happy_ladybugs = True
        for i in range(len(configuration)):
            current_cell = configuration[i]
            if current_cell != '_':
                # We create the ladybugs map, with a ladybug's color as key and
                # True (if there are at least two ladybugs of that color) or
                # False (otherwise) as value.
                if current_cell in ladybugs:
                    ladybugs[current_cell] = True
                else:
                    ladybugs[current_cell] = False

                # If the current ladybug's color is not present neither in the previous cell
                # nor in the next, it means that the current ladybug is not happy,
                # so the initial configuration is not happy.
                if i == 0:
                    if len(configuration) != 1:
                        if configuration[1] != current_cell:
                            already_happy_ladybugs = False
                    else:
                        already_happy_ladybugs = False
                elif i != 0 and i != len(configuration) - 1:
                    if not (configuration[i - 1] == current_cell or configuration[i + 1] == current_cell):
                        already_happy_ladybugs = False
                elif i == len(configuration) - 1:
                    if configuration[len(configuration) - 2] != current_cell:
                        already_happy_ladybugs = False
            else:
                there_is_empty_cell = True

        single_ladybug = False

        # If one value of the ladybugs map is equal to false, it means that there is
        # only one ladybug of that color.

        for key, value in ladybugs.items():
            if value is False:
                single_ladybug = True
                break
        print("YES" if already_happy_ladybugs or (not single_ladybug and there_is_empty_cell) else "NO")
                   
