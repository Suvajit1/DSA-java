public class Day23_NQueen {

    public static void printBoard(char board[][]){
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    // initial function
    public static void nQueensinitial(char board[][], int row){
        //base
        if(row==board.length){
            printBoard(board);
            return;
        }

        for(int i=0;i<board.length;i++){
            board[row][i]='Q';
            nQueensinitial(board, row+1);  // function call 
            board[row][i]='X';  // backtracking step
        }
    }

    public static boolean isSafe(char board[][],int row, int col){
        // vertically up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // left up diag
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // right up diag
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true ;
    }
    static int count=0;

    public static void nQueens(char board[][], int row){
        //base
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isSafe(board, row, i)){
                board[row][i]='Q';
                nQueens(board, row+1);  // function call 
                board[row][i]='X';  // backtracking step
            }
        }
    }


    public static void main(String[] args) {
        int n=3;
        char board[][]=new char[n][n];
        // initialization
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }

        nQueens(board,0);
        System.out.println("Total no. of ways = "+count);


    }
}
