// reverse a string using a stack
import java.util.Stack;

public class Question2 {

    public static String reverse(String str){
        Stack<Character>s=new Stack<>();

        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        StringBuilder sb =new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str= "Hello World";
        String rev=reverse(str);
        System.out.println(rev);
    }
}
