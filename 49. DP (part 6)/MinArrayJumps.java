// Min Array Jumps
// Kadans Algo

import java.util.Arrays;

public class MinArrayJumps {

    public static int minJump(int[] arr){
        int n = arr.length;
        int dp[] = new int[n];
        
        Arrays.fill(dp, -1);

        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int jumps = arr[i];
            int ans = (int) 1e10;   // max value
            for(int j=i+1; j<= i+jumps && j<n; j++){
                ans = Math.min(ans, dp[j]+1);
            }

            if(ans != (int)1e10){
                dp[i]= ans;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};

        System.out.println(minJump(arr));
    }    
}
