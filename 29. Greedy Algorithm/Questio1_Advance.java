// Activity selestion while end time is not in sorted order

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class Questio1_Advance {
    public static void main(String[] args) {
        int start[]={0,1,3,5,5,8};
        int end[] = {6,2,4,7,9,9};

        int activity[][]=new int[start.length][3];
        // 0 col -> is for act. no.
        // 1 col -> start time
        // 2 col -> end time.

        for(int i=0 ; i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }

        int maxAct = 0;
        ArrayList<Integer> act = new ArrayList<>();

        // lambda function
        Arrays.sort(activity,Comparator.comparingDouble(o -> o[2]));

        // 1st act after sort should select
        maxAct = 1;
        act.add(activity[0][0]);
        int lastEnd= activity[0][2];

        for( int i= 1; i<activity.length; i++){
            if(activity[i][1] >= lastEnd){
                maxAct++;
                act.add(activity[i][0]);
                lastEnd=activity[i][2];
            }
        }

        System.out.println(maxAct);
        for(int i =0; i<act.size(); i++){
            System.out.print("A"+act.get(i)+" ");
        }
        System.out.println();
        
    }
}
