package strings.medium;

public class _04_atoi {
    public static void main(String[] args) {
        // System.out.println(myAtoi("  -123-456"));
        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }
        else if (s.charAt(0) == '+') s = s.substring(1);
        
        long num = 0;
        for (char c: s.toCharArray()) {
            if (c < '0' || c > '9') break;
            
            num = num*10 + c-'0';
            if (sign == 1) num = Math.min(Integer.MAX_VALUE, num);
            else num = Math.min((long)Integer.MAX_VALUE + 1, num);
        }

        return sign*(int)num;
    }

    public static int myAtoi1(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
       
        int sign = 1;
        int i = 0;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (s.charAt(i) == '+') i++;

        // to make sure i doesn't go out of bound since we did i++ above but didnt check for boundary 
        if (i > s.length()-1) return 0;
        s = s.substring(i);

        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                ch -= '0';
                if (num > (Integer.MAX_VALUE - ch) / 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num*10 + ch;
            }
            else break;
        }
        return num * sign;
    }
}
