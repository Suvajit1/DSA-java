// find minimum subset sum difference 

public class PartitioningSubset {

    // tabulation
    // like 0-1 Knapsack
    // O(n^2)
    public static int minDiff(int[] number){
        int n = number.length;
        int sum = 0;

        for(int i=0; i<number.length; i++){
            sum+=number[i];
        }

        // set1 capacity
        int W = sum/2;

        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int num = number[i-1];
                if(num<=j){
                    dp[i][j] = Math.max(dp[i-1][j-num] + num, dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];

        int sum2 = sum - sum1;

        return Math.abs(sum1-sum2);
    }

    public static void main(String[] args) {
        int number[] = {1, 6, 11, 5};

        System.out.println(minDiff(number));
    }
}
