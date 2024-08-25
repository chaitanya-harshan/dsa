package bit_manipulation.exp;

public class count_set_bits_in_num {
    
    public static void main(String[] args) {
        System.out.println(count(20));
    }

    static int count(int n) {
        int cnt = 0;
        while (n != 0) {
            n = (n-1) & n;
            cnt++;
        }
        return cnt;
    }
}
