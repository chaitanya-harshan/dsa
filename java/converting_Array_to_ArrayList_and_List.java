
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class converting_Array_to_ArrayList_and_List {
    public static void main(String[] args) {

        // To ArrayList

        String[] words = {"boy", "rocket", "car", "spaceX", "ISRO", "Elon Musk"};
        ArrayList<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList, words); 

        // To List

        List<String> list = Arrays.asList(words);
        // this is a fixed list and not a dynamic one like arraylist
    }
}
