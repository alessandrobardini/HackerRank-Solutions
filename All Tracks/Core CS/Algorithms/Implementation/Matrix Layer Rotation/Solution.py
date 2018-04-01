#!/bin/python3

import sys

class Cell:

    def __init__(self, row, column):
        self.row = row
        self.column = column


if __name__ == '__main__':
    m, n, r = input().strip().split(' ')
    m, n, r = [int(m), int(n), int(r)]
    matrix = []
    rotatedMatrix = [[0] * n for _ in range(m)]
    for matrix_i in range(m):
        matrix_t = [int(matrix_temp) for matrix_temp in input().strip().split(' ')]
        matrix.append(matrix_t)
    # We compute the number of "layers" of the matrix
    number_of_layers = min(n, m) // 2
    for i in range(number_of_layers):
        # We compute the row and column boundaries of the current iteration
        row_lower_limit = i
        row_upper_limit = m - 1 - i
        column_lower_limit = i
        column_upper_limit = n - 1 - i
        # We compute the path length of the current iteration, i.e. the number
        # of cells of the current layer
        pathLength = ((n - (i * 2)) * 2) + ((m - (i * 2)) * 2) - 4
        path = []
        current_row_index = i
        current_column_index = i
        down = True
        right = False
        up = False
        left = False
        for j in range(pathLength):
            # We find the cells belonging to the current layer by following the current path.
            # When we reach one of the four corners of the current layer, we change
            # the direction of our moving in the path
            path.append(Cell(current_row_index, current_column_index))
            if current_row_index == row_upper_limit and current_column_index == column_lower_limit:
                down = False
                right = True
            if current_row_index == row_upper_limit and current_column_index == column_upper_limit:
                right = False
                up = True
            if current_row_index == row_lower_limit and current_column_index == column_upper_limit:
                up = False
                left = True
            if down:
                current_row_index += 1
            if right:
                current_column_index += 1
            if up:
                current_row_index -= 1
            if left:
                current_column_index -= 1

        # We save the current layer into the corresponding rotated matrix layer
        for j in range(pathLength):
            current_cell = path[j]
            number_to_be_moved = matrix[current_cell.row][current_cell.column]
            new_cell = path[(j + r) % pathLength]
            rotatedMatrix[new_cell.row][new_cell.column] = number_to_be_moved

    for row in rotatedMatrix:
        print(" ".join(str(number) for number in row))



