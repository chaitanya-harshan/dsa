package hashing.array_Hashing;

import java.util.Scanner;

public class hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("length of the array: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        // Pre Compute
        int[] hash = new int[13]; // just taking 13 has the largest number that can be
        for (int i = 0; i < length; i++) {
            hash[arr[i]]++;
        }

        System.out.print("How many numbers u want to find: ");
        int q = sc.nextInt();
        while (q-- != 0) {
            int number = sc.nextInt();
            System.out.println("-- "+hash[number]+" times");
        }
    }
}
