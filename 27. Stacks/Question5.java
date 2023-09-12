// Next greater element

import java.util.Stack;
public class Question5 {
    //useing index
    public static void nextGreater(int []arr, int []nextGreater){

        Stack<Integer> s= new Stack<>();

        for(int i=arr.length-1; i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]= -1;
            }else{
                nextGreater[i]= arr[s.peek()];
            }

            s.push(i);
        }
    }

    // using direct value
    public static void nextGreater2(int []arr, int []nextGreater){

        Stack<Integer> s= new Stack<>();
        
        for(int i=arr.length-1; i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]= -1;
            }else{
                nextGreater[i]= s.peek();
            }

            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int []arr={6,8,0,1,3};
        int[] nextGreater = new int[arr.length];

        nextGreater(arr, nextGreater);
        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();

        int[] nextGreater2 = new int[arr.length];
        nextGreater2(arr, nextGreater2);
        for(int i=0;i<nextGreater2.length;i++){
            System.out.print(nextGreater2[i]+" ");
        }
        System.out.println();
    }
}
