package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question6a {
    static class Job {
        int id;
        int profit;
        int deadlines;

        Job(int id, int profit, int deadlines){
            this.id = id;
            this.profit = profit;
            this.deadlines = deadlines;
        }
    }

    public static void main(String[] args) {
        // int jobInfo[][]={{3,35}, {4,30}, {4,25}, {2,20}, {3,15}, {1,12}, {2,5}};
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};

        int maxtime = -1;
        ArrayList<Job> jobs = new ArrayList<>();
        
        for(int i=0; i<jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][1], jobInfo[i][0]));
            maxtime = Math.max(maxtime, jobInfo[i][0]);
        }

        int slot[] = new int[maxtime+1];
        Arrays.fill(slot, -1);

        Collections.sort(jobs, (obj1, obj2)->obj2.profit-obj1.profit);

        int profit = 0;
        int count = 0;
        for(int i=0; i<jobs.size() && count<maxtime; i++){
            Job job = jobs.get(i);
            if(slot[job.deadlines]==-1){
                slot[job.deadlines] = job.id;
                profit+=job.profit;
            }else{
                for(int j=job.deadlines-1; j>=1; j--){
                    if(slot[j]==-1){
                        slot[j]=job.id;
                        profit+=job.profit;
                        break;
                    }
                }
            }
            count++;
        }

        for(int i=0; i<slot.length; i++){
            System.out.print(slot[i]+" ");
        }
        System.out.println();
        System.out.println(profit);
    }
}
