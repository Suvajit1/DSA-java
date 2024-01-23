// largest subarray with 0 sum

import java.util.HashMap;

public class Question6 {
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7,10};

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int len=0;

        for(int i=0;i<arr.length;i++){  // O(n)
            sum=sum+arr[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                len=i-map.get(sum);
            }
        }
        
        System.out.println(len);
    }
}
