public class DiagonalSum {

    public static int diagonalSum(int[][] mtx){
        int sum = 0;
        int n=mtx.length-1;

        for(int i=0; i<=n; i++){
            // principal diagonal
            sum += mtx[i][i];

            // non principla diagonal
            if(n-i != i){
                sum+=mtx[n-i][i];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        int[][] mtx1 = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

        System.out.println(diagonalSum(mtx1));

        int[][] mtx2 = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        System.out.println(diagonalSum(mtx2));
    }
}
