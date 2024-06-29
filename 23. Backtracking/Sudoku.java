public class Sudoku {
    public static void printSudoku(int[][] sudoku){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(sudoku[i][j]==0){
                    if(j==2 || j==5){
                        System.out.print(" |");
                    }else{
                        System.out.print("  ");
                    }

                }else{
                    if(j==2 || j==5){
                        System.out.print(sudoku[i][j]+"|");
                    }else{
                        System.out.print(sudoku[i][j]+" ");
                    }
                }
            }
            System.out.println();
            if(i==2||i==5){
                System.out.println("-----------------");
            }
        }
    }

    public static boolean solveSudoku(int[][] sudoku, int row, int col){
        // base
        if(row==9){
            return true;
        }

        // resursion
        int nextRow = row, nextCol = col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col]!=0){
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for(int digit=1; digit<=9; digit++){
            if(issafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(solveSudoku(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }

        return false;
    }

    public static boolean issafe(int[][] sudoku, int r, int c, int val){
        // row
        for(int j=0; j<9; j++){
            if(sudoku[r][j]==val){
                return false;
            }
        }
        // col
        for(int i=0; i<9; i++){
            if(sudoku[i][c]==val){
                return false;
            }
        }
        // room
        int sr=(r/3)*3;
        int sc=(c/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j]==val){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] sudoku = { {0,0,4,6,0,5,8,0,0},
                           {6,0,0,0,0,0,0,0,0},
                           {0,0,0,0,4,7,6,0,5},
                           {2,8,0,3,0,0,0,0,0},
                           {7,4,0,0,0,8,2,5,0},
                           {0,0,0,0,0,0,9,0,0},
                           {0,2,5,7,0,0,3,6,0},
                           {4,3,0,0,2,0,0,8,0},
                           {0,0,0,8,6,3,5,4,0}};

        printSudoku(sudoku);
        System.out.println(solveSudoku(sudoku, 0, 0));
        printSudoku(sudoku);
    }
}
