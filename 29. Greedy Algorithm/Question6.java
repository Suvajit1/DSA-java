// Job Sequencing Problems

import java.util.*;

public class Question6 {
    static class Job{
        int deadline;
        int profit;
        char id;

        Job(char i, int d, int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i =0; i<jobInfo.length; i++){
            jobs.add(new Job((char)('A'+i), jobInfo[i][0], jobInfo[i][1]));
        }
        
        Collections.sort(jobs, (obj1,obj2)->obj2.profit-obj1.profit); 
        // decending order

        ArrayList<Character> seq = new ArrayList<>();
        int time=0;
        int profit=0;
        for(int i=0;i<jobInfo.length;i++){
            if(jobs.get(i).deadline > time){
                time++;
                seq.add(jobs.get(i).id);
                profit += jobs.get(i).profit;
            }
        }

        System.out.println(profit);
        System.out.println(seq);
        System.out.println("Max job = "+seq.size());
    }
}
