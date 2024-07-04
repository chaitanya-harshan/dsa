/*
 * Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 */
package strings.easy;

import java.util.HashMap;

/**
 * _05_isomorphic_string
 */
public class _05_isomorphic_string {

    public static void main(String[] args) {
        String s = "bada", t = "baba";
        System.out.println(isIsomorphic("egg","add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);

            if (!map.containsKey(sc) && map.containsValue(tc)) return false;
            else if (!map.containsKey(sc) && !map.containsValue(tc)) {
                map.put(sc,tc);
            }
            else if (map.get(sc) != tc) {
                return false;
            }
        }
        return true;
    }
}