public class Day23_Backtracking {

    public static void printArray(int arr[] ){
        for(int x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int i, int val){
        //base
        if(i==arr.length){
            printArray(arr);
            return;
        }

        // recursion (working)
        arr[i]=val;
        changeArray(arr, i+1, val+1);   // function call step
        arr[i]=val-2;   // backtracking step
    }

    public static void findSubsets(String str, int i, String ans){
        // base
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        char posChar=str.charAt(i);

        // recursion
        // yes choice
        findSubsets(str, i+1, ans+posChar);
        // no choice
        findSubsets(str, i+1, ans);

    }

    public static void findPermutation(String str, String ans){
        //base
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        // recursion
        for(int i=0;i<str.length();i++){
            char curr= str.charAt(i);
            // "abcde" = "ab" + "de" 
            String newStr=str.substring(0, i)+str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }
    
    public static void main(String[] args) {
        int arr[]=new int[5];

        printArray(arr);
        changeArray(arr, 0, 1);
        printArray(arr);
        findSubsets("abc", 0, "");
        findPermutation("abc", "");

    }
}
