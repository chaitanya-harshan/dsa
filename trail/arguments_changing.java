public class arguments_changing {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;

        someshit(a,b);
        System.out.println(a+"-"+b);
    }

    static void someshit(int a , int b) {
        a = 14;
        b = 15;
    }
}
