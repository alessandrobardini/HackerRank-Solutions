#!/bin/python3

"""
a) We count the number of integers having every remainder of division by k (i.e., through 0 to k - 1).
We save the results in freq_array.

b) Let's consider a remainder t > 0. If we take at least one integer with the remainder t
and at least one with the remainder k - t, then the sum of these two integers will be evenly
divisible by k. Therefore, for any fixed t, we'll have to decide what to take to the answer set:
integers with the remainder t (which we have saved in left_numbers), or integers with the remainder
k - t (which we have saved in right_numbers). We choose whichever value is greater.

Example:
4 3
1 7 2 4

left_numbers will be an array of size 1, containing the value 3 (i.e, the number of integers with
remainder t = 1) and right_numbers will be an array of size 1 too, containing the value 1 (i.e,
the number of integers with remainder k - t = 2, since t = 1).
3 > 1, so we choose 3.

c) The above works except for two cases:
c1) For t = 0 there's no different pair remainder which would have a sum evenly divisible by k,
but we also can't take 2 or more numbers with the remainder equal to 0 because their sum would
be evenly divisible by k. So we should only add min(1, freq_array[0]) to our answer.

Example:
4 3
3 3 3 3
We immediately see that we can keep only one number.

c2) Also, if k is even and t = k/2, then taking two integers with the remainder t will make the sum
divisible by k. So for even k and t = k/2 we should take min(1, freq_array[k/2]).

Example:
4 4
2 4 6 8
We can choose only one number in the set [2, 6] of the integers with remainder 2.
"""

import sys
from math import ceil

if __name__ == '__main__':
    n, k = map(int, input().strip().split(' '))
    arr = list(map(int, input().strip().split(' ')))
    freq_array = [0] * k
    left_numbers = []
    right_numbers = []
    result = 0

    # a)
    for number in arr:
        freq_array[number % k] += 1

    # b)
    for index in range(1, int(ceil(k / 2))):
        left_numbers.append(index)
        right_numbers.append(k - index)

    for i in range(0, len(left_numbers)):
        result += (max(freq_array[left_numbers[i]], freq_array[right_numbers[i]]))

    # c1)
    result += min(1, freq_array[0])

    # c2)
    if k % 2 == 0:
        result += min(1, freq_array[k // 2])
    print(result)

