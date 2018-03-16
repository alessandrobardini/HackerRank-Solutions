import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
 * Time complexity: O(k)
 * Since the queen is able to move in eight different directions, we keep track of the number of squares
 * to which the queen can perform a move, for each of the eight different directions.
 * If there are no obstacle, the computation is straightforward.
 * Otherwise, for each obstacle, we save its row coordinate in ro and its column coordinate in co
 * and we check if the obstacle is placed in one of the eight possible directions.
 * Given a direction, the final number of squares for that direction is the number of squares between
 * the queen and the closest obstacle on that direction.
 * In the case of the up-down-left-right directions, we check if a obstacle is placed on that direction
 * simply by comparing the row/column coordinates of the obstacle and the queen.
 * In the case of the four diagonal directions, we check if a obstacle is placed on that direction by
 * checking if the queen and the obstacle are connected by a 45 degree line (Math.abs(ro - rq) == Math.abs(co - cq)).
 */

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int rq = sc.nextInt();
		int cq = sc.nextInt();

		int up_squares = n - rq;
		int right_squares = n - cq;
		int down_squares = rq - 1;
		int left_squares = cq - 1;
		int left_up_squares = Math.min(left_squares, up_squares);
		int right_up_squares = Math.min(up_squares, right_squares);
		int left_down_squares = Math.min(down_squares, left_squares);
		int right_down_squares = Math.min(right_squares, down_squares);

		for (int i = 0; i < k; i++) {
			int ro = sc.nextInt();
			int co = sc.nextInt();
			if (ro == rq && co < cq && Math.abs(co - cq) - 1 < left_squares) {
				left_squares = Math.abs(co - cq) - 1;
			}
			if (ro == rq && co > cq && Math.abs(co - cq) - 1 < right_squares) {
				right_squares = Math.abs(co - cq) - 1;
			}
			if (co == cq && ro < rq && Math.abs(ro - rq) - 1 < down_squares) {
				down_squares = Math.abs(ro - rq) - 1;
			}

			if (co == cq && ro > rq && Math.abs(ro - rq) - 1 < up_squares) {
				up_squares = Math.abs(ro - rq) - 1;
			}
			if (Math.abs(ro - rq) == Math.abs(co - cq)) {
				if (ro > rq && co < cq && Math.abs(ro - rq) - 1 < left_up_squares) {
					left_up_squares = Math.abs(ro - rq) - 1;
				}
				if (ro < rq && co < cq && Math.abs(ro - rq) - 1 < left_down_squares) {
					left_down_squares = Math.abs(ro - rq) - 1;
				}
				if (ro < rq && co > cq && Math.abs(ro - rq) - 1 < right_down_squares) {
					right_down_squares = Math.abs(ro - rq) - 1;
				}
				if (ro > rq && co > cq && Math.abs(ro - rq) - 1 < right_up_squares) {
					right_up_squares = Math.abs(ro - rq) - 1;
				}
			}

		}

		int total_moves = right_squares + left_squares + up_squares + down_squares + left_down_squares + left_up_squares
				+ right_up_squares + right_down_squares;

		System.out.println(total_moves);

		sc.close();

	}

}

