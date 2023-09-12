//Stock span problem
import java.util.Stack;

public class Queston4 {

    public static void stochSpan(int[] stacks, int[] span){
        Stack<Integer> s =new Stack<>();

        span[0]=1;
        s.push(0);

        for(int i=1; i<stacks.length;i++){
            int currPrice=stacks[i];

            while(!s.isEmpty() && currPrice >= stacks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[]={100, 80, 60, 70, 60, 85, 100};
        int span[]= new int[stocks.length];

        stochSpan(stocks, span);
        for(int i=0; i<span.length;i++){
            System.out.println(span[i]);
        }
    }
}
