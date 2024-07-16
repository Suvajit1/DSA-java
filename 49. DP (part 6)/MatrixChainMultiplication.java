// Matrix Chain Multiplication

public class MatrixChainMultiplication {

    // recursion
    // Time Comlpexity : O(2^n)
    public static int mcm(int arr[], int i, int j){
        if(i==j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k); // set 1 -> X
            int cost2 = mcm(arr, k+1, j);   // set 2 -> Y

            int cost3 = arr[i-1] * arr[k] * arr[j]; // cost to find XY

            int totalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, totalCost);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length; 

        int minCost = mcm(arr, 1, n-1);

        System.out.println(minCost);
    }
}
