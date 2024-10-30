package strings.medium;

// https://leetcode.com/problems/reverse-words-in-a-string/
/*
 * 151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class _08_reverse_words_in_string {
    public String reverseWords(String s) {
        // **** USe "" and not '' for some reason else it'll error ******
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i=words.length-1; i>= 0; i--) {
            if (words[i] != "") res.append(words[i]).append(' ');
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();

        // --------------------------------------------------------------------------
        // STACK

        // s = s.trim();
        // Stack<String> st = new Stack<>();
        
        // String word = "";
        // for (int i=0; i<s.length(); i++) {
        //     if (s.charAt(i) == ' ') {
        //         if (!word.isEmpty()) st.push(word);
        //         word = "";
        //     }
        //     else word += s.charAt(i);
        // }
        // st.push(word);

        // String res = st.pop();
        // while (!st.empty()) {
        //     res += ' ' + st.pop();
        // }
        // return res;


        // --------------------------------------------------------------------------------
        // NORMAL ITERATION

        // s = s.trim();
        // int l = 0, r = s.length()-1;
        // String res = "";

        // for (int i=s.length()-1; i>=0; i--) {
        //     if (i == s.length()-1 || (s.charAt(i) != ' ' && s.charAt(i+1) == ' ')) {
        //         r = i;
        //     }
        //     if (i == 0 || (s.charAt(i) != ' ' && s.charAt(i-1) == ' ')) {
        //         l = i;
        //         if (res == "") res += s.substring(l, r+1);
        //         else res += ' ' + s.substring(l, r+1);
        //     }
        // }
        // return res;
    }
}
