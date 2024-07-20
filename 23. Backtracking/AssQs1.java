// Question 1 :
// Rat in a Maze
// You are given a starting position for a rat which isstuckinamazeataninitialpoint(0,0)(the
// maze can be thought of as a 2-dimensional plane). The maze wouldbegivenintheformofa
// square matrix of order N * N where the cells with value 0 represent the maze’s blocked
// locations while value 1 is theopen/availablepaththattheratcantaketoreachitsdestination.
// The rat's destination is at (N - 1, N - 1).
// Your task is to find all the possible paths that the rat can take to reach from source to
// destination in the maze.
// The possible directions that it can take to move in themazeare'U'(up)i.e.(x,y-1),'D'(down)
// i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).

// Sample Input : int maze[][] = { { 1, 0, 0, 0 },
// { 1, 1, 0, 1 },
// { 0, 1, 0, 0 },
// { 1, 1, 1, 1 } };

public class AssQs1 {

    public static void print(int[][] sol){
        for(int i=0; i<sol.length; i++){
            for(int j=0; j<sol[0].length; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void allPath(int maze[][], int sr, int sc, String path, int[][] sol){

        if(sr==maze.length-1 && sc==maze[0].length-1){
            sol[sr][sc] = 1;
            print(sol);
            System.out.println(path);
            sol[sr][sc] = 0;
            return;
        }
        
        if(isPossible(maze, sr, sc) && sol[sr][sc] != 1){

            sol[sr][sc]=1;

            // down
            allPath(maze, sr+1, sc, path+"D", sol);

            // rirht
            allPath(maze, sr, sc+1, path+"R", sol);

            sol[sr][sc]=0;
        }
        
    }

    public static boolean isPossible(int[][] maze, int r, int c){
        if(r<0 || c<0 || r>=maze.length || c>=maze[0].length || maze[r][c] == 0){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 1, 0 },
                         { 1, 1, 1, 1 } };

        int sol[][] = new int[maze.length][maze[0].length];

        allPath(maze, 0, 0, "", sol);
    }
}
