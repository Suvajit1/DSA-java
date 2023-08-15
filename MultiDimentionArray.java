import java.util.Scanner;

public class MultiDimentionArray {

    public static void print(int mtx[][]){
        for(int i=0;i<mtx.length;i++){
            for(int j=0;j<mtx[i].length;j++){
                System.out.print(mtx[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean search(int mtx[][], int key){
        for(int i=0;i<mtx.length;i++){
            for(int j=0;j<mtx[i].length;j++){
                if(key==mtx[i][j]){
                    System.out.println("key found at cell ("+i+", "+j+")");
                    return true;
                }
            }
        }
        System.out.println("not found");
        return false;
    }

    public static void sprilePrint(int mtx[][]){
        //initial index
        int startRow=0;
        int startCol=0;
        int endRow=mtx.length-1;
        int endCol=mtx[0].length-1;
        int n=mtx.length*mtx[0].length;
        int count=0;

        while(startRow<=endRow && startCol<=endCol ){
            //top
            for(int i=startCol; i<=endCol && count<n; i++){
                System.out.print( mtx[startRow][i] +" ");
                count++;
            }
            startRow++;

            //right
            for(int i=startRow; i<=endRow && count<n; i++){
                System.out.print( mtx[i][endCol] +" ");
                count++;
            }
            endCol--;

            //bottom
            for(int i=endCol; i>=startCol && count<n; i--){
                System.out.print( mtx[endRow][i] +" ");
                count++;
            }
            endRow--;

            //left
            for(int i=endRow; i>=startRow && count<n; i--){
                System.out.print( mtx[i][startCol] +" ");
                count++;
            }
            startCol++;
        }
        System.out.println();
    }

    public static void diagonalSum(int arr[][]){
        // int pdSum=0, sdSum=0,diaSum;
        // int n=arr.length;

        // for(int i=0;i<arr.length;i++){
        //     pdSum += arr[i][i] ;
        // }
        // for(int i=0,j=arr.length-1;i<arr.length;i++,j--){
        //     sdSum += arr[i][j];
        // }

        // if (n%2==0){
        //     diaSum=pdSum+sdSum;
        // }else{
        //     diaSum = pdSum+sdSum-arr[n/2][n/2];
        // }

        int diaSum=0,n=arr.length;

        for(int i=0;i<n;i++){
            diaSum += arr[i][i];

            if(i != n-1-i){
                diaSum +=arr[i][n-1-i];
            }
        }

        System.out.println("Diagonal Sum = "+ diaSum);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // int matrix[][]=new int[3][3];
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         matrix[i][j]=sc.nextInt();
        //     }
        // }
        sc.close();
        // print(matrix);

        int m[][]={{1,2,3,4},{2,3,4,5},{3,4,5,6}};
        print(m);
        search(m, 5);

        int m1[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
        print(m1);

        sprilePrint(m1);

        int m2[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12}};
        print(m2);

        sprilePrint(m2);

        int m3[][]={{1,2,3},
                    {4,5,6},
                    {7,8,9}};
        print(m3);

        sprilePrint(m3);

        int m4[][]={{1,2,3},
                    {4,5,6},
                    {7,8,9},
                    {10,11,12}};
                    
        print(m4);
        sprilePrint(m4);

        diagonalSum(m1);

        int m5[][]={{1,2,3},
                    {4,5,6},
                    {7,8,9}};

        diagonalSum(m5);
    }
}