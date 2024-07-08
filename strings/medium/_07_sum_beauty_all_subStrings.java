package strings.medium;

import java.util.HashMap;
import java.util.Map;

public class _07_sum_beauty_all_subStrings {
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }

    public static int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i<s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j<s.length(); j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);

                int low = Integer.MAX_VALUE, high = 0;
                for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                    high = Math.max(high, entry.getValue());
                    low = Math.min(low, entry.getValue());
                }
                sum += high - low;
            }
        }
        return sum;
    }

    // public static int beautySum1(String s) {
    //     int sum = 0;
    //     for (int i = 0; i<s.length(); i++) {
    //         HashMap<Character, Integer> map = new HashMap<>();
    //         SortedSet<Integer> set = new TreeSet<>();
    //         for (int j = i; j<s.length(); j++) {
    //             char c = s.charAt(j);
                
    //             if (map.containsKey(c)) {
    //                 set.remove(map.get(c));
    //                 System.out.println("@");
    //             }

    //             map.put(c, map.getOrDefault(c, 0) + 1);
    //             set.add(map.get(c));
    //             int low = set.first();
    //             int high = set.last();

    //             sum += high - low;
    //         }
    //     }
    //     return sum;
    // }
}
