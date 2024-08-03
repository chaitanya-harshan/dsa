/*
 * There is one meeting room in a firm. You are given two arrays, start and end each of size N.
 * For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  
 * will denote the ending time of the ith meeting. Find the maximum number of meetings that 
 * can be accommodated if only one meeting can happen in the room at a  particular time.
 */
package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;


public class _01_max_meetings {
    
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start, end, start.length));
    }
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        meeting[] meets = new meeting[n];
        for (int i=0; i<n; i++) {
            meets[i] = new meeting(start[i], end[i], i+1);
            // meets[i].start = ;
            // meets[i].end = end[i];
            // meets[i].pos = i+1;
        }
        
        int count = 1;
        // Arrays.sort(meets, new meetingComparator());
        Arrays.sort(meets, (a,b) -> a.end - b.end);
        int time = meets[0].end;
        for (int i=1; i<meets.length; i++) {
            if (meets[i].start > time) {
                count++;
                time = meets[i].end;
            }
        }
        return count;
    }
}

class meeting {
    int start;
    int end;
    int pos; // incase if they ask for the meeitng numbers(positions)
    
    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}


// sorting based on the end time in ascending order
class meetingComparator implements Comparator<meeting> {
    @Override
    public int compare(meeting a, meeting b) {
        if (a.end <= b.end) return -1;
        else return 1;
    }
}