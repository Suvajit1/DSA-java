
public class QuickSort {

    public static void printArray(int[] arr){
        for(int x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    // TC = O(nlogn) [ avg case but in worst case O(n^2) ]
    // SC = O(1) 
    public static void quickSort(int arr[], int low, int high){
        if(low>=high) return;

        int pIdx = partitionFunction(arr, low, high);
        quickSort(arr, low, pIdx-1);
        quickSort(arr, pIdx+1, high);
    }

    public static int partitionFunction(int arr[], int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i<j) {
            while (i<=high && arr[i]<=pivot) {
                i++;
            }
            while (j>=low && arr[j]>pivot ) {
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {
        int arr[] = {4,6,2,5,7,9,1,3};
        // int arr[] = {2,5,8,1,3,6};
        printArray(arr);

        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
