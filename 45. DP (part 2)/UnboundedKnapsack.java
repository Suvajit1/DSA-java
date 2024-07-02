// Unbounded Knapsack

public class UnboundedKnapsack {
    // Tabulation Method
    // O(n*W)
    public static int unboundedKnapsack(int[] val, int[] wt, int W){
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
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-w], dp[i-1][j]);
                }else{
                    //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][W];
    }

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(unboundedKnapsack(val, wt, W));
    }
}
