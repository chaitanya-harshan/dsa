package _extras.z_exps.monsters;

import java.util.PriorityQueue;


public class Monsters {
    
    public static void main(String[] args) {
        int Monsters = 3;
        int exp = 100;
        int[] monsPow = {101, 100, 180, 304};
        int[] bonus = {100, 1, 103, 524};

        System.out.println(defeatMonsters(monsPow, bonus, exp));
    }

    public static int defeatMonsters(int[] monsPow, int[] bonus, int exp) {
        // HashMap<Integer, Integer> map = new HashMap<>();// ~~~~~~~~~~~~~~~~~~~not needed
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a)); // ~~~~ not needed
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> monsPow[b] - monsPow[a]);
        int count = 0;

        // iterating through monsters power array
        for (int i = 0; i < monsPow.length; i++) {
            // map.put(i, monsPow[i]);// ~~~~~~~~~~~~~~~~~~not needed

            // if monsters power is more then my exp i'll add them to my pq and skip them
            if (exp < monsPow[i]) {
                pq.add(i);
            }
            else { // if my exp is greater than monsters
                exp += bonus[i];
                count++;

                // iterating & checking the previous monsters i skipped before until the queue is empty
                // or i find monsters still more powerful than me
                while (!pq.isEmpty()) {
                    int index = pq.peek();
                    int element = monsPow[index];
                    if (exp >= element) {
                        exp += bonus[index];
                        count++;
                        pq.poll();
                    }
                    else break;
                }
            }
        }
        return count;
    }
}


