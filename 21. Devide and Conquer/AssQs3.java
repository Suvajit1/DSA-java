// Given an array of integers. Find the Inversion Count in the array. (HARD)
// Inversion Count: For an array, inversion count indicates how far (or close) the array is from
// being sorted. If the array is already sorted then the inversion count is 0. If an array is
// sorted in the reverse order then the inversion count is the maximum.
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// Sample Input 1: N = 5, arr[ ] = {2, 4, 1, 3, 5}
// Sample Output 1: 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).

public class AssQs3 {
    public static int inversionCount(int[] arr, int si, int ei){
        int inversion = 0;
        if(si< ei) {
            int mid = si + (ei-si)/2;

            inversion = inversionCount(arr, si, mid);
            inversion += inversionCount(arr, mid+1, ei);
            inversion += merge(arr, si, mid, ei);
        }

        return inversion;
    }

    public static int merge(int[] arr, int si, int mid, int ei){
        int i=si;
        int j=mid+1;
        int k=0;
        int[] temp = new int[ei-si+1];

        int inversion = 0;
        while (i<=mid && j<=ei) {
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else{
                // inversion condition
                temp[k] = arr[j];
                j++;
                k++;
                inversion += (mid+1-i);
            }
        }

        while (i<=mid) {
            temp[k++] = arr[i++];
        }

        while (j<=ei) {
            temp[k++] = arr[j++];
        }

        for(i=si, k=0; k<temp.length; i++,k++){
            arr[i]=temp[k];
        }

        return inversion;
    }

    public static void main(String[] args) {
        // int arr[] = {2, 4, 1, 3, 5}; 
        int arr[] = {5, 3, 2, 4, 1};
        int n=arr.length;

        int inversion = inversionCount(arr, 0, n-1);
        System.out.println(inversion);
    }
}
