public class Recursion {
    
    public static void printDecreasingOrder(int n){
        if(n>0){
            System.out.print(n+" ");
            printDecreasingOrder(n-1);
        }
        return;
    }

    public static void printIncreasingOrder(int n){
        if(n>=1){
            printIncreasingOrder(n-1);
            System.out.print(n+" ");
        }
        return;
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int sumOfNaturalNumber(int n){
        if(n==1){
            return 1;
        }
        return n+sumOfNaturalNumber(n-1);
    }

    public static int fibonachiNumber(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonachiNumber(n-1)+fibonachiNumber(n-2);
    }

    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccerence(int arr[],int i, int key){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccerence(arr, i+1, key);
    }
    // public static int lastOccerence(int arr[],int i, int key){
    //     if(i==-1){
    //         return -1;
    //     }
    //     if(arr[i]==key){
    //         return i;
    //     }
    //     return firstOccerence(arr, i-1, key);
    // }

    public static int lastOccerence(int arr[],int i, int key){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccerence(arr, i+1, key);

        if(isFound == -1 && arr[i]==key){
            return i;
        }

        return isFound ;
    }

    public static int power(int base,int index){
        if(index==0){
            return 1;
        }
        return base*power(base, --index );
    }
    public static int power_Optimized(int x,int n){
        int p=1;
        if(n==0){
            return p;
        }
        p=power_Optimized(x, n/2);
        if(n%2==0){
            p= p*p;
        }
        if(n%2==1){
            p= x*p*p;
        }
        return p;
    }

    public static int tilesProblems(int n){
        //base condition 
        if(n==0 || n==1){
            return 1;
        }
        int ways =tilesProblems(n-1)+tilesProblems(n-2);
        return ways;
    }

    public static void removrDuplicateChar(String str, int index, StringBuilder newStr, boolean map[]){
        if(index==str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar=str.charAt(index);
        if(map[currChar-'a']==true){
            removrDuplicateChar(str, index+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            newStr.append(currChar);
            removrDuplicateChar(str, index+1, newStr, map);
        }
    }

    public static int friendsPairing(int n){
        //base
        if(n==1 ||n==2 ){
            return n;
        }
        //single
        int single= friendsPairing(n-1);

        //pair
        int pair =(n-1)*friendsPairing(n-2);

        return single+pair;
    }

    public static void binaryStringNoConsqOne(int n, char lastchar, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        // if lastchar = 0 next is 0 or 1 & if lastchar = 1 then next char must be 0
        if(lastchar=='0'){
            binaryStringNoConsqOne(n-1, '0', str+"0");
            binaryStringNoConsqOne(n-1, '1', str+"1");
        }else{
            binaryStringNoConsqOne(n-1, '0', str+"0");

        }
        // binaryStringNoConsqOne(n-1, '0', str+"0");
        // if(last=='0'){
        //     binaryStringNoConsqOne(n-1, '1', str+"1");
        // }
    }
    public static void main(String[] args) {
        printDecreasingOrder(10);
        System.out.println();
        printIncreasingOrder(10);
        System.out.println();

        System.out.println(factorial(5));
        System.out.println(sumOfNaturalNumber(100));
        System.out.println(fibonachiNumber(8));

        int A[] ={1,2,3,4,5};
        System.out.println(isSorted(A, 0));

        int B[]={3,4,5,2,1};
        System.out.println(isSorted(B, 0));

        int number[]={8,3,6,9,5,10,2,5,3};
        System.out.println(firstOccerence(number, 0, 5));
        System.out.println(firstOccerence(number, 0, 12));
        // System.out.println(lastOccerence(number, number.length-1, 5));
        // System.out.println(lastOccerence(number, number.length-1, 12));
        System.out.println(lastOccerence(number, 0, 5));
        System.out.println(lastOccerence(number, 0, 12));

        System.out.println(power(2, 10));
        System.out.println(power_Optimized(2, 10));

        System.out.println(tilesProblems(4));

        String s="appnnacollege";
        removrDuplicateChar(s, 0, new StringBuilder(""), new boolean[26]);

        System.out.println(friendsPairing(5));
        binaryStringNoConsqOne(3, '0', "");

    }
}
