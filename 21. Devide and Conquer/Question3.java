// rotated sorted array with equal element

public class Question3 {

    public static boolean search(int arr[], int target){
        int si = 0;
        int ei = arr.length-1;

        while (si<=ei) {
            int mid = si+(ei-si)/2;

            if(arr[mid]==target){
                return true;
            }
            else if (arr[si]==arr[mid] && arr[mid]==arr[ei]) { //trim down
                si++;
                ei--;
            }
            else if(arr[si]<=arr[mid]){
                if(arr[si]<=target && target < arr[mid]){
                    ei = mid-1;
                }else{
                    si = mid+1;
                }
            }else{
                if(arr[mid]<target && target<=arr[ei]){
                    si = mid+1;
                }else{
                    ei = mid-1;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,3,3,3,3};
        int brr[] = {1,1,1,1,2,3,1};

        System.out.println(search(arr, 1));
        System.out.println(search(brr, 2));
    }
}
