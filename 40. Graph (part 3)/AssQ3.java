// Minimum time required to rot all oranges

import java.util.LinkedList;
import java.util.Queue;

public class AssQ3 {
    static class Info {
        int i;
        int j;
        int time;

        public Info(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.time = t;
        }
    }

    public static int rottenTime(int[][] oranges){
        if(oranges == null || oranges.length == 0){
            return 0;
        }

        // rotten orenge put in queue
        // queue contains possiton of rotten orenge and time of rotten 
        Queue<Info> q = new LinkedList<>();

        int freshOrenge = 0;
        for(int i=0; i<oranges.length; i++){
            for(int j=0; j<oranges[0].length; j++){
                if(oranges[i][j]==1){
                    freshOrenge++;
                }
                if(oranges[i][j]==2){
                    q.add(new Info(i, j, 0));
                }
            }
        }

        int time=0; 

        while (!q.isEmpty()) {
            Info curr = q.remove();
            int i=curr.i;
            int j=curr.j;
            time = curr.time;

            // travel
            // up
            if(rotPossible(i-1, j, oranges)){
                q.add(new Info(i-1, j, time+1));
                freshOrenge--;
            }

            // down
            if(rotPossible(i+1, j, oranges)){
                q.add(new Info(i+1, j, time+1));
                freshOrenge--;
            }

            // left
            if(rotPossible(i, j-1, oranges)){
                q.add(new Info(i, j-1, time+1));
                freshOrenge--;
            }

            // right
            if(rotPossible(i, j+1, oranges)){
                q.add(new Info(i, j+1, time+1));
                freshOrenge--;
            }
        }

        if(freshOrenge != 0){
            return -1;
        }else{
            return time;
        }
    }

    public static boolean rotPossible(int r, int c, int[][] oranges){
        if(r >= 0 && r < oranges.length && c >=0 && c < oranges[0].length && oranges[r][c] == 1){
            oranges[r][c]=2;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] oranges = { {2, 1, 1},
                            {1, 1, 0},
                            {0, 1, 1} };
        
        int[][] oranges1 ={ {2, 1, 0, 2, 1},
                            {0, 0, 1, 2, 1},
                            {1, 0, 0, 2, 1} };

        System.out.println(rottenTime(oranges));
        System.out.println(rottenTime(oranges1));
    }
}
