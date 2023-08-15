/* to print A
            B C
            D E F
            G H I J
*/
import java.util.Scanner;

public class ABCD_parern {
    public static void main(String[] args) {
        char ch='A';
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of line : ");
        int n= sc.nextInt();
        for(int line=1;line<=n;line++){
            for(int no=1; no<=line; no++){
                System.out.print(ch +" ");
                ch++;
            }
            System.out.println();
        }
        sc.close();
    }
    
}