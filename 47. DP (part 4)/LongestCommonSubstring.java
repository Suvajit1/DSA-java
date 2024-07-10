// Longest Common SubString
// variation of Longest common sequence

public class LongestCommonSubstring {

    // O(m*n)
    public static int lcSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        //initialisation
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        int ans = 0;

        // filling
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        print(dp);
        return ans;
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
        String str1 = "abcde";
        String str2 = "abgce";
        
        System.out.println(lcSubstring(str1, str2));    // 2->ab

        str1 = "abcdgh";
        str2 = "acdghr";
        System.out.println(lcSubstring(str1, str2));    // 4->cdgh
    }
}
