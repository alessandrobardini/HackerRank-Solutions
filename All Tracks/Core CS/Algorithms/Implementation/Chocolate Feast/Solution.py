#!/bin/python3

import sys

"""
At the beginning, we have have an amount of wrappers equal to the amount of chocolate bought.
We can exchange the wrappers for more chocolate until the remaining wrappers are >= the 'wrappers_exchange'.
At each iteration, the numbers of wrappers is equal to the sum of the amount of chocolate just bought using
the previous wrappers (wrappers / wrappers_exchange) and the the amount of unused wrappers (wrappers % wrappers_exchange).
"""

if __name__ == "__main__":
    t = int(input().strip())
    for a0 in range(t):
        money, cost, wrappers_exchange = input().strip().split(' ')
        money, cost, wrappers_exchange = [int(money), int(cost), int(wrappers_exchange)]
        chocolate_bought = money // cost
        wrappers = chocolate_bought
        while wrappers >= wrappers_exchange:
            chocolate_bought += wrappers // wrappers_exchange
            wrappers = (wrappers // wrappers_exchange) + (wrappers % wrappers_exchange)
        print(chocolate_bought)
                

