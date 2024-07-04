public class reverse {
    public static void main(String[] args) {
        int num = Reverse(1234500);
        System.out.println(num);
    //     System.out.println(reverse(654321));
    //     System.out.println(reverse(1750012000));
        Reverse1(5432100);

    }

    static int Reverse(int N) {
        boolean numFound = false;
        String number = "";
        while (N > 0) {
            int digit = N % 10;
            if (digit != 0) {
                numFound = true;
            }
            N = N/10;
            if (numFound == true) {
                number += digit;
            }
        }
        return Integer.parseInt(number);
    }


    static int Reverse1(int N) {
        int revNum = 0;
        while (N > 0) {
            int digit = N % 10;
            N /= 10;
            revNum = revNum * 10 + digit;
        }
        System.out.println(revNum);
        return revNum;
    }
}
