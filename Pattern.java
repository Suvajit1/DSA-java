/*  1. hollow rectanlge pattern   
        * * * * *
        *       *
        *       *
        * * * * * 

    2. inverted and rotated half pyramid patern
              *
            * *
          * * *
        * * * *  

    3. inverted half pyramid with numbers
        1 2 3 4 5
        1 2 3 4
        1 2 3
        1 2
        1

    4. Floyd's Triangle
        1
        2 3
        4 5 6
        7 8 9 10
        11 12 13 14 15

    5. 0-1 Triangle
        1
        0 1
        1 0 1
        0 1 0 1
        1 0 1 0 1

    6. Butterfly pattern
        *                 *
        * *             * *
        * * *         * * *
        * * * *     * * * * 
        * * * * * * * * * * 
        * * * * * * * * * *
        * * * *     * * * *
        * * *         * * *
        * *             * *
        *                 *

    7. solid rhombus
                * * * * *
              * * * * *
            * * * * *
          * * * * *
        * * * * *
    
    8. solid rhombus
                * * * * *
              *       *
            *       *
          *       *
        * * * * *

    9. Diamond Pattern
            *                     *
          * * *                 * * *
        * * * * *             * * * * *
      * * * * * * *   -->   * * * * * * *
      * * * * * * *           * * * * *
        * * * * *               * * * 
          * * *                   *
            *

 */

public class Pattern {
    public static void hollowRectPattern(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || j == 1 || i == row || j == col) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_rotated_half_Pyramid(int lineNo){
        // outer loop 
        for(int i=1;i<=lineNo;i++){
            // spaces
            for(int j=1;j<=lineNo-i;j++){
                System.out.print("  ");
            }
            // stars
            for (int k=1;k<=i;k++){
                System.out.print("* ");
            }
            // new line
            System.out.println();
        }
    }

    public static void inverted_half_Pyramid(int lineNo ){
        for(int i=1; i<=lineNo; i++){
            for(int j=1;j<=lineNo-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void floydTriangle(int lineNo){
        int count=1;
        for(int i=1;i<=lineNo;i++){
            for(int j=1;j<=i;j++){
                System.out.printf("%2d ", count++);
            }
            System.out.println();
        }
    }

    public static void triangle_01(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

    }
    public static void Butterfly(int n){
        //outer loop of upside
        for(int i=1;i<=n;i++){
            // Stars -i
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            // Spaces - 2*(n-i)
            for(int k=1;k<=2*(n-i);k++){
                System.out.print("  ");
            }
            // stars -i
            for(int l=1;l<=i;l++){
                System.out.print("* ");
            }
            // next line
            System.out.println();
        }
        // for mirror image
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            for(int k=1;k<=2*(n-i);k++){
                System.out.print("  ");
            }
            for(int l=1;l<=i;l++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
    public static void solid_rhombus(int n){
        for(int i=1; i<=n ; i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int k=1;k<=n;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n){
        for(int i=1; i<=n ; i++){
            //Spaces before starting of rhombus
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            // rhombus
            for(int k=1;k<=n;k++){
                if(i==1 || i==n || k==1 || k==n){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void Diamond(int n){
        // upper triangle
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        // lower inverted triangle
        for(int i=n-1;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        hollowRectPattern(4, 5);
        inverted_rotated_half_Pyramid(5);
        inverted_half_Pyramid(5);
        floydTriangle(5);
        triangle_01(5);
        Butterfly(5);
        solid_rhombus(5);
        hollow_rhombus(5);
        Diamond(5);
    }
}