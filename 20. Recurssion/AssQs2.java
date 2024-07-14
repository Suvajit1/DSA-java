// Question 2 :
// You are given a number (eg -  2019), convert it into a String of english like
// “two zero one nine”.  Use a recursive function to solve this problem.
// NOTE - The digits of the number will only be in the range 0-9 and the last digit of a number
// can’t be 0.
// Sample Input : 1947
// Sample Output : “one nine four seven”

public class AssQs2 {

    static String digit[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void printNumber(int n){
        if(n == 0){
            return;
        }

        int lastDigit = n%10;
        printNumber(n/10);

        System.out.print(digit[lastDigit]+" ");
    }
    public static void main(String[] args) {

        int num = 1947;
        printNumber(num);
        System.out.println();
    }
}
