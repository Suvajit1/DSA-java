public class Classroom {
    // only recursion 
    // time complexity - O(2^n)
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    // DP
    // memorization
    public static int fib1(int n, int[] dp){    // O(n)
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = fib1(n-1, dp) + fib1(n-2, dp);
        return dp[n];
    }

    // tabulization
    // O(n)
    public static int fib2(int n){
        // initialization       // meaning
        int[] dp = new int[n+1];
        dp[1] = 1;

        // filling
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=6;
        System.out.println(fib(n));

        System.out.println(fib1(n, new int[n+1]));
        System.out.println(fib2(45));
    }
}