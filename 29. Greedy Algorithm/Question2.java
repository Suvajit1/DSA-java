// Fractional Knapsack 

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        int weight[]={10,20,30};
        int value[]= {60,100,120};
        int W= 50;

        double ratio[][]= new double[weight.length][2];
        // 0th col -> idx; 1st col -> ratio

        for(int i=0;i<weight.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=(value[i]/(double)weight[i]);
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // in ascending order

        double maxVal=0;
        int capacity= W;

        for(int i=ratio.length-1; i>=0; i--){
            int idx= (int)ratio[i][0];
            if(capacity >= weight[idx]){    // include full item
                capacity=capacity-weight[idx];
                maxVal=maxVal+value[idx];
            }else{  // include fractional item
                maxVal=maxVal+ ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }

        System.out.println(maxVal);
    }
}
