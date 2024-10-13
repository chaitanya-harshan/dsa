package z_untracked;

import java.util.HashSet;
import java.util.Scanner;

public class array_equalizer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        int[] arr1 = new int[M];
        for (int i = 0; i < M; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // Finding the first and last index where arrays differ
        int a = -1, b = -1;
        int diff = 0;
        boolean canBeIdentical = true;
        for (int i = 0; i < M; i++) {
            if (arr1[i] != arr2[i]) {
                if (a == -1) a = i;
                if (diff == 0) diff = arr2[i] - arr1[i];

                if (arr2[i] - arr1[i] != diff) {
                    canBeIdentical = false;
                    break;
                }
                b = i;
            }
        }
        if (diff == 0) {
            System.out.println("YES 0");
            return;
        }

        // If we can make the arrays identical
        if (canBeIdentical) {
            System.out.println("YES " + diff);
        } 
        else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < M; i++) {
                if (!set.contains(arr1[i])) set.add(arr1[i]);
                else set.remove(arr1[i]);

                if (!set.contains(arr2[i])) set.add(arr2[i]);
                else set.remove(arr2[i]);
                
            }
            System.out.println("NO " + set.size());
        }
    }

    public static void trail(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] arr1 = new int[M];
        for (int i = 0; i < M; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // Checking if the two arrays are already identical
        // boolean areIdentical = true;
        // for (int i = 0; i < M; i++) {
        //     if (arr1[i] != arr2[i]) {
        //         areIdentical = false;
        //         break;
        //     }
        // }
        // if (areIdentical) {
        //     System.out.println("YES 0");
        //     return;
        // }

        // Finding the first and last index where arrays differ
        int a = -1, b = -1;
        int diff = 0;
        boolean canBeIdentical = true;
        for (int i = 0; i < M; i++) {
            if (arr1[i] != arr2[i]) {
                if (a == -1) a = i;
                if (diff == 0) diff = arr2[i] - arr1[i];

                if (arr2[i] - arr1[i] != diff) {
                    canBeIdentical = false;
                    break;
                }
                b = i;
            }
        }
        if (diff == 0) {
            System.out.println("YES 0");
            return;
        }

        // for (int i = 0; i < M; i++) {
        //     if (arr1[i] != arr2[i]) {
        //         if (a == -1) {
        //             a = i; // first difference
        //         }
        //         b = i;// last difference
        //     }
        // }
        // // Calculate the difference value
        // int diff = arr2[a] - arr1[a];
        // boolean canBeIdentical = true;

        // // Check if the difference is consistent across the subarray
        // for (int i = a; i <= b; i++) {
        //     if (arr2[i] - arr1[i] != diff) {
        //         canBeIdentical = false;
        //         break;
        //     }
        // }

        // If we can make the arrays identical
        if (canBeIdentical) {
            System.out.println("YES " + diff);
        } 
        else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < M; i++) {
                if (!set.contains(arr1[i])) set.add(arr1[i]);
                else set.remove(arr1[i]);

                if (!set.contains(arr2[i])) set.add(arr2[i]);
                else set.remove(arr2[i]);
                
            }
            System.out.println("NO " + set.size());
        }
    }
}


/* 
ex:1
5
1 5 7 9 15
1 5 9 11 15

5 1 5 7 9 15 1 5 9 11 15 ---for 1 line command

ex:2

6
23 34 45 56 67 78
24 36 48 60 72 84

6 23 34 45 56 67 78 24 36 48 60 72 84  

ex:3 

4
73 49 38 93
72 48 37 92

4 73 49 38 93 72 48 37 92
 */

 /*
  * You are given two arrays ( arrayOne and array Two ) of the
same length M Your task is to check if you can make
arrayOne identical to arrayTwo. You can make changes to 
arrayOne by completing the following operation at most once:
• Select three integers for the parameters a, b and value 
such that
1<= a <= b < = M and value >= 0 ,and 
add value to each element in arrayOne from index a to
b. 
If the two arrays can be made identical, the program should print
YES followed by the value that is added to arrayOne
elements; otherwise, it should Print NO followed by the number
of elements that are present in both the arrays without duplicates.
Input Format:
• First line contains an integer M , representing the size of the 
array.
• Second line contains elements of the array arrayOne
separated by space.
• Third line contains elements of the array arrayTwo
separated by space.
  */