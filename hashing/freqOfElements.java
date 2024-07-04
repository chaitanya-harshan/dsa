package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class freqOfElements {
    public static void main(String[] args) {
        int[] arr = {1,3,5,10,4,3,5,8,10,3,1,5,7,4};

        // Creating a Hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put( arr[i] ,  map.get(arr[i]) + 1  );
            }
            else map.put(arr[i], 1);
        }

        // Printing hash map 

        // creating a set which stores all the 'key-value' PAIR
        Set<Map.Entry<Integer,Integer>> freqTable = map.entrySet();  // map.entrySet() returns a SET
        
        // u can directly mention map.entrySet() in for loop but to make it clear i first created a set to store it then use it
        for (Map.Entry<Integer,Integer> pair : freqTable){
            System.out.println(pair.getKey()+" - "+pair.getValue());
        }
    }
}
