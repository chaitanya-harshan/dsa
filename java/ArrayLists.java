package java;

import java.util.ArrayList;
import java.util.Collections;
/**
 * ArrayList
 */
public class ArrayLists {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        // ADD elements
        list.add(1) ;
        list.add(3);
        list.add(0);
        System.out.println(list);

        // GET elements
        int element = list.get(1);
        System.out.println("Element: "+element);

        // ADD element IN BETWEEEN
        list.add(1, 2);
        System.out.println(list);

        // SET
        list.set(2, 5);
        System.out.println(list);

        // DELETE
        list.remove(2);
        System.out.println(list);

        // SIZE
        int size = list.size();
        System.out.println("Size: "+size);

        // loop
        for (int i = 0; i<list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println();

        // SORTING
        Collections.sort(list);
        System.out.println(list);
    }
}