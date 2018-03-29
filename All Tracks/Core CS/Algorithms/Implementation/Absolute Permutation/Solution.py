#!/bin/python3

import sys

"""
Let's consider the different cases:
1) If k = 0, we simply print all the numbers between 1 and n
2) If n is odd, there is no possible permutation
3) If n % (2 * k) == 0, there is no possible permutation
4) In all the other cases, the permutation is composed by n / k subsequences with length k:
  
Example:
n = 8 k = 2
The permutation is 3 4 1 2 7 8 5 6 
We clearly see 4 subsequences of 2 consecutive numbers 
  
Example:
n = 6 k = 3
The permutation is 4 5 6 1 2 3
We clearly see 2 subsequences of 3 consecutive numbers 
  
The permutation always follows a fixed pattern and can be created in a trivial way.
"""


if __name__ == '__main__':
    t = int(input().strip())
    for a0 in range(t):
        n, k = map(int, input().strip().split(' '))
        permutation = []
        if k == 0:
            print(" ".join([str(number) for number in range(1, n + 1)]))
        else:
            if n % 2 == 0 and n % (2 * k) == 0:
                blocks = n // k
                current_number = k
                for block in range(0, blocks):
                    for i in range(0, k):
                        current_number += 1
                        permutation.append(current_number)
                    current_number = current_number + (2 * k) if block % 2 != 0 else current_number - (2 * k)
                print(" ".join([str(number) for number in permutation]))
            else:
                print(str(-1))

