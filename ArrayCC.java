public class ArrayCC {
    public static void update(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
    }

    public static void print(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int linearSerach(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int maxValue(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int minValue( int arr[]){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;

    }

    public static int binarySearch(int arr[],int key){
        int start = 0;
        int end = arr.length-1;
        
        while(start <= end){
            int mid= (start+end)/2;

            if(arr[mid] == key){
                return mid ;
            }
            if(arr[mid]< key){
                start= mid+1;
            }else{
                end= mid-1;
            }
        }
        return -1;
    }

    public static void reverse(int arr[]){
        int temp; 
        int n=arr.length;

        for(int i=0; i<n/2; i++){
            temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }

    public static void all_pairs(int arr[]){
        int n=arr.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                System.out.print("("+arr[i]+", "+arr[j]+") ");
                if(arr[i] != arr[j]){
                    System.out.print("("+arr[j]+", "+arr[i]+") ");
                }
            }
        }
        System.out.println();
    }

    public static void pairs(int arr[]){
        int tp=0;
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("("+arr[i]+", "+arr[j]+") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total nos of pair "+tp);
    }

    public static void print(int arr[],int s,int e){
        System.out.print("{ ");
        for(int i=s;i<=e;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("} ");
    }

    public static void print_subarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                print(arr, i, j);
            }
            System.out.println();
        }
    }

    public static void printSubarray(int arr[]){
        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            // i = start index
            for(int j=i;j<arr.length;j++){
                // j = end index
                int sum=0;
                for(int k=i;k<=j;k++){  // print elements between i and j
                    System.out.print(arr[k]+" ");
                    sum=sum+arr[k];
                }
                System.out.println();

                if(sum>max){
                    max=sum;
                }
                if(sum<min){
                    min=sum;
                }
            }
            System.out.println(); 
        }
        System.out.println("Min sum of Subarray : "+min);
        System.out.println("Max sum of Subarray : "+max);

    }

    public static void subarray_sum(int arr[]){     // O(n^3)
        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum = sum + arr[k];
                }
                if(sum>max){ max = sum; }
                if(sum<min){ min = sum; }
            }
        }
        System.out.println("Min sum of Subarray : "+min);
        System.out.println("Max sum of Subarray : "+max);
    } 

    public static void prefixArray_MaxSubarraySum(int arr[]){     // O(n^2)

        int max= Integer.MIN_VALUE;
        int sum=0;

        int prefix[]=new int[arr.length];
        // calculate prefix array
        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        System.out.print("prefix array : ");
        print(prefix);

        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end =j;

                sum = start==0 ? prefix[end] : prefix[end]-prefix[start-1];
            }
            if(sum>max){ max=sum; }
        }
        System.out.println("Max sum of Subarray : "+max);
    }
    
    public static void MaxSubarraySum_KadanesAlgo(int arr[]){   //O(n)
        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(cs+arr[i]>0){
                cs=cs+arr[i];
            }else{
                cs=0;
            }
            if(cs>ms){ ms=cs; }
        }
        if(ms==0){
            ms=maxValue(arr);
        }
        System.out.println("Max sum of Subarray : "+ms);
    }

    public static void main(String[] args) {
        int marks[] = { 2, 4, 6, 0, 10, 18, 9, 5 };
        print(marks);
        System.out.println(linearSerach(marks, 15));
        System.out.println(linearSerach(marks, 18));

        int m = maxValue(marks);
        System.out.println(m);

        int numbers[]={5, 7, 10, 12, 16, 20, 25, 30};
        int index = binarySearch(numbers, 22);
        System.out.println(index);

        print(numbers);
        reverse(numbers);
        print(numbers);

        int Num[]={2,4,6,8,10};
        all_pairs(Num);
        pairs(Num);
        print_subarray(Num);
        printSubarray(Num);
        int num[]={1,-2,6,-1,3};
        print(num);
        subarray_sum(num);
        prefixArray_MaxSubarraySum(num);

        MaxSubarraySum_KadanesAlgo(num);

        int num2[]={-2,-3,4,-1,-2,1,5,-3};
        MaxSubarraySum_KadanesAlgo(num2);

        int num3[]={-2,-4,-5,-4,-9};
        MaxSubarraySum_KadanesAlgo(num3);
    }
}
