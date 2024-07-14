// Question 1 : For a given integer array of size N. You have to find all the occurrences
// (indices) of a given element (Key) and print them. Use a recursive function to solve this
// problem.
// Sample Input : arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
// Sample Output : 1 5 7 8

public class AssQs1 {

    public static void findElement(int[] arr, int key, int idx){
        if(idx == arr.length){
            System.out.println();
            return;
        }

        if(arr[idx] == key){
            System.out.print(idx+" ");
        }
        findElement(arr, key, idx+1);
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;

        findElement(arr, key, 0);
    }
}