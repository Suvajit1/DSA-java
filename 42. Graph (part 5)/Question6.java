package Graph;

public class Qs4 {
    // floid field Algo
    public static void floodFill(int[][] image, int sr, int sc, int color){
        int orgCol = image[sr][sc];
        boolean[][] vis = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, orgCol, vis);
    }

    public static void helper(int[][] image, int i, int j, int color, int orgCol, boolean[][] vis){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j] != orgCol || color==orgCol){
            return ;
        }else if(!vis[i][j]){
            vis[i][j] = true;
            image[i][j] = color;
            
            helper(image, i, j+1, color, orgCol, vis);
            helper(image, i, j-1, color, orgCol, vis);
            helper(image, i+1, j, color, orgCol, vis);
            helper(image, i-1, j, color, orgCol, vis);
        }
    }

    public static void main(String[] args) {
        int image[][] = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};

        floodFill(image, 0, 0, 2);
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++){
                System.out.print(image[i][j]+ " ");
            }
            System.out.println();
        }                 
    }
}
