#!/bin/python3

import sys
import math

"""
We can implement an optimized solution that avoids to create a 2D array:
we simply "jump" over the desired characters of the initial string and build, step by step,
the encrypted string.
Note that both the loops operate in the range(0, columns): if we consider the range (0, rows) for the inner
loop (where rows is, as defined in the problem, the floor of the length of the string), we would skip
the last row if the last row contains less elements than the number of columns,
as happens in the following case:

chillout 

chi
llo
ut
"""

if __name__ == "__main__":
    s = input().strip()
    length = len(s)
    columns = int(math.ceil(math.sqrt(length)))
    
    encrypted_string = ""
    
    for j in range(columns):
        for i in range(columns):
            if j + i * columns < length:
                encrypted_string += s[j + i * columns]
        encrypted_string += " "
        
    print(encrypted_string)
