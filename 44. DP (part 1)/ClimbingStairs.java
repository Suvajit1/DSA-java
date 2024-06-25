// Climbing Stairs
// fibonacci base prob.

public class ClimbingStairs {
    // recursion
    // O(2^n)
    public static int countWays(int n){
        if(n==0) return 1;
        if(n<0) return 0;

        return countWays(n-1) + countWays(n-2);
    }

    // DP
    // memorisation
    // O(n)
    public static int countWaysM(int n, int[] way){
        if(n<0) return 0;
        if(n==0) return 1;

        if(way[n] != 0){
            return way[n];
        }
        way[n]=countWaysM(n-1, way)+countWaysM(n-2, way);
        return way[n];
    }

    // tabulation
    // O(n)
    public static int countWaysT(int n){
        if(n<0) return 0;

        int[] dp = new int[n+1];
        dp[0]=1;
        // dp[1]=1;

        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i] = dp[i-1];
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=6;
        System.out.println(countWays(n));

        int[] way = new int[n+1];
        System.out.println(countWaysM(n,way));

        System.out.println(countWaysT(n));
    }
}
