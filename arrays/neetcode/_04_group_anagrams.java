package arrays.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _04_group_anagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int idx = 0;

        for (String s : strs) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String wordString = new String(word);

            if (!map.containsKey(wordString)) {
                map.put(wordString, idx++);
                res.add(new ArrayList<>(Arrays.asList(s)));
            }
            else res.get(map.get(wordString)).add(s);
        }
        return res;
    }
}

/*
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 * 
Given an array of strings strs, group the 
anagrams
 together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */