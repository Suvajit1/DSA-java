
public class MergeSort {
    public static void printArray(int[] arr){
        for(int x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    // TC = O(nlogn)
    // SC = O(n)
    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei) return;

        int mid = si + (ei -si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[(mid+1 -si) + (ei -mid)];

        int k = 0;
        int i = si;
        int j = mid+1;

        while (i<=mid && j<= ei) {
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k]= arr[j];
                j++;
            }
            k++;
        }

        while (i<=mid) {
            temp[k] = arr[i];
            i++; k++;
        }

        while (j<=ei) {
            temp[k]= arr[j];
            j++; k++;
        }

        for(i=si,k=0; i<=ei; i++,k++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,5,8,1,3,6};
        printArray(arr);

        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
