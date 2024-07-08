package strings.medium;

import java.util.HashMap;

public class _03_roman_to_integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] c = s.toCharArray();
        int num =  0;
        for (int i = 0; i < c.length; i++) {
            if (i+1 == c.length || map.get(c[i]) >= map.get(c[i+1])) {
                num += map.get(c[i]);
            }
            else {
                num += map.get(c[i+1]) - map.get(c[i]);
                i++;
            }
        }
        return num;
    }
}
