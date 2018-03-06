#!/bin/python3

import sys

"""
Step a): we create the array 'scores' which contains all the distinct values of the scores.
The index corresponding to each value of 'scores' is equal to the leaderboard position (with an offset of 1)
associated with that score.

Example:
100 100 50 40 40 20 10

scores = [100, 50, 40, 20, 10]
100 is at position 0 and it is the highest value in the leaderboard.
50 is at position 1 and it is the second highest value in the leaderboard and so on.

Step b): for each Alice's score, we search in 'scores' (starting from the last element since 'scores' is decreasing)
the first value that is >= than Alice's score and we print the corresponding position.
Be careful that the position changes depending on whether alice's score is < or = than the score.
Thanks to the variable 'currentIndex', we keep track of the elements of 'scores' already visited and we don't iterate
through the entire array for every Alice's score, avoiding a TLE (Time Limit Excedeed) for large values of n.
"""

if __name__ == '__main__':

    n = int(input().strip())
    all_scores = list(map(int, input().strip().split(" ")))
    scores = []
    previous_score = all_scores[0]
    scores.append(previous_score)

    # a)
    for i in range(1, len(all_scores)):
        if all_scores[i] != previous_score:
            scores.append(all_scores[i])
        previous_score = all_scores[i]

    m = int(input().strip())
    alice_scores = list(map(int, input().strip().split(" ")))
    current_index = len(scores) - 1

    # b)
    for alice_score in alice_scores:
        searching_position = True
        while searching_position:
            if current_index < 0:
                print(1)
                searching_position = False
            else:
                current_score = scores[current_index]
                if current_score == alice_score:
                    print(current_index + 1)
                    searching_position = False
                elif current_score > alice_score:
                    print(current_index + 2)
                    searching_position = False
                else:
                    current_index -= 1






