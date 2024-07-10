// String Convertion
// variation of edit distence

public class StringCovertion {

    // total no. of operation
    public static int convertString(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

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
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;

                    dp[i][j] = Math.min(add, del);
                }
            }
        }

        return dp[n][m];
    }

    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

        System.out.println("Total no. of operation : "+convertString(str1, str2));

        int lcs = lcs(str1, str2);
        int del = str1.length() - lcs;
        int add = str2.length() - lcs;
        System.out.println("Total no. of delete operation : "+del);
        System.out.println("Total no. of addition operation : "+add);
    }
}
