// Max Length Chain of Pair

import java.util.*;

public class Question4 {    // O(nlogn)
    public static void main(String[] args) {
        int pair[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));

        int chainLen=0;
        //take 1st pair
        chainLen=1;
        int num2=pair[0][1];

        for(int i=1;i<pair.length;i++){
            if(num2<=pair[i][0]){
                chainLen++;
                num2=pair[i][1];
            }
        }

        System.out.println(chainLen);
    }
}
