// Activity Selection
// time complexity = O(n)

import java.util.ArrayList;

public class Question1{
    public static void main(String[] args) {
        int start[]= {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        int maxAct=0;
        ArrayList<Integer> act = new ArrayList<>();
        
        // 1st activity
        maxAct = 1;
        act.add(0);

        int lastEnd = end[0];

        for(int i =1; i<start.length;i++){
            // non over-lapping act
            // activity select
            if( start[i]>=lastEnd ){
                maxAct++;
                act.add(i);
                lastEnd=end[i];
            }
        }

        System.out.println(maxAct);
        System.out.println(act);
        for(int i=0;i<act.size();i++){
            System.out.print("A"+act.get(i)+" ");
        }
        System.out.println();
    }
}