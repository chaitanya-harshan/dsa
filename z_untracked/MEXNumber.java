package z_untracked;

import java.util.HashMap;

public class MEXNumber {
    public static int main(String[] args) {
        int[] arr = {0,1,1,4};
    

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else map.put(num, 1);
        }

        int mex = 0;
        while (map.containsKey(mex)) {
            mex++;
        }

        if (mex == 0) return -2;
        
        int elements = Integer.MAX_VALUE;
        for (int i=0; i<mex; i++) {
            elements = Math.min(elements, map.get(i));
        }
        return elements;
    }

}