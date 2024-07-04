/*
 * Given an array/list of length ‘n’, where the array/list represents the boards and each
 *  element of the given array/list represents the length of each board.
 *  Some ‘k’ numbers of painters are available to paint these boards.
 *  Consider that each unit of a board takes 1 unit of time to paint.

You are supposed to return the area of the minimum time to get this job done of painting 
all the ‘n’ boards under a constraint that any painter will only paint the continuous sections 
of boards.
 */

package binary.math;

import java.util.ArrayList;

public class _11_painters_partion {

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int max = 0, sum = 0;
        for (int i = 0; i < boards.size(); i++) {
            max = Math.max(max, boards.get(i));
            sum += boards.get(i);
        }

        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = (low + high)/2;
            if (countPainters(boards,mid) <= k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    static int countPainters(ArrayList<Integer> boards, int time) {
        int painters = 1;
        int boardsPainted = boards.get(0);
        for (int i = 1; i < boards.size(); i++) {
            if (boards.get(i) + boardsPainted <= time) {
                boardsPainted += boards.get(i);
            }
            else {
                painters++;
                boardsPainted = boards.get(i);
            }
        }
        return painters;
    }
}
