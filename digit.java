import java.util.Scanner;

public class digit {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num, n,r,d=0;
        System.out.println("Enter any number ");
        num=sc.nextInt();
        n=num;
        while(n>0){
            d++;
            r=n%10;
            System.out.println("Digit at "+d+"th place is "+r);
            n=n/10;
        }
        System.out.println("No of digit = "+d);

            // Amstrong number
        int sum=0;
        n=num;
        while(n>0){
            r=n%10;
            sum=sum+(r*r*r);
            n=n/10;
        }
        if(sum==num)
            System.out.println(num+" is an amstrong number");
        else
            System.out.println(num+" is not an amstrong number");

            //  reverse a number 
        int revnum=0;
        n=num;
        while(n>0){
            r=n%10;
            revnum=revnum*10+r;
            n=n/10;
        }
        System.out.println("Reverse of the number is "+revnum);
        if (num==revnum)
            System.out.println(num+" is a palindrom number");
        else
            System.out.println(num+" is not a palindrom number");
            
        sc.close();
        }
    }
