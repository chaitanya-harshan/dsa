/*
 * 
 * 139. Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

apple pen apple
              True  ------- dp(s.length+1) = true
              e     ^
             le     |
            ple     |
           pple     |
          apple-> True
        n apple     ^
       en apple     |
      pen apple -> True 
    e pen apple     ^ 
   le pen apple     | 
  ple pen apple     | 
 pple pen apple     | 
apple pen apple -> True

****** Example 3: ******
************************
Input: s = "catsanddog", wordDict = ["cats","dog","sand","and","cat"]
Output: true
IF: s = "catsandog" Output: false

--> Therefore we can't check from start as we can't know after we match the 1st part, whether
we can find the second part or 3rd part of the string.abstract. Therefore we need to check from last 
from which index's there is a word in the dictionary. using the 'climbing stairs' dp approach.
Eg: when you're at sand you will be like yeah sand exists and the next index stating dog also exists so it means
from sand index there exits words so now you go check one index before sand that is from "tsan..."
you will check for every index because in the future (when you are in a lower index) you might need it. 
 */

import java.util.Arrays;
import java.util.List;

public class _10_word_break {
    public static void main(String[] args) {
        String[] words = {"apple", "pen"};
        // Conversion of array to 'List' using Arrays.asList
        List<String> wordDict = Arrays.asList(words);
        System.out.println(wordBreak("applepenapple", wordDict));

        // for converting array to arraylist
        // List<String> wordDictAL = new ArrayList<>();
        // Collections.addAll(wordDictAL, words);
        // System.out.println(wordBreak("applepenapple", wordDictAL));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[dp.length-1] = true;

        for (int i = s.length()-1; i>=0; i--) {
            for (String w: wordDict) {
                if (i+w.length() <= s.length() && s.substring(i,i+w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i] == true) break;
            }
        }
        return dp[0];
    }
}


