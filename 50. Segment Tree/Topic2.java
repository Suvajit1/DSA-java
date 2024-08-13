// max/min Element Queries

public class Topic2 {
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    // creat - O(n)
    public static void builtST(int arr[], int i, int st, int end){
        if(st == end){
            tree[i] = arr[st];
            return;
        }

        int mid = (st+end)/2;
        builtST(arr, 2*i+1, st, mid);
        builtST(arr, 2*i+2, mid+1, end);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    // query - O(logn)
    public static int getMax(int[] arr, int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
        if(qi>sj || qj<si){
            return Integer.MIN_VALUE;
        }
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        else{
            int mid = (si+sj)/2;
            int l = getMaxUtil(2*i+1, si, mid, qi, qj);
            int r = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(l,r);
        }

    }

    // update
    public static void update(int[] arr, int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, newVal);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal){
        if(si>idx || sj<idx){
            return;
        }

        // tree[i] = Math.max(newVal, tree[i]);
        if(si == sj){
            tree[i] = newVal;
        }

        if(si != sj){
            tree[i] = Math.max(newVal, tree[i]);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    } 

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        init(n);
        builtST(arr, 0, 0, n-1);
        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();

        System.out.println(getMax(arr, 2, 5));
        System.out.println(getMax(arr, 5, 8));
        System.out.println(getMax(arr, 0, 3));

        update(arr, 2, 20);
        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
    }
}
