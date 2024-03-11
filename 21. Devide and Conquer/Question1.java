// searching in a rotated sorted array

public class Question1 {

    public static int search(int arr[], int target, int si, int ei){
        if(si>ei) {
            return -1;
        }

        int mid = (si + ei)/2;

        if(arr[mid] == target){
            return mid;
        }

        // l1
        if(arr[0] <= arr[mid]){
            if(arr[si] <= target && target <= arr[mid]){
                // case 1 -- left part
                return search(arr, target, si, mid-1);
            }else{
                // case 2 -- right part
                return search(arr, target, mid+1, ei);
            }
        }else{
        // l2
            if(arr[ei] >= target && target >= arr[mid]){
                // case 2 -- right part
                return search(arr, target, mid+1, ei);
            }else{
                // case 1 -- left part
                return search(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,8,0,1,2,3};
        int target = 6;

        int pos = search(arr, target, 0, 8);
        System.out.println(pos);
    }
}
