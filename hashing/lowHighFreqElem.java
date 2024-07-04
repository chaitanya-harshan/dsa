package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lowHighFreqElem {
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,4,5,5,5,2,2,5,1,1,6};

        // Creating a hashmap
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else map.put(arr[i], 1);
        }

        int high = 0;
        int low = map.get(arr[0]); // can't but 0 or 1 because the min freq might be 2 or 3 itself
        Set<Map.Entry<Integer,Integer>> freqTable = map.entrySet();
        for (Map.Entry<Integer,Integer> entry : freqTable ) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > high) {
                high = key;
            }
            if (value < low) {
                low = key;
            }
        }
        System.out.println("High frequency "+high+" : "+map.get(high));
        System.out.println("Low Frequency "+low+" : "+map.get(low));
    }
}
