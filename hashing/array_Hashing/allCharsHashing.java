package hashing.array_Hashing;

import java.util.Scanner;

public class allCharsHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String(without spaces): ");
        String str = sc.nextLine();
        char arr[] = str.toCharArray();

        // Pre COmpute
        int[] hash = new int[256];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        System.out.print("how many char do u wanna find: ");
        int q = sc.nextInt();
        while (q-- != 0) {
            System.out.print("Char: ");
            int alphabet = sc.next().charAt(0);
            System.out.println(hash[alphabet]+" times");
        }
    }
}
