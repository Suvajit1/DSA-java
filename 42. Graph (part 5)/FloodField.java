public class FloodField {

    // flood field Algorithm
    public static void floodFiedd(int[][] image, int r, int c, int color, boolean vis[][], int orgCol){
        // base case
        if(r < 0 || r >= image.length || c<0 || c>= image[0].length || vis[r][c] || image[r][c] != orgCol){
            return ;
        }
        // if(vis[r][c]){
        //     return;
        // }

        image[r][c] = color;
        vis[r][c] = true;
        
        // left
        floodFiedd(image, r, c-1, color, vis, orgCol);
        // right
        floodFiedd(image, r, c+1, color, vis, orgCol);
        // top
        floodFiedd(image, r-1, c, color, vis, orgCol);
        // down
        floodFiedd(image, r+1, c, color, vis, orgCol);
    }

    public static void main(String[] args) {
        int image[][] = { {1,1,1},
                          {1,1,0},
                          {1,0,1} };

        int sr = 1;
        int sc = 1;
        int color = 2;
        int orgcol = image[sr][sc];    
        boolean vis[][] = new boolean[image.length][image[0].length];   
        
        floodFiedd(image, sr, sc, color, vis, orgcol);

        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }     
}
