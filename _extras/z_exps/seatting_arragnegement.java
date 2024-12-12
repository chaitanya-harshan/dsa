package _extras.z_exps;

import java.util.Arrays;

public class seatting_arragnegement {
    public static void main(String[] args) {
        // int[] nums = {3,2,2};
        int[] nums = {2,2};
        System.out.println(Arrays.toString(finder(2, nums)));
    }

    static int[] finder(int n, int[] preferences) {
        int[] seats = new int[n];
        Arrays.fill(seats, 0);
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (seats[preferences[i]-1] == 0) {
                seats[preferences[i]-1] = 1;
                res[i] = preferences[i];
            }
            else {
                for (int j = 0; j < res.length-1; j++) {
                    int idx = (j+preferences[i]) % n;
                    if (seats[idx] == 0) {
                        seats[idx] = 1;
                        res[i] = idx+1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
