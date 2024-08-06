import java.util.Arrays;

public class coins {

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        System.out.println(coinChange(coins, 6249));
    }
    


    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int idx = coins.length-1;
        int count = 0;
        // for (int i = idx-1; i>=0; i--) {
        while (amount != 0) {
            if (amount >= coins[idx]) {
                amount -= coins[idx];
                count++;
            }
            else if (idx != 0) idx--;
            else return -1;
        }
        return count;
    }
}

