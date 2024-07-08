/*
 * Given a string s, sort it in decreasing order based on the frequency of the characters. 
 * Return the sorted string. If there are multiple answers, return any of them.
 */

package strings.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * _01_sort_char_by_freq
 */
public class _01_sort_char_by_freq {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a) );

        for (char c : map.keySet()) {
            pq.offer(c);
        }

        String str = "";
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = map.get(c);
            for (int i = 0; i<count; i++) {
                str += c;
            }
        }
        return str;
    }
}