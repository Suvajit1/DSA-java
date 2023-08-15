public class Day21_DivideAndConqure {
    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        // base
        if (si >= ei) {
            return;
        }

        // divide
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // left
        mergeSort(arr, mid + 1, ei); // right

        // merge
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        // size of temp[] = size of left[] + size of right[]
        int temp[] = new int[ei - si + 1];

        int i = si; // left
        int j = mid + 1;// right
        int k = 0; // temp

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for extra left
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // for extra rigth
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // coping temp to orignal array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void quickSort(int arr[], int si, int ei) {
        // base
        if (si >= ei) {
            return;
        }

        int pIdx = partition(arr, si, ei);

        quickSort(arr, si, pIdx - 1); // for left
        quickSort(arr, pIdx + 1, ei); // for right
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];

        int i = si - 1;

        for (int j = si; j <= ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        return i;
    }

    public static int search(int arr[], int target, int si, int ei) {
        // base case
        if (si > ei) {
            return -1;
        }

        // working
        int mid = si + (ei - si) / 2;

        if (target == arr[mid]) {
            return mid;
        }

        // case 1: line 1
        if (arr[si] <= arr[mid]) {

            // case a : left of line 1
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                // case b : right of mid
                return search(arr, target, mid + 1, ei);
            }
        }

        // case 2: line 2
        else {  // arr[mid] <= arr[ei]

            // case c : right of line 2
            if (arr[mid] <= target && target <= arr[si]) {
                return search(arr, target, mid + 1, ei);
            } else {
                // case d : lesft of mid
                return search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, 2 };
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);

        int brr[] = { 6, 3, 9, 5, 2, 8, -2, 2 };
        quickSort(brr, 0, brr.length - 1);
        printArray(brr);

        int Arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        printArray(Arr);
        int target = 0; // output -> 4
        int index = search(Arr, target, 0, Arr.length-1);
        System.out.println(index);
    }
}
