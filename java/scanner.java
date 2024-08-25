
import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        int num;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter some rando number bitch!");
            num = sc.nextInt();
        }
        System.out.println("number is -"+num);

        Untill_Correct_Input_Is_given.takingInput();

    }


class Untill_Correct_Input_Is_given {

    static void takingInput(){
        int num=0;
        try {
            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("Num:");
                num = sc.nextInt();

                if (num < 100) {
                    break;
                }
                System.out.println("Enter Num less then 100");
        }
        
        System.out.println("bingo");
        sc.close();


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("err: "+e.getMessage()+e);
        }
        
    }
}
}
