// rod cutting
// find max profit

public class RodCutting {
    public static int rodcutting(int[] length, int[] price, int rodLength){
        int n = length.length;

        int[][] dp = new int[n+1][rodLength+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=rodLength; j++){
                if(j>=length[i-1]){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][rodLength];
    }

    public static void print(int[][] dp){
        for (int[] dp1 : dp) {
            for (int j = 0; j < dp1.length; j++) {
                System.out.print(dp1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int rodLength = 8;

        System.out.println(rodcutting(length, price, rodLength));
    }
}
