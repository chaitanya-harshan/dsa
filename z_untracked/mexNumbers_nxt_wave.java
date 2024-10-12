package z_untracked;

import java.util.HashMap;

public class mexNumbers_nxt_wave {
    public static void main(String[] args) {
        int[] arr = {0,1,1,4};
        // int[] arr = {2,4,11};
        System.out.println(mexNumbers(arr));
    }

    static int mexNumbers(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else map.put(num, 1);
        }

        int mex = 0;
        while (map.containsKey(mex)) {
            mex++;
        }

        if (mex == 0) return -2;
        
        int elements = Integer.MAX_VALUE;
        for (int i=0; i<mex; i++) {
            elements = Math.min(elements, map.get(i));
        }
        return elements;
    }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         arr[i] = sc.nextInt();
    //     }

    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int num: arr) {
    //         if (map.containsKey(num)) {
    //             map.put(num, map.get(num)+1);
    //         }
    //         else map.put(num, 1);
    //     }

    //     int mex = 0;
    //     while (map.containsKey(mex)) {
    //         mex++;
    //     }

    //     if (mex == 0) System.out.println(-2);
        
    //     int elements = Integer.MAX_VALUE;
    //     for (int i=0; i<mex; i++) {
    //         elements = Math.min(elements, map.get(i));
    //     }
    //     System.out.println(elements);
    // }
}
