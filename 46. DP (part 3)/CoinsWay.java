// coin change problems
// find total no of ways

public class CoinsWay {
    // tabulation method
    // O(n*w)
    public static int coinChange(int coins[], int sum){
        int n = coins.length;

        int[][] dp = new int[n+1][sum+1];

        // initialisation
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<=sum; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                int price = coins[i-1];
                if(j >= price){
                    dp[i][j] = dp[i][j-price] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][sum];
    }

    public static void print(int[][] dp){
        for (int[] dp1 : dp) {
            for (int j = 0; j < dp1.length; j++) {
                System.out.print(dp1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String []args){
        int coins[] = {2,5,3,6};
        int sum = 10;

        System.out.println("no. of ways = "+coinChange(coins, sum));
    }
}
