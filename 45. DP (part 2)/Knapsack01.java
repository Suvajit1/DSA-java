// 0-1 knapsack problems

import java.util.Arrays;

public class Knapsack01 {
    // recurssion method
    // O(2^n)
    public static int knapsack(int[] val, int[] wt, int W, int i){  // i is index of the item
        // base case
        if(W==0 || i==val.length){
            return 0;
        }

        // item can be include as W >= wt
        if(W >= wt[i]){
            // include
            int inP = val[i] + knapsack(val, wt, W-wt[i], i+1);

            // exclude
            int exP = knapsack(val, wt, W, i+1);

            return Math.max(inP, exP);
        }else{
            // item can't be include as W < wt
            return knapsack(val, wt, W, i+1);
        }
    }

    public static int knapsack1(int[] val, int[] wt, int W, int n){ // n is no. of item
        // base case
        if(W==0 || n==0){
            return 0;
        }

        // item can be include as W >= wt
        if(W >= wt[n-1]){
            // include
            int inP = val[n-1] + knapsack1(val, wt, W-wt[n-1], n-1);

            // exclude
            int exP = knapsack1(val, wt, W, n-1);

            return Math.max(inP, exP);
        }else{
            // item can't be include as W < wt
            return knapsack1(val, wt, W, n-1);
        }
    }

    // Memorisation (top down approach)
    // O(nxW)
    public static int knapsackMem(int[] val, int[] wt, int W, int n, int[][] dp){ // n is no. of item
        // base case
        if(W==0 || n==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        // item can be include as W >= wt
        if(W >= wt[n-1]){
            // include
            int inP = val[n-1] + knapsackMem(val, wt, W-wt[n-1], n-1, dp);

            // exclude
            int exP = knapsackMem(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(inP, exP);
            return dp[n][W];
        }
        else{
            // item can't be include as W < wt
            dp[n][W] = knapsackMem(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Tabulation Method buttom up approach
    // O(nxW)
    public static int knapsackTab(int[] val, int[] wt, int W){
        int n = val.length;
        if(W==0 || n==0){
            return 0;
        }

        int[][] dp = new int[n+1][W+1];
        // initialize
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;   // 0th col
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;   // 0th row
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                // int v = val[i-1];
                int w = wt[i-1];
                if(w<=j){//valid
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-w], dp[i-1][j]);
                }else{
                    //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        int maxProf = knapsack(val, wt, W, 0);
        System.out.println(maxProf);

        System.out.println(knapsack1(val, wt, W, val.length));

        int n = val.length;
        int dp[][]= new int[n+1][W+1];
        // initialisation
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsackMem(val, wt, W, n, dp));
        print(dp);

        System.out.println(knapsackTab(val, wt, W));
    }
}