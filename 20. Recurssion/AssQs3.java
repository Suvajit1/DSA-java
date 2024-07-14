// Question 3 : Write a program to find Length of a String using Recursion.

public class AssQs3 {
    public static int LengthOfString(String str){
        if(str == ""){
            return 0;
        }
        
        return LengthOfString(str.substring(1)) + 1;

    }
    public static void main(String[] args) {
        String str = "jgzkjqwja";

        System.out.println(LengthOfString(str));
        System.out.println(str.length());
    }
}
