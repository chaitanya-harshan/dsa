package recursion.lec3Hard;

import java.util.List;
import java.util.ArrayList;

public class _01_palindrom_partition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, result, new ArrayList<String>());
        return result;
    }

    static void backtrack(int index, String s, List<List<String>> result, List<String> path) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=index; i<s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                backtrack(i+1, s, result, path);
                path.removeLast();
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        int i = (start + end) >> 1;
        int j = (start + end + 1) >> 1;
        while (i >= start && j <= end) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i--;
            j++;
        }
        return true;
    }
}

//                                                (aabb)
//                  [a]abb ---------------- [aa]bb ------ [aab]b ----- [aabb]
//         [a]bb-----[ab]b----[abb]      [b]b------[bb]       X           X
//     [b]b---[bb]     X        X         [b]        |
//     [b]      |                          |      {aa,bb}
//      |     {a,a,bb}                  {aa,b,b}   
//   {a,a,b,b}



// https://leetcode.com/problems/palindrome-partitioning/
/*
 * 131. Palindrome Partitioning
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
 */


