#!/bin/python3

import sys

"""
The minimum number of characters to be deleted and add in order to convert string1 to string2 is
saved in the variable 'necessaryOperations'.
The conversion is possible in three cases:
1)  k == necessaryOperations: of course, the conversion is possible.

    hello
    helloworld
    5

    necessaryOperations = 5
    We perform 5 additions
    The answer is YES

2)  k >= necessaryOperations and (k - necessaryOperations) % 2 == 0:
    by subtracting 'necessaryOperations' from 'k', we obtain the number of 'dummy operations':
    a dummy operation is the addition and the instantaneous deletion of the same character (or viceversa).
    Since a dummy operation consists of two actions (addition and deletion), we have to check the parity:
    if the parity is even, the conversion is possible.

    hellno
    hellyes
    7

    necessaryOperations = 5
    k - necessaryOperations = 2 (dummy operations)
    We perform 2 necessary deletions, 1 dummy addition, 1 dummy deletion and 3 necessary additions
    The answer is YES

    hellno
    hellyes
    4

    necessaryOperations = 5
    k - necessaryOperations = 1 (dummy operations)
    Since the number of dummy operations is odd, we cannot compensate for a dummy addition/deletion.
    The answer is NO

3)  k >= len(s) + len(t):
    since we can still perform a delete operation on an empty string to get the empty string,
    the conversion is possible.

    hell
    he
    10

    We perform 5 deletions to obtain the empty string, 3 deletions on the empty string and 2 additions.
    The answer is YES
"""


if __name__ == '__main__':
    s = input().strip()
    t = input().strip()
    k = int(input().strip())
    min_len = min(len(s), len(t))
    first_different_index = min_len

    for i in range(min_len):
        if s[i] != t[i]:
            first_different_index = i
            break

    necessary_operations = len(s) + len(t) - 2 * first_different_index

    print("Yes" if k == necessary_operations or (k >= necessary_operations and (k - necessary_operations) % 2 == 0 ) or k >= len(s) + len(t) else "No")


