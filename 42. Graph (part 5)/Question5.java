// Flood fill Algorithm

public class Question5 {
    public static void helper(int[][] image, int r, int c, int color, boolean vis[][], int orgCol){
        // base case
        if(r<0 || c<0 || r>=image.length || c>=image[0].length || image[r][c] != orgCol){
            return;
        }else{
            image[r][c] = color;
        }

        // recursive call
        // left
        helper(image, r, c-1, color, vis, orgCol);

        // right
        helper(image, r, c+1, color, vis, orgCol);

        // up
        helper(image, r-1, c, color, vis, orgCol);

        // down
        helper(image, r+1, c, color, vis, orgCol);

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int orgCol = image[sr][sc];
        boolean vis[][] = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, vis, orgCol);
        return image;
    }
    public static void main(String[] args) {
        int image[][] = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};

        floodFill(image, 1, 1, 2);
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++){
                System.out.print(image[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
