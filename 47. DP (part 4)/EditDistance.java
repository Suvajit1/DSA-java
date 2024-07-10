// Edit Distance
// variation of LCS

public class EditDistance {
    // O(n*m)
    public static int editDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        // initialisation
        for(int i=0; i<n+1; i++){
            dp[i][0] = i;
        }

        for(int j=0; j<m+1; j++){
            dp[0][j] = j;
        }

        // filling
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add, Math.min(del, replace));
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
        String word1 = "intention";
        String word2 = "execution";
        
        System.out.println(editDistance(word1, word2));
    }
}
