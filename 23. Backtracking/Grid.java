// find total no. of way to reach (m-1, n-1) from (0,0) in mXn grid

public class Grid {
    static int m = 3,n = 3;
    
    public static int totalGridWay(int sr, int sc){
        if(sr>=m || sc>=n){
            return 0;
        }

        if(sr==m-1 && sc==n-1){
            return 1;
        }
        //right move
        int r = totalGridWay(sr, sc+1);

        //down move
        int d = totalGridWay(sr+1, sc);

        return r+d;
    }
    public static void main(String[] args) {
        System.out.println(totalGridWay(0,0));
    }
}
