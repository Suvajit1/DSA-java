
public class AssQ4 {
    static int count;

    public static int maxRegion(int M[][]){
        boolean vis[][] = new boolean[M.length][M[0].length]; 

        int maxRegion = 0;

        for(int i=0; i<vis.length; i++){
            for(int j=0; j<vis[0].length; j++){
                if(M[i][j]==1 && !vis[i][j]){
                    count=0;
                    maxRegion=Math.max(maxRegion, maxRegionUtil(M, vis, i, j));
                }
            }
        }
        return maxRegion;
    }

    public static boolean isSafe(int[][] M, boolean [][] vis, int row, int col){
    
        if(row>=0 && row<M.length && col>=0 && col<M[0].length && !vis[row][col] && M[row][col]==1){ // safe
            vis[row][col] = true;   // visit
            return true;
        }
        return false;
    }

    public static int maxRegionUtil(int[][] M, boolean [][] vis, int row, int col){
        if(isSafe(M, vis, row, col)){
            count++;
            maxRegionUtil(M, vis, row-1, col-1);
            maxRegionUtil(M, vis, row-1, col);
            maxRegionUtil(M, vis, row-1, col+1);
            maxRegionUtil(M, vis, row, col-1);
            maxRegionUtil(M, vis, row, col+1);
            maxRegionUtil(M, vis, row+1, col-1);
            maxRegionUtil(M, vis, row+1, col);
            maxRegionUtil(M, vis, row+1, col+1);
        }

        return count;
    }

    public static void main(String[] args) {
       int M[][] = { {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1} };
       int M1[][] = { {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1} };
       int M2[][] = { {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 1, 1, 1} };


       System.out.println(maxRegion(M));
       System.out.println(maxRegion(M1));
       System.out.println(maxRegion(M2));

    }
}
