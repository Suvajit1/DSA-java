// Duplicate parenthesis
import java.util.Stack;

public class Question7 {
    public static boolean isDuplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            // oppening and variables and oparation
            if(ch != ')'){
                s.push(ch);
            }
            else{   // clossing
                int count=0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count!=0){
                    s.pop();
                }else{  // count = 0 means duplicate exist
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str="((a+b)+((b)))";
        System.out.println(isDuplicateParenthesis(str));

        String str1="((a+b)+(b))";
        System.out.println(isDuplicateParenthesis(str1));
    }    
}
