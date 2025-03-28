// count no. of BST possible for a given number of nodes

public class CountTrees {

    // O(n^2)
    public static int countBST(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<=i-1; j++){
                int left = dp[j];
                int right = dp[i-j-1];

                dp[i] += left*right;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n=4;

        System.out.println(countBST(n));
    }
}
