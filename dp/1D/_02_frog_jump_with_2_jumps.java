package dp.1D;

public class _02_frog_jump_with_2_jumps {
    public int minimumEnergy(int arr[],int n){
        //code here
        int nxt = 0, nxtNxt = 0;
        int cur = 0;
        for (int i=n-2; i>=0; i--) {
            int twoJump = Integer.MAX_VALUE;
            
            int oneJump = Math.abs(arr[i]-arr[i+1]) + nxt;
            if (i+2 < n) twoJump = Math.abs(arr[i]-arr[i+2]) + nxtNxt;
            
            cur = Math.min(oneJump, twoJump);
            nxtNxt = nxt;
            nxt = cur;
        }
        return cur;
    }
}

/*https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump

 * Geek Jump
Difficulty: EasyAccuracy: 49.55%Submissions: 80K+Points: 2
 Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

Input: n = 4, height = {10 20 30 10}
Output: 20
Explanation:
Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost). Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost). So, total energy lost is 20 which is the minimum.
 */