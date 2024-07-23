package exps.monsters;
import java.util.ArrayList;
import java.util.Scanner;

public class InfosysMonsterHard {
    public static void main(String[] args) {
        //taking the inputs
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int exp = sc.nextInt();
        ArrayList<Integer> powList = new ArrayList<>();
        int x = num;
        while(x > 0){
            powList.add(sc.nextInt());
            x--;
        }
        ArrayList<Integer> bonusList = new ArrayList<>();
        x = num;
        while(x > 0){
            bonusList.add(sc.nextInt());
            x--;
        }
        
        //getting the output
        int output = possibleMonsterDefeats(powList, bonusList, exp);
        
        //printing the output
        System.out.println(output);

    }

    static int possibleMonsterDefeats(ArrayList<Integer> powList, ArrayList<Integer> bonusList, int exp){
        int count = 0;
        int index = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        for(int bonus : powList){
            if(powList.get(index) <= exp){
                exp += bonusList.get(index);
                count++;
                tempList.add(index);
            }
            index++;
        }
        index = 0;
        for(int x: tempList){
            powList.remove(index);
            bonusList.remove(index);
        }
        if(count == 0) return 0;
        return count + possibleMonsterDefeats(powList, bonusList, exp);

    }
}