// searching in a rotated sorted array
// recurtion way
public class Question2 {
    public static int search(int arr[], int target){
        int si = 0;
        int ei = arr.length-1;

        while (si<=ei) {
            int mid= si +(ei-si)/2;
            if(arr[mid]==target){
                return mid;
            }
            //l1
            else if(arr[mid]>arr[si]){
                if(arr[mid]>target && target >= arr[si]){
                    ei = mid-1;
                }else{
                    si = mid+1;
                }
            }else{ //l2
                if(arr[mid]<target && target <= arr[ei]){
                    si = mid+1;
                }else{
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,8,0,1,2,3};

        System.out.println(search(arr, 1));
        System.out.println(search(arr, 6));
        System.out.println(search(arr, 12));
    }
}
