// Target Sum Subset

public class TargetSumSubaet {
    // tabulation method
    // O(n * target)
    public static boolean targetSumSubaet(int number[], int target){
        int n = number.length;
        // if(target==0){
        //     return true;
        // }

        boolean dp[][] = new boolean[n+1][target+1];

        for(int i=0; i<dp.length; i++){     // 1 col = true
           dp[i][0]= true;
        }

        // 1 row -> false except [ dp[0][0] = true ]
        for(int i=1; i<n+1; i++){
            for(int j=1; j<target+1; j++){
                int v = number[i-1];
                if(v<=j && dp[i-1][j-v]){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }

        print(dp);
        return dp[n][target];
    }

    public static void print(boolean[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int number[] = {4,2,7,1,3};
        int target = 10;

        System.out.println(targetSumSubaet(number, target));
    }
}
