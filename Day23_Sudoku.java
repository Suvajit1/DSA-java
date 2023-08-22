public class Day23_Sudoku {
    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<sudoku.length; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
                if(j==2 || j==5){
                    System.out.print("| ");
                }
            }
            if(i==2 || i==5){
                    System.out.print("\n----------------------");
                }
            System.out.println();
        }
    }

    public static boolean isSafe(int sudoku[][], int digit, int row , int col){
        // row
        for(int j=0;j<sudoku.length;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        // col
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        // same grid
        int sr=( row/3)*3;
        int sc= (col/3)*3;
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        // base
        if(row==9){
            return true;
        }

        int nextrow= row, nextcol= col+1; 
        if(col+1==9){
            nextcol=0;
            nextrow=row+1;
        }

        // recursion
        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextrow, nextcol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku, digit, row , col)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextrow, nextcol)){
                    return true;
                }else{
                    sudoku[row][col]=0;     // backtracking step
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int sudoku[][]={{0, 0, 8, 0, 0, 0, 0, 0, 0},
                        {4, 9, 0, 1, 5, 7, 0, 0, 2},
                        {0, 0, 3, 0, 0, 4, 1, 9, 0},
                        {1, 8, 5, 0, 6, 0, 0, 2, 0},
                        {0, 0, 0, 0, 2, 0, 0, 6, 0},
                        {9, 6, 0, 4, 0, 5, 3, 0, 0},
                        {0, 3, 0, 0, 7, 2, 0, 0, 4},
                        {0, 4, 9, 0, 3, 0, 0, 5, 7},
                        {8, 2, 7, 0, 0, 9, 0, 1, 3}};
        System.out.println("Question ");
        printSudoku(sudoku);
        sudokuSolver(sudoku, 0, 0);
        System.out.println("Answer ");
        printSudoku(sudoku);

        int sudoku1[][]={{0, 0, 0, 0, 9, 0, 0, 2, 0},
                        {4, 0, 2, 5, 0, 0, 0, 6, 0},
                        {0, 5, 3, 0, 7, 0, 0, 4, 0},
                        {0, 7, 8, 0, 0, 1, 0, 0, 0},
                        {9, 0, 0, 0, 5, 0, 0, 0, 0},
                        {0, 4, 0, 6, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 7, 0, 0, 2},
                        {5, 0, 0, 0, 4, 0, 7, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 6}};
        System.out.println("Question ");
        printSudoku(sudoku1);
        sudokuSolver(sudoku1, 0, 0);
        System.out.println("Answer ");
        printSudoku(sudoku1);
    }
}
