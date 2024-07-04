package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class hashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("length of the array: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        // Pre Compute
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                int freq = map.get(key);
                map.put(key, freq+1);
            }
            else map.put(key, 1);
        }
        System.out.println(map);

        System.out.print("How many num do u wanna find: ");
        int q = sc.nextInt();
        while (q-- != 0) { 
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                System.out.println("-- "+map.get(num)+" times");
            }
            else System.out.println("-- 0 times");
        }
    }
}
