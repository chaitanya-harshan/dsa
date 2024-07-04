package binary.math;

public class _12_gas_stations {
    
    public static double MinimiseMaxDistance(int []arr, int K){
        // Write your code here.
        double low = 0, high = 0;
        for (int i = 1; i < arr.length; i++) {
            high = Math.max(high, (double)(arr[i]-arr[i-1]));
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high)/(2.0);
            if (gasStations(arr, mid) > K){
                low = mid;
            }
            else high = mid;
        }
        return high;
    }

    static int gasStations(int[] arr, double dist) {
        int stations =  0;
        for (int i = 1; i < arr.length; i++) {
            int Sections = (int)((arr[i] - arr[i-1])/ dist);
            if (Sections * dist == arr[i]-arr[i-1]) Sections--;
            stations += Sections;
        }
        return stations;
    }
}
