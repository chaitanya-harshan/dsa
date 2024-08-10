package trail;

import java.util.Arrays;

public class sorting_strings {
    public static void main(String[] args) {
        String[] bro = {"yo", "Likhit"};
        System.out.println(Arrays.toString(bro));
        
        for (int i=0; i<bro.length; i++) {
            String string = bro[i];
            char[] word = string.toCharArray();
            Arrays.sort(word);
            String sortedWord = new String(word);
            System.out.println(sortedWord);
            bro[i] = sortedWord;
        }
        System.out.println(Arrays.toString(bro));
    }
}
