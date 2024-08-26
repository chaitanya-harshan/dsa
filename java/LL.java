package java;
import java.util.LinkedList;

public class LL {
    public static void main(String[] args) {
        
        LinkedList<String> list = new LinkedList<>();

        list.add("HI!");
                                                                System.out.println(list);
        list.add("Bitches");
                                                                System.out.println(list);
        list.addFirst("Yo");
                                                                System.out.println(list);
        list.add(1, "Sup");
                                                                System.out.println(list);
        list.remove("HI!");
                                                                System.out.println(list);
        list.addLast(":)");
                                                                System.out.println(list);
        list.remove(3);
                                                                System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println();
    }   
}
