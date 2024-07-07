
import java.util.Arrays;

// Longest Common Subsequence

public class LongestCommonSubsequence {
    // Recursion
    // Time Complexity : O(2^n)
    public static int LCS(String str1, String str2, int n, int m) {
        // Base Case
        if(n==0 || m==0){
            return 0;
        }

        // recursion
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return LCS(str1, str2, n-1, m-1) + 1;
        } else {
            int ans1 = LCS(str1, str2, n-1, m);
            int ans2 = LCS(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    // memorisation
    // O(n*m)
    public static int LCSmem(String str1, String str2, int n, int m, int[][] dp) {
        // Base Case
        if(n==0 || m==0){
            return 0;
        }

        //memorization
        if(dp[n][m] != -1){
            return  dp[n][m];
        }
        else{
            // check last index
            // recursion
            if(str1.charAt(n-1) == str2.charAt(m-1)){
                dp[n][m] = LCSmem(str1, str2, n-1, m-1, dp) + 1;
                return dp[n][m];
            }
            else{
                dp[n][m] = Math.max(LCSmem(str1, str2, n-1, m, dp), LCSmem(str1, str2, n, m-1, dp));
                return dp[n][m];
            }
        }
    }

    // tabulation
    // O(n*m)
    public static int LCStab(String str1, String str2) {
        int n =str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        // initialization
        for(int i=0; i<=n; i++){    // 0th col
            dp[i][0] = 0;
        }
        for(int i=0; i<=n; i++){    // 0th row
            dp[i][0] = 0;
        }

        // filling
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length(); 

        System.out.println(LCS(str1, str2, n, m));  // 3

        str1 = "abcd";
        str2 = "aceb";
        n = str1.length();
        m = str2.length(); 

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(LCSmem(str1, str2, n, m, dp)); // 2

        str1 = "abcdge";
        str2 = "abedg";

        System.out.println(LCStab(str1, str2)); // 4
    }    
}
