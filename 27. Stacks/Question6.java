// Valid Parethesis
import java.util.Stack;

public class Question6 {
    public static boolean isValidParenthesis(String str){
        Stack<Character> s= new Stack<>();

        for(int i=0; i<str.length();i++){
            char c =str.charAt(i);

            // open brackets
            if(c=='(' || c=='{' || c=='['){
                s.push(c);
            }
            // closing brackets
            else if(!s.isEmpty() && (c==')' && s.peek()=='(' || c=='}' && s.peek()=='{' || c==']' && s.peek()=='[')){
                s.pop();
            }else{
                return false;
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String str1 = "({[]}())";
        System.out.println(isValidParenthesis(str1));

        String str2 = "({[]}))";
        System.out.println(isValidParenthesis(str2));

        String str3 = "}";
        System.out.println(isValidParenthesis(str3));

        String str4 = "(p)";
        System.out.println(isValidParenthesis(str4));
    
    }    
}
