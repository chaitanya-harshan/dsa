/*
 * Given a set of n jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. 
We earn the profit associated with a job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.
 */

// ?? : ) time limit is the last deadline if you're wondering

package greedy.medium;

import java.util.Arrays;

public class _003_job_sequencing {
    
    public static int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(job.deadline, maxDeadline);
        }
        
        int[] timeslot = new int[maxDeadline];
        
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        int profit = 0;
        int jobs_done = 0;
        
        for (Job job : arr) {
            int time = job.deadline-1;
            while (time > -1 && timeslot[time] != 0) {
                time--;
            }
            if (time > -1) {
                timeslot[time] = 1;
                profit += job.profit;
                jobs_done++;
            }
        }
        
        return new int[]{jobs_done, profit};
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}