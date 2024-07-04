package recursion;

public class palindrome {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println(str+" - "+isPalindrome(str));
        str = "bro";
        System.out.println(str+" - "+isPalindrome(str));
    }

    static boolean isPalindrome(String str) {
        int length = str.length();
        if (length <= 1) return true;

        if (str.charAt(0) != str.charAt(length-1)) {
            return false;
        }
        return isPalindrome(str.substring(1,length-1));
    }
}
