public class _02_unique_paths_in_grid {

    public int uniquePaths(int m, int n) {
        // tabulation using space optimization
        int[] prev = new int[n];

        for (int i=m-1; i>=0; i--) {
            int[] row = new int[n];
            row[n-1] = 1;
            for (int j=n-2; j>=0; j--) {
                row[j] = row[j+1] + prev[j];
            }
            prev = row;
        }
        return prev[0];

        // Math: Factorial => NCr

        // int N = m-1 + n-1;
        // int r = m-1;
        // double result = 1;
        // for (int i = 1; i <= r; i++) {
        //     // result *= ((double)(N-r+i) / i);
        //     // result = (double)(N-r+i) / i;
        //     result = result * (N-r+i)/i;
        // }
        // return (int)result;
    }
}
