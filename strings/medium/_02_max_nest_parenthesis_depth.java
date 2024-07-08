/*
 * Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 */

package strings.medium;

public class _02_max_nest_parenthesis_depth {

    public static int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;

            max = Math.max(count, max);
        }
        return max;
    }
}
