// Matrix Chain Multiplication

import java.util.Arrays;

public class MatrixChainMultiplication {

    // recursion
    // Time Comlpexity : O(K^n)
    public static int mcmRec(int arr[], int i, int j){
        if(i==j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int cost1 = mcmRec(arr, i, k); // set 1 -> X
            int cost2 = mcmRec(arr, k+1, j);   // set 2 -> Y

            int cost3 = arr[i-1] * arr[k] * arr[j]; // cost to find XY

            int totalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, totalCost);
        }

        return ans;
    }

    // memorisation
    // Time Complexity - O(n^2)
    public static int mcmMem(int[] arr, int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k <= j-1; k++){
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            ans = Math.min(ans, (cost1+cost2+cost3));
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length; 

        int minCost = mcmRec(arr, 1, n-1);

        System.out.println(minCost);

        int dp[][] = new int[n][n];
        // initialisation
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcmMem(arr, 1, n-1, dp));
    }
}
