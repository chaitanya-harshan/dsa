package trail;

import java.util.Arrays;

/**
 * array_sort
 */
public class array_sort {

    public static void main(String[] args) {
        int[] myNum = {50, 10, 25, 1, 17, 99, 33};
        System.out.println(Arrays.toString(myNum));
        Arrays.sort(myNum);
        System.out.println(Arrays.toString(myNum));
    }
}