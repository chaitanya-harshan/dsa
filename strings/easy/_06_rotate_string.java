package strings.easy;

public class _06_rotate_string {
    public static void main(String[] args) {
        System.out.println(rotateString1("abcde","cdeab"));
    }

    public static boolean rotateString(String s, String goal) {
        for (int i=0; i<s.length(); i++) {
            String first = s.substring(0,i);
            String last = s.substring(i);
            if ((last+first).equals(goal)) return true;
        }
        return false;
    }

    public static boolean rotateString1(String s, String goal) {
        s += s;
        return s.contains(goal);
    }
}
