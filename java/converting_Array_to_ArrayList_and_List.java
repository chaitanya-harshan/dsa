
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class converting_Array_to_ArrayList_and_List {
    public static void main(String[] args) {

        // To ArrayList

        String[] words = {"boy", "rocket", "car", "spaceX", "ISRO", "Elon Musk"};
        ArrayList<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList, words); 
        // only for non primitive data types like strings

        // To List

        List<String> list = Arrays.asList(words); 
        // this is a fixed list and not a dynamic one like arraylist

        // ****important point to know****

        // wont work for integer array or any primitive. 
        // int[] nums = {1, 2, 3, 4, 5};
        // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
