public class SpiralMatrix {

    public static void printSpiral(int[][] mtx){
        int sr=0, er=mtx.length-1;
        int sc=0, ec=mtx[0].length-1;

        while (sr<=er && sc<=ec) {
            // top
            for(int i=sc; i<=ec; i++){
                System.out.print(mtx[sr][i]+" ");
            }
            sr++;

            // left
            for(int i=sr; i<=er; i++){
                System.out.print(mtx[i][ec]+" ");

            }
            ec--;

            // buttom
            if(sr <= er){
                for(int i=ec; i>=sc; i--){
                    System.out.print(mtx[er][i]+" ");
    
                }
                er--;
            }

            // right
            if(sc<=ec){
                for(int i=er; i>=sr; i--){
                    System.out.print(mtx[i][sc]+" ");
                }
                sc++;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mtx = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                        {17, 18, 19, 20},
                        {21, 22, 23, 24}};
            
        printSpiral(mtx);

        int[][] brr = {{1},{2},{3},{4}};
        printSpiral(brr);

        int[][] crr = {{1,2,3,4,5}};
        printSpiral(crr);
    }
}
