// Longest Increasing Subsequence

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {

    // O(n*m)
    public static int lis(int[] arr){
        int n = arr.length;

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            hs.add(arr[i]);
        }        

        int arr2[] = new int[hs.size()];
        int k=0;
        for (int num : hs) {
            arr2[k] = num;
            k++;
        }
        
        Arrays.sort(arr2);

        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(arr[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};

        System.out.println(lis(arr));
    }
}
