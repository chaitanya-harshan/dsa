// https://leetcode.com/problems/permutation-sequence/description/
// very hard so just go watch the video 
// https://youtu.be/wT7gcXLYoao 

package recursion.sde;

import java.util.ArrayList;

public class _06_kth_permutation {
    
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i=1; i<n; i++) {
            nums.add(i);
            fact *= i; // till n-1 only 
        }
        nums.add(n);

        String s = "";
        k--;
        while (nums.size() > 1) {
            s += nums.get(k/fact);
            nums.remove(k/fact);
            k = k % fact;
            fact = fact/nums.size();
        }
        s += nums.get(0);

        return s;

        /*
        while (true) {
            s += nums.get(k/fact);
            nums.remove(k/fact);
            if (nums.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact/nums.size();
        }
        */
    }
}
