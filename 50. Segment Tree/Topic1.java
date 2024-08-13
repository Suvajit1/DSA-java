// Segment Tree

public class Topic1{

    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    // O(n)
    public static void builtST(int arr[], int i, int si, int ei){
        if(si == ei){
            tree[i] = arr[si];
            return;
        }
        
        int mid = (si+ei)/2;
        builtST(arr, 2*i+1, si, mid);   // left
        builtST(arr, 2*i+2, mid+1, ei);   // right

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }

    // query O(logn)
    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj){
        if(qj < si || qi > sj){
            return 0;
        }
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        else{
            int mid = (si+sj)/2;
            int l = getSumUtil(2*i+1, si, mid, qi, qj);
            int r = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return l+r;
        }
    }

    // update O(logn)
    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, diff);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx < si || idx > sj){
            return;
        }
        tree[i] += diff;
        if(si != sj){
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);
        builtST(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getSum(arr, 3, 6));

        update(arr, 2, 2);
        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getSum(arr, 2, 5));

    }
}