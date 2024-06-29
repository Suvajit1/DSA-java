import java.util.Arrays;

public class NQuene {
    public static void print(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void NQuenePos(char[][] board, int row){  // O(n!)
        if(row==board.length){
            count++;
            print(board);
            System.out.println("-------------------");
            return;
        }

        for(int j=0; j<board[row].length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                NQuenePos(board, row+1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int r, int c){
        // up
        for(int i=r-1; i>=0; i--){
            if(board[i][c]=='Q'){
                return false;
            }
        }

        // left diagonal
        for(int i=r-1, j = c-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // right diagonal
        for(int i=r-1,j=c+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static boolean NQueneOne(char[][] board, int row){
        if(row==board.length){
            print(board);
            return true;
        }

        for(int j=0; j<board[row].length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(NQueneOne(board, row+1)){
                    return true;
                }
                board[row][j] = '.';
            }
        }
        return false;
    }
 
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++){
            Arrays.fill(board[i], '.');
        }
        print(board);
        System.out.println("-------------------");
        NQuenePos(board, 0);
        System.out.println("No of possible position : "+count);
        NQueneOne(board,0);
    }
}
