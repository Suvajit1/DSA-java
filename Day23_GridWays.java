public class Day23_GridWays {

    public static int gridWays(int x, int y, int n, int m){
        //base
        if(x==n-1 && y==m-1){
            return 1;
        }
        else if(x==n || y==m){
            return 0;
        }
        // recursion
        // total = right ways + down ways 
        return gridWays(x, y+1, n, m)+ gridWays(x+1, y, n, m);
    }

    public static int fact(int f){
        if(f==0){
            return 1;
        }
        return f*fact(f-1);
    }

    public static int gridWaysOptimized(int x, int y, int M, int N){
        int m=M-1-x;  // down move
        int n=N-1-y;  // right move
        return fact(m+n)/(fact(m)*fact(n));
    }
    public static void main(String[] args) {
        int ways = gridWays(0, 0, 3, 3);
        System.out.println(ways);

        System.out.println(gridWaysOptimized(0, 0, 3, 3));
        System.out.println(gridWaysOptimized(1, 1, 4, 4));

    }

}
