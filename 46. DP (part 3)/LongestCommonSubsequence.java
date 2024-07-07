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

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length(); 

        System.out.println(LCS(str1, str2, n, m));
    }    
}
