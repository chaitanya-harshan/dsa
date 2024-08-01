package z_exps;
import java.util.Arrays;

public class MaxProfitCalculator {

    public static long maxProfit(int N, int K, int[] cost, int[] sell) {
        
        int[] profit = new int[N];
        for (int i = 0; i < N; i++) {
            profit[i] = sell[i] - cost[i];
        }

        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(profit[b], profit[a]));

        long totalProfit = 0;
        for (int i = 0; i < N; i++) {
            int index = indices[i];
            if (cost[index] <= K && profit[index] > 0) { 
                totalProfit += profit[index];
                K -= cost[index]; 
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int K = 50;
        int[] cost = {25, 30};
        int[] sell = {25, 32};
        
        long maxProfit = maxProfit(2,50, cost, sell);
        System.out.println("Max Profit: " + maxProfit);
    }
}
