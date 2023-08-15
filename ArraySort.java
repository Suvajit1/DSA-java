import java.util.Arrays;
import java.util.Collections;

public class ArraySort {
    public static void bubbleSort(int numners[]){
        int n=numners.length;

        for(int i=0;i<n-1;i++){
            int flag=0;     // addaptive --> to stop when array is sorted
            for(int j=0;j<n-1-i;j++){
                if(numners[j]>numners[j+1]){
                    int temp=numners[j+1];
                    numners[j+1]=numners[j];
                    numners[j]=temp;
                    flag=1;
                }
            }
            System.out.print("After "+(i+1)+"th pass ");
            print(numners);
            if(flag==0) {
                System.out.println("Array is sorted now ");
                break;}
        }
    }

    public static void print(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void print(Integer arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void selectionSort(int arr[]){
        int n=arr.length;

        for(int i=0;i<n-1;i++){
            int minPos=i;
            for(int j=i+1;j<n;j++){     // find the position with min value
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            int temp=arr[i];
            arr[i]=arr[minPos];
            arr[minPos]=temp;

            System.out.print("After "+(i+1)+"th pass ");
            print(arr);
        }

    }

    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;

            System.out.print("After "+(i)+"th pass ");
            print(arr);

        }
    }

    public static void countSort(int arr[]){
        int largest=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest, arr[i]);
        }

        int count[]=new int[largest+1];
        print(count);

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        print(count);

        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){    //O(m+n) ~ O(n)
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int A[]={8,5,7,3,2};
        System.out.print("\nActual array ");
        print(A);
        // bubbleSort(A);
        // selectionSort(A);
        insertionSort(A);
        System.out.print("\nAfter sorting ");
        print(A);

        int B[]={1,3,5,7,9};
        System.out.print("\nActual array ");
        print(B);
        // bubbleSort(B);
        // selectionSort(B);
        insertionSort(B);
        System.out.print("\nAfter sorting ");
        print(B);

        int C[]={1,4,1,3,2,4,3,7};
        countSort(C);
        print(C);

        int arr[]={5,6,2,8,3,7};
        print(arr);
        Arrays.sort(arr, 0,3);
        print(arr);
        Arrays.sort(arr);
        print(arr);

        Integer arr2[]={4,2,8,6,9,1};
        print(arr2);
        Arrays.sort(arr2,2,5,Collections.reverseOrder());
        print(arr2);
        Arrays.sort(arr2,Collections.reverseOrder());
        print(arr2);

    }
}