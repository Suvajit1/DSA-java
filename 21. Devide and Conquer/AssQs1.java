// Question 1 : Apply Merge sort to sort an array of Strings. (Assume that all the characters in
// all the Strings are in lowercase). (EASY)
// Sample Input 1: arr = { "sun", "earth", "mars", "mercury" }
// Sample Output 1: arr = { "earth", "mars", "mercury", "sun"}

public class AssQs1 {

    public static void mergeSort(String[] arr, int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String[] arr, int si, int mid, int ei){
        String temp[] = new String[ei-si+1];

        int i = si;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j<= ei) {
            if(compare(arr[i], arr[j])){    // arr[i] < arr[j]
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        while (j<=ei) {
            temp[k++] = arr[j++];
        }

        for(i=si, k=0; k<temp.length; i++,k++){
            arr[i] = temp[k];
        }
    }

    public static boolean compare(String str1, String str2){
        if(str1.compareTo(str2) < 0){
            return true;
        }
        return false;
    }

    public static void print(String[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr = {"sun", "earth", "mars", "mercury"};

        print(arr);
        mergeSort(arr, 0, arr.length-1);
        print(arr);
    }
}