/*
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 Input: g = [1,2], s = [1,2,3]
Output: 2
*/

 
package greedy.easy;

import java.util.Arrays;

public class _01_cookies {

    public static void main(String[] args) {
        int[] cookies = {1,2,3};
        int[] greed = {1,2};
        System.out.println(findContentChildren(greed, cookies));
    }
    
    public static int findContentChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int g = greed.length, c = cookie.length;
        int i = 0, j = 0;
        while (i < g && j < c) {
            if (greed[i] <= cookie[j]) i++;
            j++;
        }
        return i;
    }
}
