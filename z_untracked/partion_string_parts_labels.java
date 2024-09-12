package z_untracked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class partion_string_parts_labels {
    
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> list = new ArrayList<>();
        int end = 0;
        int length = 0;
        for (int i=0; i<s.length(); i++) {
            length++;
            end = Math.max(end, map.get(s.charAt(i)) );
            if (i == end) {
                list.add(length);
                length = 0;
            }
        }
        return list;
    }
}

/*
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/
 * 
You are given a string s. We want to partition the string into 
as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in 
order, the resultant string should be s.

Return a list of integers representing the size of these parts.


Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation: The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */