//heap sort O(nlog(n))

public class topic5HeapSort {

    public static void heapify(int[]arr, int i, int size) { //O(log(n))
        int left = 2*i+1;
        int right = 2*i+2;

        int maxIdx = i;

        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx=right;
        }

        if(maxIdx != i){
            // swap
            int temp = arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int[] arr){ //O(nlog(n))
        // step1 - built maxheap
        int n= arr.length;
        for(int i= n/2; i>=0; i--){ // O(n/2.log(n))
            heapify(arr,i,n);
        }

        // step2 - push largest at end
        for(int i=n-1;i>0;i--){    // O((n-1)log(n))
            //swap
            int temp =arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);

        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};
        heapSort(arr);

        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
