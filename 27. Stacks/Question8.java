import java.util.Stack;

public class Question8{

    public static int maxArea(int[] height){
        Stack<Integer> s= new Stack<>();

        // next smaller left
        int smallerLeft[]=new int[height.length];

        for(int i=0;i<height.length;i++){
            while(!s.empty() && height[i] <= height[s.peek()] ){
                s.pop();
            }

            if(s.empty()){
                smallerLeft[i]=-1;
            }else{
                smallerLeft[i]=s.peek();
            }

            s.push(i);
        }
     

        // next smaller right
        s=new Stack<>();
        int smallerRight[]=new int[height.length];

        for(int i=height.length-1;i>=0;i--){
            while(!s.empty() && height[i] <= height[s.peek()] ){
                s.pop();
            }

            if(s.empty()){
                smallerRight[i]=height.length;
            }else{
                smallerRight[i]=s.peek();
            }

            s.push(i);
        }

        int area[]=new int[height.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            int width=smallerRight[i]-smallerLeft[i]-1;
            area[i]=width*height[i];

            max=Math.max(max, area[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int height[]={2,1,5,6,2,3};
        System.out.println(maxArea(height));

        int h[]={2,4};
        System.out.println(maxArea(h));

    }
}